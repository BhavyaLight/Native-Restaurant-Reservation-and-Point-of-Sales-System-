/**
 * @author Chang Rongjia
 * @version 1.0
 * @since 9th November 2014
 */
package oops;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class RestaurantApp {

@SuppressWarnings("unchecked")
public static void main(String args[]){
	SalesReport report=new SalesReport();
	ConvertFromFile cnv=new ConvertFromFile();
	Map<String,Reservation> resList=new HashMap<String,Reservation>();
	resList=(Map<String, Reservation>) cnv.fromFile(resList,"reservations.txt");
	Map<Long,Order> orders=new HashMap<Long,Order>();
	Scanner Sc=new Scanner(System.in);
/**
 * Contains a reservation list (deserialised from existing records)
 * Order list (like queue of all orders taken)
 */
	System.out.println("Welcome to YUMs Kitchen!");
	Staff staff=new Staff(); 
	/**
	 * Although these months are manually taken we can
	 * use the calendar class to generate dates
	 * Error checking is hence, not done on these inputs
	 */
	int day,month,year;
	System.out.println("Please enter todays date: (day only i.e. 24 for 24 november)");
	day=Sc.nextInt();
	System.out.println("Please enter month: (day only i.e. 11 for 24 november)");
	month=Sc.nextInt();
	System.out.println("Please enter year: (All 4 digits i.e. 2014 for 2014)");
	year=Sc.nextInt();
	String date=String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
	Calendar cal1 = new GregorianCalendar(year,month,day); 
	if(!resList.containsKey(date))
	resList.put(date, new Reservation(date));
	int choice;
	MenuApp modMenu=new MenuApp(report); 
	do{
	System.out.println("########YUMS RRPS###########");
	System.out.println("What would you like to do?"+
						"\n1. Modify Menu"+
						"\n2. Create Order"+
						"\n3. View Order"+
						"\n4. Print Order"+
						"\n5. Create/Remove Reservations"+
						"\n6. Print Sales Revenu Report"+
						"\n7. Exit");
	choice=Sc.nextInt();
	switch(choice){
	case 1:
		modMenu.modifyMenu();
		report.salesToFile();
		break;
	case 2: 
		report.salesFromFile();
		int table=1;
		Customer customer=new Customer();
		Reservation prevRes=resList.get(date);
		if(!prevRes.hasReservation(customer.getName(), staff.getTime())){
		System.out.println("Table is required for how many people?");
		int persons=Sc.nextInt();
		table=resList.get(date).assignTable(persons, customer, staff.getTime());
		}
		else
		{
			System.out.println("You have a reservation! You may place your order now");
			
		}
		if(table!=0)
		{
			Order newOrder=new Order(customer,report,table,day,month);
			orders.put(Order.getOrderNo(),newOrder);
		}
		else{
			System.out.println("Please wait or come back later! We apologise for "
					+ "the inconveniance");
		}
		report.salesToFile();
		break;
	case 3:
		Order viewOrder;
		while(true){
		System.out.println("What order number would you like to view? Press 0 to exit");
		long numb=Sc.nextLong();
		viewOrder=orders.get(numb);
		if(viewOrder!=null || numb==0)
			break;
		System.out.println("Such an order number does not exist!");
		}
		viewOrder.displayItemList();
		System.out.println("Do you want to modify the order?(yes/no)");
		String yesNo=Sc.next();
		if(yesNo.equalsIgnoreCase("yes"))
			viewOrder.createOrder();
		report.salesToFile();
		break;
	case 4:
		Order printOrder=null;
		long numb=1;
		while(numb!=0){
		System.out.println("What order number would you like to print?");
		numb=Sc.nextLong();
		printOrder=orders.get(numb);
		if(printOrder!=null)
			break;
		System.out.println("Such an order number does not exist! Enter 0 to Exit.");
		}
		if(numb!=0){
		OrderInvoice inv=new OrderInvoice(printOrder,staff.getName());
		resList.get(date).unassignTable(printOrder.getTableID(), staff.getTime());
		inv.printInvoice();
		orders.remove(printOrder);
		System.out.println("Table no. "+printOrder.getTableID()+" has been vacated!");
		}
		report.salesToFile();
		break;
	case 5:
	
	System.out.println("Please enter a date to reserve: (day only i.e. 24 for 24 november)");
	day=Sc.nextInt();
	System.out.println("Please enter month: (day only i.e. 11 for 24 november)");
	month=Sc.nextInt();
	System.out.println("Please enter year: (All 4 digits i.e. 2014 for 2014)");
	year=Sc.nextInt();
	String resDate=String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);;
	Calendar cal2 =new GregorianCalendar(year,month,day);
	if(cal2.after(cal1)){
	Reservation res = null;
	System.out.println("Chose option: \n1.Create\n2.Remove\n3.Exit");
	int ch=Sc.nextInt();
	switch(ch){
	case 1:
		if(!resList.containsKey(resDate)){
		res=new Reservation(resDate);
		resList.put(resDate,res);
		System.out.println("Creating new reservation:");
		Customer resCustomer=new Customer();
		res.createReservation(resCustomer);
		}
		else{
			res=resList.get(resDate);
			System.out.println(resDate+"has the following reservations:");
			res.showAssigned();
			Customer resCustomer=new Customer();
			res.createReservation(resCustomer);
		}
		break;
	case 2:
		
		if(!resList.containsKey(resDate))
			System.out.println("No reservation on this date exists!");
		else{
			res=resList.get(resDate);
			System.out.println(resDate+"has the following reservations:");
			res.showAssigned();
			System.out.println("Enter the tableId to unassign:");
			int tableId=Sc.nextInt();
			System.out.println("Enter the time slot to unassign:");
			res.showTimeSlot();
			int time=Sc.nextInt();
			res.unassignTable(tableId, time);
			res.showAssigned();
		}
	}
	}
	else{
		System.out.println("Error! Reservation can only be made in advance!");
	}
	report.salesToFile();
		break;
		
	case 6:
		
		System.out.println("Enter the day(i.e. 12 if 12 Nov): ");
		int dayRev=Sc.nextInt();
		System.out.println("Enter the month(i.e.11 if 12 Nov): ");
		int monthRev=Sc.nextInt();
		System.out.println("Print Sales Revenu Report by: 1. Day 2. Month");
		int chose=Sc.nextInt();
		if(chose==1)
		report.printSalesbyDay(monthRev, dayRev);
		else
		report.printSalesbyMonth(monthRev);
		report.salesToFile();
		break;
	default:
		cnv.toFile(resList,"reservations.txt");
		report.salesToFile();
		System.out.println("Be thankful for what you have, you will end up having more! \nExiting!");
	
	}
	}while(choice<=6 && choice>0);
	
}


}

	
