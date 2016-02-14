/**
 * @author Chandra Bhavya
 * @version 1.0
 * @since 7th November 2014
 */
package oops;

import java.io.Serializable;

public class PromotionalSetPackage implements MenuItem,Serializable,Comparable<PromotionalSetPackage> {
	private static final long serialVersionUID = -5118590141466085895L;
	private String promoName;
	private double promoPrice;
	private String description;
	private MainCourse mainDish;
	private Dessert dessertChoice;
	private Drink drinkChoice;
	private boolean available;
/**
 * non parameterized constructor
 */
	public PromotionalSetPackage(){
		promoName="";
		promoPrice=0;
		this.mainDish=null;
		this.dessertChoice=null;
		this.drinkChoice=null;
		setAvailable(true);

	}
	/**
	 * 
	 * @param name
	 * @param price
	 * @param mainDish
	 * @param dessertChoice
	 * @param drinkChoice
	 */
	public PromotionalSetPackage(String name, double price, MainCourse mainDish, Dessert dessertChoice, Drink drinkChoice){
		promoName=name;
		promoPrice=price;
		this.mainDish=mainDish;
		this.dessertChoice=dessertChoice;
		this.drinkChoice=drinkChoice;
		setAvailable(true);
	
	}
	/**
	 * @return promoName
	 */
	public String getName() {
		return promoName;
	}
	/**
	 * @param promoName sets promo name
	 */
	public void setName(String promoName) {
		this.promoName = promoName;
	}
	/**
	 * 
	 * @return mainCourse item
	 */
	public MainCourse getMainDish() {
		return mainDish;
	}
	/**
	 * 
	 * @param mainDish set main course item
	 */
	public void setMainDish(MainCourse mainDish) {
		this.mainDish = mainDish;
	}
	/**
	 * 
	 * @return dessert item
	 */
	public Dessert getDessertChoice() {
		return dessertChoice;
	}
	/**
	 * 
	 * @param dessertChoice set dessert choice
	 */
	public void setDessertChoice(Dessert dessertChoice) {
		this.dessertChoice = dessertChoice;
	}
	/**
	 * 
	 * @return drink item
	 */
	public Drink getDrinkChoice() {
		return drinkChoice;
	}
	/**
	 * 
	 * @param drinkChoice set drink item
	 */
	public void setDrinkChoice(Drink drinkChoice) {
		this.drinkChoice = drinkChoice;
	}
	/**
	 * @param promoPrice sets the price
	 */
	public void setPrice(double promoPrice) {
		this.promoPrice = promoPrice;
	}
	/**
	 * @return promoPrice
	 */
	public double getPrice(){
		return promoPrice;
	}
	@Override
	public String toString(){
		StringBuilder s=new StringBuilder();
		s.append(promoName);
		for(int i=promoName.length();i<=75;i++)
			s.append(" ");
		s.append("$"+String.valueOf(promoPrice));
		return s+"\n"+"Includes:"+mainDish.getName()+","+dessertChoice.getName()+","+drinkChoice.getName();
	}
	/**
	 * Used to sort items by price
	 */
	@Override
	public int compareTo(PromotionalSetPackage item) {
		if(this.promoPrice>item.promoPrice)
			return 1;
		else if(this.promoPrice<item.promoPrice)
			return -1;
		else
			return this.promoName.compareTo(item.promoName);
	
	}

	@Override
	public boolean checkAvailability() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String getDescription() {
		
		return "Includes "+mainDish.getName()+","+dessertChoice.getName()+","+drinkChoice.getName()+"\n"+description;
	}

	@Override
	public void setDescription(String description) {
		this.description=description;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dessertChoice == null) ? 0 : dessertChoice.hashCode());
		result = prime * result
				+ ((drinkChoice == null) ? 0 : drinkChoice.hashCode());
		result = prime * result
				+ ((mainDish == null) ? 0 : mainDish.hashCode());
		result = prime * result
				+ ((promoName == null) ? 0 : promoName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(promoPrice);
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
		PromotionalSetPackage other = (PromotionalSetPackage) obj;
		if (dessertChoice == null) {
			if (other.dessertChoice != null)
				return false;
		} else if (!dessertChoice.equals(other.dessertChoice))
			return false;
		if (drinkChoice == null) {
			if (other.drinkChoice != null)
				return false;
		} else if (!drinkChoice.equals(other.drinkChoice))
			return false;
		if (mainDish == null) {
			if (other.mainDish != null)
				return false;
		} else if (!mainDish.equals(other.mainDish))
			return false;
		if (promoName == null) {
			if (other.promoName != null)
				return false;
		} else if (!promoName.equals(other.promoName))
			return false;
		if (Double.doubleToLongBits(promoPrice) != Double
				.doubleToLongBits(other.promoPrice))
			return false;
		return true;
	}


		
	
	
}
