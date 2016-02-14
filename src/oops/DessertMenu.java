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

public class DessertMenu extends ItemsMenu{
private static final long serialVersionUID = -8957510700601059826L;
protected Set<Dessert> dishSet=new TreeSet<Dessert>();
@SuppressWarnings("unchecked")
/**
 * non parameterised constructor
 * Initialises a TreeSet called dishSet by deserialising pre exisiting values from a file
 */
public DessertMenu(){
		ConvertFromFile conv=new ConvertFromFile();
		dishSet=(Set<Dessert>) conv.fromFile(dishSet, "dessertMenu.txt");

}
Scanner Sc=new Scanner(System.in);  
/**
 * The function below create, remove, update, display,getItem,toFile etc are overridden because it
 * realized the interface Menu
 */


	@Override
	public void create(SalesReport report) {
		System.out.println();
		System.out.println("#####CREATING A DESSERT ITEM#####");
		System.out.println("Creating a new Dessert Item");
		Dessert dish=new Dessert();
		super.create(report,dish);
		System.out.print("Add waffers?(True/False)");
		boolean waf=Sc.nextBoolean();
		System.out.print("Add nuts?(True/False)");
		boolean nut=Sc.nextBoolean();
		dish.addWaffers(waf);
		dish.addNuts(nut);
		dishSet.add(dish);			
	}

	@Override
	public void update() {
		System.out.println("#####UPDATING A DESSERT ITEM#####");
		int choice;
		display();
		System.out.println();
		System.out.print("Enter item number:");
		int itemNo=Sc.nextInt();
		Dessert update=getItem(itemNo);
		if(update==null){
			System.out.println("Item does not exist!");
			return;
		}
		do{
		System.out.println("What would you like to ammend?\n1.Name\n2.Price\n3.Descrition\n4.Availability\n5.Add or remove Waffers\n6.Add or remove nuts\n0.Exit");
		//Sc.nextLine();
		choice=Sc.nextInt();
		switch(choice){
		case 1:
		Sc.nextLine();
		System.out.print("Enter name:");
		//Sc.useDelimiter("\n");
		String name=Sc.nextLine();
		update.setName(name);
			break;
		case 2:dishSet.remove(update);
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
		case 5:
			System.out.println("Add waffers?(true/false)");
			boolean wafs=Sc.nextBoolean();
		update.addWaffers(wafs);
			break;
		case 6:
			System.out.println("Add nuts?(true/false");
			boolean nuts=Sc.nextBoolean();
		update.addNuts(nuts);
		break;
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
		System.out.println("#####REMOVING A DESSERT ITEM#####");
		super.remove(dishSet);		
	}

	@Override
	public void display() {
		System.out.println("###########DESSERT MENU###########");
		super.display(dishSet);
		
	}
	@Override
	public Dessert getItem(int itemNo){
		return (Dessert)super.getItem(itemNo, dishSet);
	}
	@Override
	public void toFile() {
		ConvertFromFile conv=new ConvertFromFile();
		conv.toFile(dishSet, "dessertMenu.txt");
		
	}


}
