/**
 * @author Nguyen Thanh Tung
 * @version 1.0
 * @since 8th November 2014
 */
package oops;

import java.io.Serializable;

public class Table implements Serializable {
	private static final long serialVersionUID = 7745543069809306342L;
	private int tableID;
	private int pax;
	private Customer person[];
	private boolean time[];
	/**
	 * 
	 * @param tableID
	 * @param pax
	 */
	public Table(int tableID, int pax){
		this.tableID = tableID;
		this.pax = pax;
		time=new boolean[5];
		person=new Customer[5];
		for(int i=0; i<5; i++){
			time[i]=false;
		}
	}
	/**
	 * 
	 * @return tableID
	 */
	public int getID(){
		return tableID;
	}	
	/**
	 * 
	 * @return maximum persons table can accomodate
	 */
	public int getPax(){
		return pax;
	}
/**
 * 
 * @param TimeSlot
 * @return whether assigned or not
 */
	public boolean isAssigned(int TimeSlot){
		return time[TimeSlot-1];
	}
/**
 * assigns table for one time slot
 * @param person
 * @param TimeSlot
 */
	public void assign(Customer person,int TimeSlot){
		if(!time[TimeSlot-1]){
		this.person[TimeSlot-1]=person;
		time[TimeSlot-1]=true;
		}
	}
	public Customer getCustomer(int TimeSlot){
		return person[TimeSlot-1];
	}
	/**
	 * unassigns the table for one time slot
	 * @param TimeSlot
	 */
	public void unassign(int TimeSlot){
		time[TimeSlot-1]=false;
		person[TimeSlot-1]=null;
		
	}


}
