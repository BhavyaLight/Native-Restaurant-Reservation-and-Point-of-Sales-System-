/**
 * @author Chandra Bhavya and Nguyen Thanh Tung
 * @since 7th November, 2014
 * @version 1.0
 * Polymorphism
 *  Single responsibility principle
 * Serialises and desrialises 
 */
package oops;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;

public class ConvertFromFile {
	/**
	 * Takes a set of dishItems
	 * @param dishSet
	 * @param fileName
	 */
public void toFile(Set<?> dishSet,String fileName){
	try {
		FileOutputStream fs = new FileOutputStream(fileName);
	ObjectOutputStream os=new ObjectOutputStream(fs);
		os.writeObject(dishSet);
	os.close();
	fs.close();
	} catch (IOException e) {
	e.printStackTrace();
}

}
/**
 * Deserializes a set structure
 */
public Set<?> fromFile(Set<?> dishSet,String fileName){
	try {
		FileInputStream fi=new FileInputStream(fileName);
		ObjectInputStream os=new ObjectInputStream(fi);
		dishSet=(Set<?>) os.readObject();
		os.close();
		fi.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		return dishSet; //occurs when initial file is empty, so return set as it is
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return dishSet;
	
}
/**
 * Serializes a Map structure
 * @param list
 * @param file
 */
public void toFile(Map<?,?> list, String file){
	try {
		FileOutputStream fs = new FileOutputStream(file);
	ObjectOutputStream os=new ObjectOutputStream(fs);
		os.writeObject(list);
	os.close();
	fs.close();
	} catch (IOException e) {
	e.printStackTrace();
}

}
/**
 * deserializes a map structure
 */
@SuppressWarnings("unchecked")
public Map<?,?> fromFile(Map<?,?> list,String file){
	try {
		FileInputStream fi=new FileInputStream(file);
		ObjectInputStream os=new ObjectInputStream(fi);
		list=(Map<String, Reservation>) os.readObject();
		os.close();
		fi.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		return list; //occurs when initial file is empty, so return set as it is
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	
}


}