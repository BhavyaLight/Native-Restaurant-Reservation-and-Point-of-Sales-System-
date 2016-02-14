/**
 * @author Nguyen Thanh Tung
 * @version 1.0
 * @since 8th November 2014
 */
package oops;

import java.io.Serializable;
import java.util.Scanner;

public class Customer implements Serializable {
	private static final long serialVersionUID = 8034648741873218103L;
	private double id;
	private String name;
	private long contact;
/**
 * Reads attributes of customer	
 */
	public Customer (){
		Scanner Sc=new Scanner(System.in);
		System.out.println("Hello! Enter customer name:");
		name=Sc.nextLine();
		System.out.println("Is the customer a member or has a coupon?(Yes/No)");
		String yes=Sc.next();
		if(!yes.equalsIgnoreCase("yes")){
		id=-1;
		}
		if(id!=-1){
		System.out.println("Enter membership/coupon ID:");
		id=Sc.nextInt();
		}
		System.out.println("Enter contact number:");
		contact=Sc.nextLong();
	}
	/**
	 * 
	 * @return customer Id
	 */
	public double getId() {
		return id;
	}
/**
 * 
 * @return customer name
 */
	public String getName(){
		return name;
	}
	/**
	 * 	
	 * @return customer contact
	 */
	public long getContact(){
		return contact;
	}
	/**
	 * 
	 * @return if customer is member
	 */
	public boolean ismember(){
		if(id==-1)
			return false;
		return true;
	}
}
