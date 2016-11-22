package cs200fall2016team9;

import java.io.*;

/**
 * @author Jake Bailey
 * Class manages the information of a member and can write
 * 	new information to the group of member files.
 */

public class Member extends DatabaseEntry {
	
	private String memberStatus;
	
	Member(){
	}
	
	/**
	 * Function sets member's status.
	 * @param newStatus - member's new status
	 */
	void setStatus(String newStatus){
		memberStatus=newStatus;
	}
	
	/**
	 * Function searches for the member file, pulls the listed status, and returns a string of the status.
	 * @param num - member's ID number
	 * @return member's listed status or reason of issue
	 * @throws IOException
	 */
	String getStatus(int num) throws IOException{
		File a = new File("src/files/member files/"+num+".txt");
		String line = new String();
		if(a.exists()){
			BufferedReader read = new BufferedReader(new FileReader(a));
			for(int i=0;i<=6;i++){
				line = read.readLine();
			}
			read.close();
			return line;
		}
		else
			return "Invalid number";
	}
	
	/**
	 * Function returns the member's current status.
	 * @return member's current status
	 */
	String getStatus2(){
		return memberStatus;
	}
	
	/**
	 * Function looks up member's listed name and returns it.
	 * @param num - member's ID number
	 * @return member's listed name
	 * @throws IOException
	 */
	String returnName(int num) throws IOException{
		File f = new File("src/files/member files/"+num+".txt");
		String line = new String();
		if(f.exists()){
			BufferedReader read = new BufferedReader(new FileReader(f));
			line = read.readLine();
			read.close();
			return line;
		}
		else
			return "Invalid number";
	}
	
	/**
	 * Function looks up member's listed address and returns it.
	 * @param num - member's ID number
	 * @return member's listed address
	 * @throws IOException
	 */
	String returnAddress(int num) throws IOException{
		File f = new File("src/files/member files/"+num+".txt");
		String line = new String();
		if(f.exists()){
			BufferedReader read = new BufferedReader(new FileReader(f));
			for(int i=0;i<=2;i++){
				line = read.readLine();
			}
			read.close();
			return line;
		}
		else
			return "Invalid number";
	}
	
	/**
	 * Function looks up member's listed city and returns it.
	 * @param num - member's ID number
	 * @return memeber's listed city
	 * @throws IOException
	 */
	String returnCity(int num) throws IOException{
		File f = new File("src/files/member files/"+num+".txt");
		String line = new String();
		if(f.exists()){
			BufferedReader read = new BufferedReader(new FileReader(f));
			for(int i=0;i<=3;i++){
				line = read.readLine();
			}
			read.close();
			return line;
		}
		else
			return "Invalid number";
	}
	
	/**
	 * Function looks up member's listed state and returns it.
	 * @param num - member's ID number
	 * @return member's listed state
	 * @throws IOException
	 */
	String returnState(int num) throws IOException{
		File f = new File("src/files/member files/"+num+".txt");
		String line = new String();
		if(f.exists()){
			BufferedReader read = new BufferedReader(new FileReader(f));
			for(int i=0;i<=4;i++){
				line = read.readLine();
			}
			read.close();
			return line;
		}
		else
			return "Invalid number";
	}
	
	/**
	 * Function looks up member's zip code and returns it.
	 * @param num - member's ID number
	 * @return member's zip code
	 * @throws IOException
	 */
	String returnZip(int num) throws IOException{
		File f = new File("src/files/member files/"+num+".txt");
		String line = new String();
		if(f.exists()){
			BufferedReader read = new BufferedReader(new FileReader(f));
			for(int i=0;i<=5;i++){
				line = read.readLine();
			}
			read.close();
			return line;
		}
		else
			return "Invalid number";
	}
	
	/**
	 * Function adds new member to member files.
	 * @param name - member's name
	 * @param num - member's ID number
	 * @param address - member's address
	 * @param city - member's city
	 * @param state - member's state
	 * @param zip - member's zip code
	 */
	void addNewMember(String name, int num, String address, String city, String state, int zip){
		setName(name);
		setNumber(num);
		setAddress(address);
		setCity(city);
		setState(state);
		setZIP(zip);
		setStatus("Validated");
		try {
			saveEntry();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Function writes member's information to a new member file
	 * 	with the member ID as the title.
	 */
	void saveEntry() throws IOException{
	File f = new File("src/files/member files/"+getNumber()+".txt");
	BufferedWriter fstream = null;
	fstream = new BufferedWriter(new FileWriter(f));
	fstream.write(getName());
	fstream.newLine();
	fstream.write(getNumber());
	fstream.newLine();
	fstream.write(getAddress());
	fstream.newLine();
	fstream.write(getCity());
	fstream.newLine();
	fstream.write(getState());
	fstream.newLine();
	fstream.write(getZipCode());
	fstream.newLine();
	fstream.write(getStatus2());
	fstream.close();
	}
}
