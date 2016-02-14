/**
 * @author Chandra Bhavya
 * @version 1.0
 * @since 7th November,2014
 * Extends Items Menu, in turn realizing Menu interface
 */

package oops;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PromotionalPackagesMenu extends ItemsMenu{
	private static final long serialVersionUID = -8013394553555684246L;
	public Set<PromotionalSetPackage> dishSet=new TreeSet<PromotionalSetPackage>();
	private MainCourseMenu m;
	private DrinkMenu d;
	private DessertMenu dez;
	Scanner Sc=new Scanner(System.in);  
	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @param m
	 * @param drink
	 * @param dez
	 * Returns a Set of deserialized objects, which need to be casted, 
	 * the warning for this cast has been suppressed
	 */
	public PromotionalPackagesMenu(MainCourseMenu m,DrinkMenu drink, DessertMenu dez){
		this.m=m;
		this.d=drink;
		this.dez=dez;
		ConvertFromFile conv=new ConvertFromFile();
		
		dishSet=(Set<PromotionalSetPackage>) conv.fromFile(dishSet, "promotionalPackageMenu.txt");
	}
	/**
	 * Creates a promotional Package
	 * @param report: Sales report to add sales of new item created
	 */
	@Override
	public void create(SalesReport report) {
		System.out.println();
		PromotionalSetPackage dish=new PromotionalSetPackage();
		System.out.println("#####CREATING A PROMOTIONAL SET ITEM#####");
		super.create(report,dish);
		m.display();
		System.out.println();
		System.out.print("Enter main course item number to add:");
		int mainCourseItem=Sc.nextInt();
		MainCourse promoMainCourse=m.getItem(mainCourseItem);
		//Error checking in case the item name does not exist.
		while(promoMainCourse==null){
			System.out.println("This main course does not exist");
			System.out.print("Enter new  item:");
			mainCourseItem=Sc.nextInt();
			promoMainCourse=m.getItem(mainCourseItem);
		}
		d.display();
		System.out.print("\nEnter drink item no:");
		int drinkNo=Sc.nextInt();
		Drink promoDrink=d.getItem(drinkNo);
		while(promoDrink==null){
			System.out.println("This drink does not exist");
			System.out.print("Enter new drink item:");
			drinkNo=Sc.nextInt();
			promoDrink=d.getItem(drinkNo);
		}
		dez.display();
		System.out.print("\nEnter dessert item no:");
		int dessertNo=Sc.nextInt();
		Dessert promoDessert=dez.getItem(dessertNo);
		while(promoDessert==null){
			System.out.println("This dessert does not exist");
			System.out.print("Enter new dessert item:");
			dessertNo=Sc.nextInt();
			promoDessert=dez.getItem(dessertNo);
		}
		dish.setMainDish(promoMainCourse);
		dish.setDrinkChoice(promoDrink);
		dish.setDessertChoice(promoDessert);
		dishSet.add(dish);	
	}
	/**
	 * updates an existing promotional package
	 */

	@Override
	public void update() {
		System.out.println();
		System.out.println("#####UPDATING A PROMOTIONAL SET ITEM#####");
		int choice;
		System.out.print("Enter item number:");
		int itemNo=Sc.nextInt();
		PromotionalSetPackage update=getItem(itemNo);
		if(update==null){
			System.out.println("Item does not exist!");
			return;
		}
		do{
		System.out.println("What would you like to ammend?\n1.Name\n2.Price\n3.Main Course Item\n4.Drink Item\n5.Dessert Item\n6.Availability\n0.Exit");
		choice=Sc.nextInt();
		switch(choice){
		case 1:
		Sc.nextLine();
		System.out.print("Enter name:");
		String name=Sc.nextLine();
		update.setName(name);
			break;
		case 2:
		dishSet.remove(update);
		System.out.print("Enter Price:");
		double price=Sc.nextDouble();
		update.setPrice(price);
		dishSet.add(update);
			break;
		case 3:
		m.display();
		System.out.println();
		System.out.print("Enter main course item number to replace:");
		int mainCourseItem=Sc.nextInt();
		MainCourse promoMainCourse=m.getItem(mainCourseItem);
		//Error checking in case the item name does not exist.
		while(promoMainCourse==null){
			System.out.println("This main course does not exist");
			System.out.print("Enter new  item:");
			mainCourseItem=Sc.nextInt();
			promoMainCourse=m.getItem(mainCourseItem);
		}
		update.setMainDish(promoMainCourse);
			break;
		case 4:
			d.display();
			System.out.print("\nEnter drink item number to replace:");
			int drinkNo=Sc.nextInt();
			Drink promoDrink=d.getItem(drinkNo);
			while(promoDrink==null){
				System.out.println("This drink does not exist");
				System.out.print("Enter new drink item:");
				drinkNo=Sc.nextInt();
				promoDrink=d.getItem(drinkNo);
			}
		update.setDrinkChoice(promoDrink);
			break;
		case 5:
			dez.display();
			System.out.print("\nEnter dessert item number to replace:");
			int dessertNo=Sc.nextInt();
			Dessert promoDessert=dez.getItem(dessertNo);
			while(promoDessert==null){
				System.out.println("This dessert does not exist");
				System.out.print("Enter new dessert item:");
				dessertNo=Sc.nextInt();
				promoDessert=dez.getItem(dessertNo);
			}

		update.setDessertChoice(promoDessert);
			break;
		case 6: System.out.println("Set availability(True/False)");
		boolean available=Sc.nextBoolean();
		update.setAvailable(available);
		case 0: break;
		default:
			System.out.print("Invalid choice! Enter again");
			choice=Sc.nextInt();
		}
		System.out.println("The changes have been saved!");
	}while(choice<=6 && choice>0);
	}

	@Override
	public void remove() {
		System.out.println();
		System.out.println("#####REMOVING A PROMOTIONAL SET ITEM#####");
		super.remove(dishSet);
		
	}
	public void display(){
		System.out.println("\n###########PROMOTIONAL PACKAGES#############");
	super.display(dishSet);
	}

	@Override
	public PromotionalSetPackage getItem(int itemNo){
		return (PromotionalSetPackage)super.getItem(itemNo, dishSet);
	}
	@Override
	public void toFile() {
		ConvertFromFile conv=new ConvertFromFile();
		conv.toFile(dishSet, "promotionalPackageMenu.txt");
		
	}

}

