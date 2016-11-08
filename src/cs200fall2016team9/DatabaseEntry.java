package cs200fall2016team9;

public abstract class DatabaseEntry {
	
	private String name;
	private int number;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	
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
