/**
 * @author: Chandra Bhavya
 * @version 1.0 created on Mac
 * @since 7th November, 2014
 * Shows concept of inheritance.
 * Redundant methods: reading the name, price; removing item; getting item; display
 * are inherited by all subclasses
 */

package oops;

import java.util.Scanner;
import java.util.Set;

public abstract class ItemsMenu implements Menu{
private static final long serialVersionUID = -506868829786256601L;
Scanner Sc=new Scanner(System.in);
/**
 * Constructor, takes in sales report
 * @param report
 * @param item
 */
public void create(SalesReport report,MenuItem item) {
		System.out.print("Enter name:");
		String name=Sc.nextLine();		
		System.out.print("Enter Price:");
		double price=Sc.nextDouble();
		Sc.nextLine();
		System.out.print("Enter Description:");
		String desc=Sc.nextLine();
		item.setName(name);
		item.setPrice(price);
		item.setDescription(desc);
		report.addSalesItem(item);
		report.salesToFile();
	}
/**
 * 
 * @param dishSet: generic parameter, list of items obtained from base class
 * removes a particular item from the list of items i.e. dishSet
 */
	public void remove(Set<?extends MenuItem> dishSet) {
		display(dishSet);
		System.out.print("\nEnter Item number to remove:");
		int removeItemNo=Sc.nextInt();
		MenuItem remove=getItem(removeItemNo,dishSet);
		if(remove!=null){
		dishSet.remove(remove);
		System.out.println("Item "+remove.getName()+" has been successfully removed!");
		}
		else
			System.out.println("This item does not exist.");
		
	}
	/**
	 * 
	 * @param removeItemNo: takes position of the item from the list used
	 * @param dishSet
	 * @return returns the item from the list based on its position
	 */
	public MenuItem getItem(int removeItemNo,Set<?extends MenuItem> dishSet){
		MenuItem item=null;
		if(removeItemNo<=dishSet.size()){
		for(MenuItem m: dishSet){
			removeItemNo--;
			if(removeItemNo==0){
				item=m;
				break;
			}
		}
		}
		return item;
	}
	/**
	 * @param dishSet
	 * takes the list of menu items from base class and displays
	 */
	public void display(Set<?> dishSet){
		int count=1;
		for(int i=0; i<=80; i++)
		System.out.print("-");
		System.out.println();
		System.out.print("Name");
		for(int i=4; i<=75; i++)
			System.out.print(" ");
		System.out.println("Price");
		System.out.println();
		for(Object item: dishSet)
		System.out.println((count++)+"."+item.toString()+"\n");
		for(int i=0; i<=80; i++)
			System.out.print("-");
	}

}
