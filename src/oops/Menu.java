/**
 * @author Chandra Bhavya
 * @version 1.0
 * @since 7th November 2014
 * This interface allows us to use the Dependency injection principle.
 * MainCourse items, dessert items, drink and promotional packages can easily be created 
 * and accessed through this single interface.
 */

package oops;

import java.io.Serializable;

public interface Menu extends Serializable {
	/**
	 * Creates a new item and adds to menu
	 * @param report: to add sales of new item created to report
	 */
public void create(SalesReport report);
/**
 * updates the menu
 */
public void update();
/**
 * removes item from menu
 */
public void remove();
/**
 * displays item list
 */
public void display();
/**
 * serialised objects into file
 */
public void toFile();
/**
 * 
 * @param itemNo
 * @return item after finding it in the menu list
 */
public Object getItem(int itemNo);


}
