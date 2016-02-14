/**
 * @author Lin Qian
 * @version 1.0
 * @since 8th November 2014
 */
package oops;

import java.util.LinkedHashMap;
import java.util.Map;

public class SalesReport {
	protected Map<MenuItem,Sales> sales=new LinkedHashMap<MenuItem,Sales>();
	ConvertFromFile cnv=new ConvertFromFile();
	/**
	 * Initializes the Sales array by deserializing it from a file
	 */
	public SalesReport(){
		salesFromFile();
	}
	/**
	 * Add an item to sales
	 */
	public void addSalesItem(MenuItem item){
		
			Sales sale=new Sales(item.getName());
			sales.put(item,sale);

	}
	/**
	 * prints the sales by day
	 * @param month
	 * @param day
	 */
	public void printSalesbyDay(int month, int day){
		double totalRev=0;
		
		System.out.println("Name \t\t"+"Quantity "+"Price ");
		for(Sales daySale: sales.values()){
			daySale.printDailySales(month, day);
			totalRev+=daySale.getRevenue(month, day);
		}
		System.out.println("\t\t\tTotal Sales= $"+totalRev);
	}
	/**
	 * prints the sales by month
	 * @param month
	 */
	public void printSalesbyMonth(int month){
double totalRev=0;
		
		System.out.println("Name \t\t"+"Quantity "+"Price ");
		
		for(Sales monthSale: sales.values()){
			monthSale.printMonthlySales(month);
			totalRev+=monthSale.getMonthlyRev(month);
		}
		System.out.println("\t\t\tTotal Sales= $"+totalRev);
	}
	/**
	 * saves to file
	 */
	public void salesToFile(){
		cnv.toFile(sales, "Sales.txt");
	}
	/**
	 * converts from file
	 */
	@SuppressWarnings("unchecked")
	public void salesFromFile(){
		sales=(Map<MenuItem, Sales>) cnv.fromFile(sales,"Sales.txt");
	}
}
