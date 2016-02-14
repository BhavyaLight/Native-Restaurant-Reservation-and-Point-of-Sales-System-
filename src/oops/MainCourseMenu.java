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

public class MainCourseMenu extends ItemsMenu{
	private static final long serialVersionUID = 6356497148603862400L;
	protected Set<MainCourse> dishSet=new TreeSet<MainCourse>();
	Scanner Sc=new Scanner(System.in);
	@SuppressWarnings("unchecked")
	/**
	 * non parameterised constructor
	 * Initialises a TreeSet called dishSet by deserialising pre exisiting values from a file
	 */
	public MainCourseMenu(){
		ConvertFromFile conv=new ConvertFromFile();
		dishSet=(Set<MainCourse>) conv.fromFile(dishSet, "mainCourseMenu.txt");
	}
	/**
	 * The function below create, remove, update, display,getItem,toFile etc are overridden because it
	 * realized the interface Menu
	 */
	@Override
	public void create(SalesReport report) {
		System.out.println();
		System.out.println("############################CREATING A MAIN COURSE#############################");
		MainCourse dish=new MainCourse();
		super.create(report,dish);
		System.out.print("Is the dish vegetarian?(Yes or No)");
		String yesOrNo=Sc.next();
		boolean veg;
		if(yesOrNo.equalsIgnoreCase("yes"))
		veg=true;
		else
			veg=false;
		dish.setVeg(veg);
		dishSet.add(dish);	
	}

	@Override
	public void update() {
		Scanner Sc=new Scanner(System.in);
		System.out.println("###########################UPDATING A MAIN COURSE#############################");
		display();
		System.out.println();
		System.out.println("Enter item number:");
		int number=Sc.nextInt();
		MainCourse update=getItem(number);
		if(update==null){
			System.out.println("Item does not exist!");
			
			return;
		}
		int choice;
		String name;
		do{
		System.out.println("What would you like to ammend?\n1.Name\n2.Price\n3.Descrition\n4.Availability\n5.Vegetarian\n0.Exit");
		choice=Sc.nextInt();
		switch(choice){
		case 1:
		Sc.nextLine();
		System.out.print("Enter name:");
		name=Sc.nextLine();
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
		System.out.println("Should read");
		update.setDescription(desc);
			break;
		case 4:System.out.print("Is it available?(True/Fasle)");
		boolean avail=Sc.nextBoolean();
		update.setAvailability(avail);
			break;
		case 5:System.out.print("Is the dish vegetarian?(True/False)");
		boolean veg=Sc.nextBoolean();
		update.setVeg(veg);
			break;
		case 0: break;
		default:
			System.out.print("Invalid choice! Enter again");
			choice=Sc.nextInt();
		}
		System.out.println("The changes have been made!");
		
	}while(choice<=5 && choice>0);
	}

	@Override
	public void remove() {
		System.out.println();
		System.out.println("#############################REMOVING A MAIN COURSE####################");
		super.remove(dishSet);		
	}
	
	@Override
	public void display(){
		System.out.println("######################MAIN COURSE########################");
		super.display(dishSet);
	}
	@Override
	public MainCourse getItem(int itemNo){
		return (MainCourse)super.getItem(itemNo, dishSet);
	}

	@Override
	public void toFile() {
		ConvertFromFile conv=new ConvertFromFile();
		conv.toFile(dishSet, "mainCourseMenu.txt");
		
	}


}
