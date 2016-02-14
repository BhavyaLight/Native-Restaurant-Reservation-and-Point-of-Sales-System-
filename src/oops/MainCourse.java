/**
 * @author Chandra Bhavya
 * Shows concept of inheritance
 */

package oops;

public class MainCourse extends Items {
	private static final long serialVersionUID = 9058793529784346293L;
	private boolean vegetarian;
	/**
	 * default constructor
	 */
	public MainCourse(){
		super("",0,"");
		vegetarian=false;
	}
	/**
	 * 
	 * @param name
	 * @param price
	 * @param description
	 * @param veg
	 */
	public MainCourse(String name, double price, String description, boolean veg){
		super(name,price,description);
		vegetarian=veg;
	}
	/**
	 * 
	 * @return if vegetarian or not
	 */
	public String checkVeg(){
		if(vegetarian)
		return "Vegetarian";
		else
		return "Non vegetarian";
	}
	/**
	 * Setter method
	 * @param veg
	 */
	public void setVeg(boolean veg){
		vegetarian=veg;
	}
	/**
	 * Returns the item description as a String
	 */
	@Override
	public String toString() {
		String s=super.toString();
		return s+"\n"+"("+checkVeg()+")";
		
	}

	
}
