/**
 * @author Chang Rongjia
 * @version 1.0
 * @since 8th November 2014
 */
package oops;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservation implements Serializable{
	private static final long serialVersionUID = -7538821397513595962L;
	private String date;
	private String timeSlot[]={"10.00-12.00","12.00-14.00","14.00-16.00","16.00-18.00"
			,"18.00-20.00"};
	private ArrayList<Table> Tables=new ArrayList<Table>();
	/**
	 * 
	 * @param date
	 * initializes tables to false, and adds them in a table array
	 */
	public Reservation(String date){
		this.date=date;
		for(int i=1; i<=5; i++)
		Tables.add(new Table(i,2*i));
	}
	/**
	 * 
	 * @param time
	 * Prints empty tables depending upon the time slot
	 */
	public void showEmptyTables(int time){
		System.out.println();
		System.out.println("The following tables are empty:");
			for (Table Table: Tables){
				if(!Table.isAssigned(time))
					System.out.println("Table No.="+Table.getID()+" Pax:"+Table.getPax());
				
		}
			System.out.println();
	}
	/**
	 * Shows ALL assigned tables for a day, for all time slots
	 */
	public void showAssigned(){
		System.out.println();
		System.out.println("RESERVATION DATABASE: "+date);
				for(int i=1; i<=5; i++){
					System.out.println("Time Slot:"+timeSlot[i-1]);
					System.out.println("Table Id "+"Customer Name");
					for (Table Table: Tables){
						if(Table.isAssigned(i))
							System.out.println(Table.getID()+" "+Table.getCustomer(i).getName());
						}
					System.out.println("---------------------");
				}
	}
	/**
	 * assigns tables for one time slot and for one customer
	 * @param pax
	 * @param person
	 * @param time
	 * @return returns tableId if assigned successfully or else returns 0
	 */
	public int assignTable(int pax, Customer person, int time){
		int noOfSeatReq=pax;
		if(pax%2!=0)
			noOfSeatReq++;
		for(int i=noOfSeatReq/2; i<=5; i++){
			if(i!=0 && !Tables.get(i-1).isAssigned(time))
			{
				Tables.get(i-1).assign(person,time);
				System.out.println("TABLE RESERVED!");
				System.out.println("Customer name:"+person.getName());
				System.out.println("Table assigned = Table no."+Tables.get(i-1).getID()+" for "+Tables.get(i-1).getPax()+" people");
				return Tables.get(i-1).getID();
			}
		}
		System.out.println("Sorry! all Tables are full or they do not meet your seating capacity!");
		return 0;
	}
	/**
	 * Unassigns table by time slot and tableId
	 * @param TableID
	 * @param time
	 */
	public void unassignTable(int TableID, int time){
		Tables.get(TableID-1).unassign(time);
	}
	
	/**
	 * getter
	 * @return Tables: an array of tables
	 */
	public ArrayList<Table> getTables() {
		return Tables;
	}
	/**
	 * Creates order
	 * @param person
	 */
	public void createReservation(Customer person){
		Scanner Sc=new Scanner(System.in);
		boolean promptUser=true;
		int time=1;
		System.out.println();
		System.out.println("#####CREATING NEW RESERVATION#####");
		System.out.println("Please chose a time slot:");
		
		while(promptUser){
		try{
			showTimeSlot();
			time=Sc.nextInt();
			System.out.println("Checking for empty seats in slot:"+timeSlot[time-1]);
		promptUser=false;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Wrong Time Slot! Please chose again!");
		}}
		showEmptyTables(time);
		System.out.println("How many people do you need at your table?");
		int pax=Sc.nextInt();
		if(pax<=10){
			assignTable(pax,person,time);
		}
		else
			System.out.println("Sorry! We have only tables for 10 people");	
	}
	/**
	 * display time slot available to book
	 */
	public void showTimeSlot(){
		for(int i=1; i<=5; i++){
			System.out.println(i+". "+timeSlot[i-1]+"hrs");
		}
	}
	/**
	 * Checks if a person has a reservation at a particular time
	 * @param name
	 * @param timeSlot
	 * @return true/false if someone has reservation
	 */
	public boolean hasReservation(String name,int timeSlot){
		for(Table tables: Tables)
		if(tables.getCustomer(timeSlot)!=null)
			if(name.equalsIgnoreCase(tables.getCustomer(timeSlot).getName()))
				if(tables.isAssigned(timeSlot))
					return true;
	return false;
	}
}


