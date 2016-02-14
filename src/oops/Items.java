/**
*@author Chandra Bhavya
 * @version 1.0
 * @since 7th November,2014
 * Extends Items, in turn realizing MenuItems interface
 * This class implements the serialisable and compareTo interface.
The natural order of items is decided by its price.
*/
package oops;

import java.io.Serializable;

public abstract class Items implements MenuItem,Comparable<Items>, Serializable{

	private static final long serialVersionUID = 929908981129369869L;
protected String name;
protected double price;
protected String description;


protected boolean available;
/**
 * 
 * @param name
 * @param price
 * @param description
 */
public Items(String name, double price, String description){
	this.name=name;
	this.price=price;
	this.description=description;
	available=true;	
}


/**
 * @return name
 */
public String getName(){
	return name;
}
/**
 * @return description
 */
public String getDescription(){
	return description;
}
/**
 * return price
 */
public double getPrice(){
	return price;
}
/**
 * @return availability
 */
public boolean checkAvailability(){
	return available;
}
/**
 * @param name to set name
 */
public void setName(String name){
	this.name=name;
}
/**
 * @param price to set price
 */
public void setPrice(double price){
	this.price=price;
}
/**
 * @param description to set description
 */
public void setDescription(String description){
	this.description=description;
}
public void setAvailability(boolean av){
	available=av;
}
/**
 * OVerriden method of object class,Simply return description of item as String
 */
@Override
public String toString(){
	StringBuilder s=new StringBuilder();
	s.append(name);
	String p=String.valueOf(price);
	for(int i=name.length();i<=75;i++)
		s.append(" ");
	s.append("$");
	s.append(p);
	return s+"\n"+description;
};
/**
 * Used to sort the items in a menu according to their price,
 * if price are equal, sorted by name
 */
@Override
public int compareTo(Items item) {
	// 
	if(this.price>item.price)
		return 1;
	else if(this.price<item.price)
		return -1;
	else{
		return this.name.compareTo(item.name);
	}
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (available ? 1231 : 1237);
	result = prime * result
			+ ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	long temp;
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Items other = (Items) obj;
	if (available != other.available)
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	return true;
}

}
