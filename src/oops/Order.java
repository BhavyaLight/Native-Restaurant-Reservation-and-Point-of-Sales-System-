/**
 * @author Yang MingYu
 * @version 1.0
 * @since 8th November 2014
 */
package oops;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Order{
	private static long orderNo=0;
	Scanner Sc=new Scanner(System.in);
	private Map<MenuItem,Integer> orderItems=new LinkedHashMap<MenuItem,Integer>();
	private Customer helloCustomer;
	private int tableID;
	private int day,month;
	private SalesReport report;
	/**
	 * @param customer: Customer linked with order
	 * @param report: to store sales depending on order
	 * @param tableID
	 * @param day
	 * @param month
	 */
	public Order(Customer customer,SalesReport report, int tableID, int day, int month){
		orderNo++;	
	    helloCustomer=customer;
	    this.tableID=tableID;
	    this.day=day;
	    this.month=month;
	    this.report=report;
	    System.out.println("\n#####CREATING ORDER#####");
	    createOrder();
	}
	/**
	 * 
	 * @return tableId
	 */
	public int getTableID() {
		return tableID;
	}
/**
 * display order items
 */
	public void displayItemList(){
		String s,p;
		int count=1;
		for(MenuItem item: orderItems.keySet()){
			int q=orderItems.get(item);
			s=item.getName();
			for(int i=s.length(); i<=25; i++)
				s=s.concat(" ");
			s=s.concat("$");
			p=String.valueOf(item.getPrice());
			s=s.concat(p);
			for(int i=p.length(); i<=3; i++)
				s=s.concat(" ");
			System.out.println((count++)+". "+s+" X "+q+" = "+"$"+(item.getPrice()*q));
		}
	}
	/**
	 * add an item from menu 'm' which may be main course, dessert drink etc
	 * to the current order list
	 * DIP
	 * @param m
	 */
	public void addItem(Menu m){
		m.display();
		System.out.println("\nEnter the item number to order:");
		int itemNo=Sc.nextInt();
		MenuItem addNewItem;
		try{
		addNewItem=(MenuItem) m.getItem(itemNo); 
		if(addNewItem==null)throw new NullPointerException();
		}catch(NullPointerException e){
			System.out.println("Wrong entry!");
			return;
		}
		if(addNewItem.checkAvailability()){
		System.out.print("Quantity:");
		int qnty=Sc.nextInt();
		report.sales.get(addNewItem).addQuantity(month, day, qnty,addNewItem.getPrice());
		orderItems.put(addNewItem,qnty); 

		}
		else
			System.out.println("Sorry! This item is not available!");
		System.out.println("Order contains:");
		displayItemList();
		System.out.println();
	}
	/**
	 * Removes Item from list
	 */
	public void removeItem(){
		displayItemList();
		System.out.println("Enter the item number to remove:");
		int numb=Sc.nextInt();
		MenuItem remove=findItem(numb);
		if(remove!=null){
			report.sales.get(remove).addQuantity(month, day, -1*orderItems.get(remove),remove.getPrice());
			orderItems.remove(remove);
		}
		else
			System.out.println("This item does not exist!");
		System.out.println("Order contains:");
		displayItemList();
	}
	/**
	 * @param numb
	 * @return: returns the item, found in current order
	 */
	public MenuItem findItem(int numb){
		MenuItem find=null;
		for(MenuItem items: orderItems.keySet()){
			numb--;
			if(numb==0){
				find=items;
				break;
				}
			}
		return find;
	}
	/**
	 * Creates a new order
	 */
	public void createOrder(){
		MenuChoice menuChoice=new MenuChoice();
		Menu m=null;
		int choice;
		System.out.println("1. Add item\n2. Remove item\n3. Exit");
		choice=Sc.nextInt();
		while(choice<3 && choice>0){
			switch(choice){
			case 1: m=menuChoice.choseMenu();
			if(m!=null)
			addItem(m);
			break;
			case 2:
				removeItem();
				break;
			default:
				System.out.println("Exiting");
			}
			System.out.println("1. Add item\n2. Remove item\n3. Exit");
			choice=Sc.nextInt();
		}
		displayItemList();
		
	}
	/**
	 * 
	 * @return Map of items ordered
	 */
	public Map<MenuItem,Integer> getOrder(){
		return orderItems;
	}
	/**
	 * 
	 * @return customer
	 */
	public Customer getCustomer(){
		return helloCustomer;
	}
	/**
	 * 
	 * @return order number
	 */
	public static long getOrderNo(){
		return orderNo;
	}
}
