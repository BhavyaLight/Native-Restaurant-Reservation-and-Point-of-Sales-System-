/**
 * @author Chandra Bhavya
 * @version 1.0
 * @since 7th November,2014
 * Illustrating Dependency Injection Principle
 */
package oops;

import java.util.Scanner;
/**
 * 
 * Returns menu chosen
 *
 */
public class MenuChoice {
	public Menu choseMenu(){
		Scanner Sc=new Scanner(System.in);
		Menu m;
			System.out.println("Chose menu item from:\n1.Main Course\n"
					+ "2.Dessert\n3.Drink\n4.Set package\n5.Exit");
			int menuChoice=Sc.nextInt();
			switch(menuChoice){
			case 1:
				m=new MainCourseMenu();
				break;
			case 2:
				m=new DessertMenu();
				break;
			case 3:
				m=new DrinkMenu();
				break;
			case 4:
				m=new PromotionalPackagesMenu(new MainCourseMenu(),new DrinkMenu(), new DessertMenu());
				break;
			default:
				m=null;
			}
			return m;
	}
}
