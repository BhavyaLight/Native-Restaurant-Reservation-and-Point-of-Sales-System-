/**
 * @author Chandra Bhavya
 * @version 1.0
 * @since 7th November,2014
 * Extends Items, in turn realizing MenuItems interface
 */

package oops;

public class Dessert extends Items{
private static final long serialVersionUID = 271062335451776145L;
private boolean addWaffers;
private boolean addNuts;
/**
 * parameterized constructor
 */
public Dessert(){
	super("",0,"");
	addWaffers=false;
	addNuts=false;
}
/**
 * non parameterized constructor
 * @param name
 * @param price
 * @param description
 * @param waffer
 * @param nut
 */
public Dessert(String name,double price,String description,boolean waffer, boolean nut){
	super(name,price,description);
	this.addWaffers=waffer;
	this.addNuts=nut;
}
/**
 * Setters to set waffers
 * @param adwf
 */
public void addWaffers(boolean adwf){
	addWaffers=adwf;
}
/**
 * Seeter to set nuts
 * @param adnt
 */
public void addNuts(boolean adnt){
	addNuts=adnt;
}
/**
 * returns whether item has waffers
 * @return
 */
public boolean getWaffers(){
	return addWaffers;
}
/**
 * returns whether item has nuts
 * @return
 */
public boolean getNuts(){
	return addNuts;
}
@Override
public String toString() {
	String wf,nt,s;
	if(addWaffers)
		wf="with waffer";
	else
		wf="without waffer";
	if(addNuts)
		nt="with nuts";
	else
		nt="without nuts";
	s=super.toString();
	return s+"\n"+wf+","+nt;	
}

}
