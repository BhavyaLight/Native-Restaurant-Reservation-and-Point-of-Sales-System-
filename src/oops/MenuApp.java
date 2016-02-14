/***
 * @author Chandra Bhavya
 * @version 1.0
 * @since 7th November 2014
 */
package oops;

import java.util.Scanner;

public class MenuApp{
	SalesReport report;
	/***
	 * 
	 * @param report:
	 * Taken in the salesReport and every time an item is created
	 * the item sales are appended to the report
	 */
	public MenuApp(SalesReport report){
		this.report=report;
	}
	/***
	 * Simply modifies menu depending on user choice
	 * Shows Dependency Injection Principle
	 * Here 'm' could be Main Course, Dessert or Drink
	 */
public void modifyMenu(){
	Scanner Sc=new Scanner(System.in);
	Menu m;
	MenuChoice menuChoice=new MenuChoice();
	boolean anotherMenu=true;
	while(anotherMenu){
	m=menuChoice.choseMenu();
	if(m!=null){
		
		System.out.println("\nWhat would you like to do next?");
		System.out.println("1.Create\n2.Update\n3.Remove\n4.Display\n5.Exit");
		int nextch=Sc.nextInt();
		while(nextch<5){
			switch(nextch){
			case 1: m.create(report); break;
			case 2: m.update(); break;
			case 3: m.remove(); break;
			case 4: m.display(); break;
			}
			m.toFile();
			System.out.println("\nWhat would you like to do next?");
			System.out.println("1.Create\n2.Update\n3.Remove\n4.Display\n5.Exit");
			nextch=Sc.nextInt();
		}
	}
		System.out.println("Chose another menu to modify?(True or False)");
		anotherMenu=Sc.nextBoolean();
	}
	
}
}
