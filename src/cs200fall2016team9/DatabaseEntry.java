package cs200fall2016team9;

import java.io.*;

/**
 * 
 * @author Jake Bailey
 *
 */

public abstract class DatabaseEntry {
	
	private String name;
	private int number;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	
	protected  boolean searchCode(String type, int code){
		File f = new File("");
		FileReader inF = null;
		try {inF = new FileReader(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader in = new BufferedReader(inF);
		String s = null;
		int num = 0;
		try {s = in.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(s != null){
			try {s = in.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{num = Integer.parseInt(s);
			}catch(Exception e){}
			if(num==code)
				return true;
		}
		return false;
	}
	
	abstract void saveEntry() throws IOException;
	
	protected String getName(){
		return name;
	}
	
	protected String getCity(){
		return city;
	}
	
	protected String getState(){
		return state;
	}
	
	protected String getAddress(){
		return address;
	}
	protected int getZipCode(){
		return zipCode;
	}
	
	protected int getNumber(){
		return number;
	}
	
	protected void setName(String newName){
		name=newName;
	}
	
	protected void setCity(String newCity){
		city=newCity;
	}
	
	protected void setAddress(String newAddress){
		address=newAddress;
	}
	
	protected void setState(String newState){
		state=newState;
	}
	
	protected void setZIP(int newZip){
		zipCode=newZip;
	}
	
	protected void setNumber(int newNumber){
		number=newNumber;
	}
}
