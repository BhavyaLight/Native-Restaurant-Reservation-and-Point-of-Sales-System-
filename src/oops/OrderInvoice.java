/**
 * @author Yang MingYu
 * @version 1.0
 * @since 8th November 2014
 */
package oops;

import java.util.Date;
import java.util.Map;
public class OrderInvoice {
	private String staffName;
	private double subTotal;
	private double discount;
	private double GST;
	private double total;
	private Order ordered;
	/**
	 * 
	 * @param ordered: takes in object called order
	 * @param name: Takes in name of staff taking the order
	 */
	public OrderInvoice(Order ordered,String name){
		staffName=name;
		this.ordered=ordered;
		GST=0;
		calcSubTotal(ordered.getOrder());
		calcDiscount();
		calcTotal();
	}
	/**
	 * @param items: contains all the items in the current order
	 * This function calculates the subtotal of the order items
	 */
public void calcSubTotal(Map<MenuItem,Integer> items){
	for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
		subTotal+=entry.getValue()*(entry.getKey().getPrice());
	}
}
/**
 * if the customer, which belongs to the order is a member, discount is allocated
 */
public void calcDiscount(){
	if(ordered.getCustomer().ismember())
		discount=0.10*subTotal;
	else
		discount=0;
}
/**
 * The total cost of order is calculated depending on GST+discount
 */
public void calcTotal(){
	GST=0.07*(subTotal-discount);
	total=GST+subTotal-discount;
}
/**
 * Print the order invoice
 */
public void printInvoice(){
	Date date=new Date();
	System.out.println("\t\t  YUMs Kitchen\t\t\t");
	System.out.println("\t\t577, Sweet Street\t\t");
	System.out.println("\t\tNear Chocolate town\t\t");
	System.out.println("\t\tcontact:65-98393271\t\t");
	System.out.println("\t\t#####ORDER NO:"+Order.getOrderNo()+"#####");
	System.out.println("Order taken by:"+staffName+"\t"+date.toString());//timeStamp);
	System.out.println("\tName:"+ordered.getCustomer().getName()+"\tTable No:"+ordered.getTableID());
	System.out.println("----------------------------------------------------");
	ordered.displayItemList();
	System.out.println("----------------------------------------------------");
	System.out.println("\t\t\t\tSubtotal= $"+subTotal);
	System.out.printf("\t\t\t\tDiscount=-$%.2f\n",discount);
	System.out.printf("\t\t\t\t7%% GST  = $%.2f\n",GST);
	System.out.println("\t\t\t\t   Total= $"+total);
	System.out.println("\t\t\tThankyou for dining with us!");
}

}
