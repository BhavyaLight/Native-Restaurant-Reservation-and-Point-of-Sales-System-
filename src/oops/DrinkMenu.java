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

public class DrinkMenu extends ItemsMenu{
	private static final long serialVersionUID = 3067016488352118219L;
	public Set<Drink> dishSet=new TreeSet<Drink>();
	Scanner Sc=new Scanner(System.in); 
	/**
	 * non parameterized constructor
	 * Initializes a TreeSet called dishSet by deserialising pre exisiting values from a file
	 */
	@SuppressWarnings("unchecked")
	public DrinkMenu(){
		ConvertFromFile conv=new ConvertFromFile(); 
		dishSet=(Set<Drink>) conv.fromFile(dishSet, "drinkMenu.txt");
	}
	/**
	 * The function below create, remove, update, display,getItem,toFile etc are overridden because it
	 * realized the interface Menu
	 */

	@Override
	public void create(SalesReport report) {
		System.out.println();
		System.out.println("#####CREATING A DRINK ITEM#####");
		Drink dish=new Drink();
		super.create(report,dish);
		System.out.print("Hot?(True or False)");
		boolean hot=Sc.nextBoolean();
		dish.hotOrCold(hot);
		dishSet.add(dish);	
	}

	@Override
	public void update() {
		System.out.println("#####UPDATING A DRINK ITEM#####");
		int choice;
		display();
		System.out.println();
		System.out.println("Updating a Drink Item");
		System.out.print("Enter item number:");
		int itemNo=Sc.nextInt();
		Drink update=getItem(itemNo);
		if(update==null){
			System.out.println("Item does not exist!");
			return;
		}
		do{
		System.out.println("What would you like to ammend?\n1.Name\n2.Price\n3.Descrition\n4.Availability\n5.Hot or Cold?\n0.Exit");
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
		Sc.nextLine();
		System.out.print("Enter Description:");
		String desc=Sc.nextLine();
		update.setDescription(desc);
			break;
		case 4:System.out.print("Is it available?(True/False)");
		boolean avail=Sc.nextBoolean();
		update.setAvailability(avail);
			break;
		case 5:System.out.print("Is the beverage Hot?(True/False)");
		boolean hot=Sc.nextBoolean();
		update.hotOrCold(hot);
			break;
		case 0: break;
		default:
			System.out.print("Invalid choice! Enter again");
			choice=Sc.nextInt();
		}
		System.out.println("The changes have been saved!");
	}while(choice<=5 && choice>0);
	}

	@Override
	public void remove() {
		System.out.println();
		System.out.println("#####REMOVING A DRINK ITEM#####");
		super.remove(dishSet);
		
	}
	public void display(){
		System.out.println("############DRINK MENU#############");
		super.display(dishSet);
	}
	@Override
	public Drink getItem(int itemNo){
		return (Drink)super.getItem(itemNo, dishSet);
	}

	@Override
	public void toFile() {
		ConvertFromFile conv=new ConvertFromFile();
		conv.toFile(dishSet, "drinkMenu.txt");
		
	}
}
