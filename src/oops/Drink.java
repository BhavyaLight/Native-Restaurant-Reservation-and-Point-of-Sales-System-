/**
 * @author Chandra Bhavya
 * @version 1.0
 * @since 7th November,2014
 * Extends Items, in turn realizing MenuItems interface
 */


package oops;

public class Drink extends Items{
private static final long serialVersionUID = 7103112530451097979L;
protected boolean hot;
/**
 * non parameterized constructor
 */
public Drink(){
	super("",0,"");
	hot=false;
}
/**
 * 
 * @param name
 * @param price
 * @param description
 * @param hot
 */
public Drink(String name, double price, String description,boolean hot){
	super(name,price,description);
	this.hot=hot;
}
/**
 * getters and setter methods
 * @param hot
 */
public void hotOrCold(boolean hot){
	this.hot=hot;
}
/**
 * 
 * @return whether it is hot or cold
 */
public boolean isHot(){
	return hot;
}
@Override
public String toString() {
	String hotorCold="Hot";
	if(!hot) hotorCold="Cold";	
	String s=super.toString();
	return s+"("+hotorCold+")";
	
}
}


