/**
 * @author Lin Qian
 * @version 1.0
 * @since 8th November 2014
 */
package oops;

import java.io.Serializable;

public class Sales implements Serializable{
private static final long serialVersionUID = -4931165961967455972L;
private String item;
private long quantity[][]=new long[12][30];
private double revenue[][]=new double[12][30];
/**
 * 
 * @param item
 */
public Sales(String item){
	this.item=item;
	for(int i=0; i<12; i++){
		for(int j=0; j<30; j++){
			quantity[i][j]=0;
			revenue[i][j]=0;
		}
	}
}
/**
 * add the quantity of each item sold
 * @param month
 * @param day
 * @param qnty
 * @param price
 */
public void addQuantity(int month, int day,long qnty,double price){
	quantity[month-1][day-1]+=qnty;
	revenue[month-1][day-1]+=qnty*price;
}
/**
 * returns monthly quantity of items sold
 * @param month
 * @return
 */
public long getMonthlySales(int month){
	long qnty=0;
	for(int i=0; i<30; i++){
		qnty+=quantity[month-1][i];
	}
	return qnty;
}
/**
 * gets monthly revenue
 * @param month
 * @return
 */
public double getMonthlyRev(int month){
	double amt=0;
	for(int i=0; i<30; i++){
		amt+=revenue[month-1][i];
	}
	return amt;
}
/**
 * prints sales by day
 * @param month
 * @param day
 */
public void printDailySales(int month,int day){
	String s;
	s=item;
	for(int i=s.length(); i<25; i++)
		s=s.concat(" ");
	s=s.concat(String.valueOf(quantity[month-1][day-1]));
	for(int i=s.length(); i<10; i++)
		s=s.concat(" ");
	s=s.concat("  $");
	s=s.concat(String.valueOf(revenue[month-1][day-1]));
	System.out.println(s);
	
}
/**
 * prints sales by month
 * @param month
 */
public void printMonthlySales(int month){
	String s;
	s=item;
	for(int i=s.length(); i<25; i++)
		s=s.concat(" ");
	s=s.concat(String.valueOf(getMonthlySales(month)));
	for(int i=s.length(); i<10; i++)
		s=s.concat("   ");
	s=s.concat(" $");
	s=s.concat(String.valueOf(getMonthlyRev(month)));
	System.out.println(s);
	
}
/**
 * 
 * @param month
 * @param day
 * @return revenue
 */
public double getRevenue(int month,int day){
	return revenue[month-1][day-1];
}
/**
 * 
 * @param month
 * @param day
 * @return quantity 
 */
public double getQnty(int month,int day){
	return quantity[month-1][day-1];
}
/**
 * Return the item name for which sales are recorded
 * @return item
 */
public String getItem(){
	return item;
}
}
