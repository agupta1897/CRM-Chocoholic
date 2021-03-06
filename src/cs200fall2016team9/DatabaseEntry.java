package cs200fall2016team9;

import java.io.*;

/**
 *  @author Jake Bailey
 * Abstract class for use in storing and retreving information
 * Such as member or provider information.
 */

public abstract class DatabaseEntry {
	
    DatabaseEntry() {
        
    }
	private String name;
	private int number;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	
	/**
	 * Function checks if a code exists and returns true if so.
	 * @param type - either type Member or Provider
	 * @param code - code to be check if exists
	 * @return true if code exists
	 */
	protected static  boolean searchCode(String type, int code){
		File f;
		File x = new File("src/files/Provider Directory.txt");	//File to test for file locations
		if(type == "Member"){	//Code is member ID
			if(x.exists())	//If exists files under src directory
				f = new File("src/files/member files/"+code+".txt");
			else	//Otherwise files under implied path
				f = new File("files/member files/"+code+".txt");
			if(f.exists())	//If code is taken
				return true;
			else
				return false;
		}
		else if(type == "Provider"){	//Code is provider ID
			if(x.exists())	//If exists files under src directory
				f = new File("src/files/provider files/"+code+".txt");
			else	//Otherwise files under implied path
				f = new File("files/provider files/"+code+".txt");
			if(f.exists())	//If code is taken
				return true;
			else
				return false;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Abstract function of saveEntry.
	 * @throws IOException
	 */
	abstract void saveEntry() throws IOException;
	
	/**
	 * Function returns listed name.
	 * @return name
	 */
	protected String getName(){
		return name;
	}
	
	/**
	 * Function returns listed city
	 * @return city
	 */
	protected String getCity(){
		return city;
	}
	
	/**
	 * Function returns listed state
	 * @return state
	 */
	protected String getState(){
		return state;
	}
	
	/**
	 * Function returns listed address
	 * @return address
	 */
	protected String getAddress(){
		return address;
	}
	
	/**
	 * Function returns listed zip code
	 * @return zip code
	 */
	protected int getZipCode(){
		return zipCode;
	}
	
	/**
	 * Function returns listed ID number
	 * @return ID number
	 */
	protected int getNumber(){
		return number;
	}
	
	/**
	 * Function sets new name
	 * @param newName - new name
	 */
	protected void setName(String newName){
		name=newName;
	}
	
	/**
	 * Function sets new city
	 * @param newCity - new city
	 */
	protected void setCity(String newCity){
		city=newCity;
	}
	
	/**
	 * Function sets new address
	 * @param newAddress - new address
	 */
	protected void setAddress(String newAddress){
		address=newAddress;
	}
	
	/**
	 * Function sets new state
	 * @param newState - new state
	 */
	protected void setState(String newState){
		state=newState;
	}
	
	/**
	 * Function sets new zip code
	 * @param newZip - new zip code
	 */
	protected void setZIP(int newZip){
		zipCode=newZip;
	}
	
	/**
	 * Function sets new ID number
	 * @param newNumber - new ID number
	 */
	protected void setNumber(int newNumber){
		number=newNumber;
	}
}
