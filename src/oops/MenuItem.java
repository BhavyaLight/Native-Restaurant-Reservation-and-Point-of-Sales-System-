package oops;
/**
 * 
 * @author Chandra Bhavya
 * @version 1.0
 * @since 7th November, 2014
 *Interface that allows us to use the Dependency Injection Principle
 */
public interface MenuItem {
	/**
	 * 
	 * @return name of menu item
	 */
public String getName();
/**
 * 
 * @return price of menu item
 */
public double getPrice();
/**
 * 
 * @return description of menu item
 */
public String getDescription();
/**
 * 
 * @param name sets name of item
 */
public void setName(String name);
/**
 * 
 * @param price sets price of item
 */
public void setPrice(double price);
/**
 * 
 * @param description sets description of item
 */
public void setDescription(String description);
/**
 * 
 * @return boolean whether item is available or not
 */
public boolean checkAvailability();

}
 