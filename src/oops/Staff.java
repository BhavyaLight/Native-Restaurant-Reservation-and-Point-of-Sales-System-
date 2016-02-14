/**
 * @author Chang RongJia
 * @version 1.0
 * @since 8th November 2014
 */
package oops;

import java.util.Scanner;

public class Staff {
	private double staffID;
	private String name;
	private String jobtitle;
	String timeSlot[]={"10.00-12.00","12.00-14.00","14.00-16.00","16.00-18.00"
			,"18.00-20.00"};
	private int time;
	public Staff(){
		Scanner Sc=new Scanner(System.in);
		System.out.print("Staff name:");
		this.name=Sc.nextLine();
		System.out.print("Staff ID:");
		this.staffID = Sc.nextDouble();
		System.out.print("Staff Job Title:");
		jobtitle =Sc.next();
		System.out.println("Select your shift time:");
		for(int i=1; i<=5; i++){
			System.out.println(i+". "+timeSlot[i-1]+"hrs");
		}
		time=Sc.nextInt();
	}
	/**
	 * 
	 * @return time: the time of staff shift
	 */
	public int getTime() {
		return time;
	}
/**
 * 
 * @return staffID
 */
	public double getID(){
		return staffID;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @return jobTitle
	 */
	public String getJobTitle(){
		return jobtitle;
	}
}
