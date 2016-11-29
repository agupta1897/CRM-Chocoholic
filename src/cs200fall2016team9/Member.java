package cs200fall2016team9;

import java.io.*;

/**
 * @author Jake Bailey
 * Class manages the information of a member and can write
 * 	new information to the group of member files.
 */

public class Member extends DatabaseEntry {
	
	private String memberStatus;
	
	public Member(){
	}
	
	/**
	 * Function sets member's status.
	 * @param newStatus - member's new status
	 */
	void setStatus(String newStatus){
		memberStatus=newStatus;
	}
		
	/**
	 * Function returns the member's current status.
	 * @return member's current status
	 */
	String getStatus(){
		return memberStatus;
	}
	
	/**
	 * Function looks up member's listed name and returns it.
	 * @param num - member's ID number
	 * @return member's listed name
	 * @throws IOException throws error
	 */
	public String returnName(int num) throws IOException{
		File f = new File("src/files/member files/"+num+".txt");
		if(!f.exists())	//If filed doesn't exist files are under implied directory
			f = new File("files/member files/"+num+".txt");
		String line = new String();
		if(f.exists()){	//File exists and name can be read and output
			BufferedReader read = new BufferedReader(new FileReader(f));
			line = read.readLine();
			read.close();
			return line;
		}
		else	//No such member file under given ID
			return "Invalid number";
	}
	
	/**
	 * Function looks up member's listed address and returns it.
	 * @param num - member's ID number
	 * @return member's listed address
	 * @throws IOException throws error
	 */
	String returnAddress(int num) throws IOException{
		File f = new File("src/files/member files/"+num+".txt");
		if(!f.exists())	//If filed doesn't exist files are under implied directory
			f = new File("files/member files/"+num+".txt");
		String line = new String();
		if(f.exists()){	//File exists and address can be read and output
			BufferedReader read = new BufferedReader(new FileReader(f));
			for(int i=0;i<=2;i++){
				line = read.readLine();
			}
			read.close();
			return line;
		}
		else	//No such member file under given ID
			return "Invalid number";
	}
	
	/**
	 * Function looks up member's listed city and returns it.
	 * @param num - member's ID number
	 * @return memeber's listed city
	 * @throws IOException throws error
	 */
	String returnCity(int num) throws IOException{
		File f = new File("src/files/member files/"+num+".txt");
		if(!f.exists())	//If filed doesn't exist files are under implied directory
			f = new File("files/member files/"+num+".txt");
		String line = new String();
		if(f.exists()){	//File exists and city can be read and output
			BufferedReader read = new BufferedReader(new FileReader(f));
			for(int i=0;i<=3;i++){
				line = read.readLine();
			}
			read.close();
			return line;
		}
		else	//No such member file under given ID
			return "Invalid number";
	}
	
	/**
	 * Function looks up member's listed state and returns it.
	 * @param num - member's ID number
	 * @return member's listed state
	 * @throws IOException throws error
	 */
	public String returnState(int num) throws IOException{
		File f = new File("src/files/member files/"+num+".txt");
		if(!f.exists())	//If filed doesn't exist files are under implied directory
			f = new File("files/member files/"+num+".txt");
		String line = new String();
		if(f.exists()){	//File exists and state can be read and output
			BufferedReader read = new BufferedReader(new FileReader(f));
			for(int i=0;i<=4;i++){
				line = read.readLine();
			}
			read.close();
			return line;
		}
		else	//No such member file under given ID
			return "Invalid number";
	}
	
	/**
	 * Function looks up member's zip code and returns it.
	 * @param num - member's ID number
	 * @return member's zip code
	 * @throws IOException throws error
	 */
	int returnZip(int num) throws IOException{
		File f = new File("src/files/member files/"+num+".txt");
		if(!f.exists())	//If filed doesn't exist files are under implied directory
			f = new File("files/member files/"+num+".txt");
		String line = new String();
		int zip = 0;
		if(f.exists()){	//File exists and zip code can be read and output
			BufferedReader read = new BufferedReader(new FileReader(f));
			for(int i=0;i<=5;i++){
				line = read.readLine();
			}
			read.close();
			zip = Integer.parseInt(line);
			return zip;
		}
		else {	//No such member file under given ID
		    System.out.println("Something went wrong in Member.java returnZip()");
			return 00000;
		}
	}
	
	/**
     * Function searches for the member file, pulls the listed status, and returns a string of the status.
     * @param num - member's ID number
     * @return member's listed status or reason of issue
     * @throws IOException throws error
     */
    public String returnStatus(int num) throws IOException{
        File a = new File("src/files/member files/"+num+".txt");
        if (!a.exists()) {	//If filed doesn't exist files are under implied directory
            a = new File("files/member files/"+num+".txt");
        }
        String line = new String();
        if(a.exists()){	//File exists and status can be read and output
            BufferedReader read = new BufferedReader(new FileReader(a));
            for(int i=0;i<=6;i++){
                line = read.readLine();
            }
            read.close();
            return line;
        }
        else	//No such member file under given ID
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
		File x = new File("src/files/Provider Directory.txt");	//File for file location verification
		BufferedWriter writer = null;
		setName(name);
		setNumber(num);
		setAddress(address);
		setCity(city);
		setState(state);
		setZIP(zip);
		setStatus("Validated");	//Set status as default of Validated
		try {
			saveEntry();	//Write info into file with proper format
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(x.exists())	//File exists and so files are under src directory
				writer = new BufferedWriter(new FileWriter("src/files/member files/allMembers.txt", true));
			else	//File doesn't exist there and so files are under implied directory
				writer = new BufferedWriter(new FileWriter("files/member files/allMembers.txt", true));
			writer.newLine();	//Move to new last line of allMembers file
			writer.append(Integer.toString(num));	//Append new member ID to end of allMembers file
			writer.close();	//Close allMembers file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Function writes member's information to a new member file
	 * 	with the member ID as the title.
	 * @throws IOException 
	 */
	void saveEntry() throws IOException{
	File f = new File("src/files/member files/"+getNumber()+".txt");
	File x = new File("src/files/Provider Directory.txt");	//File for location verification
	if(!x.exists())	//File doesn't exist here and so files are under implied directory
		f = new File("files/member files/"+getNumber()+".txt");
	if(!f.exists())	//File isn't made yet so file needs to be made
		f.createNewFile();
	BufferedWriter fstream = null;
	fstream = new BufferedWriter(new FileWriter(f));	//Write info into file with proper format
	fstream.write(getName());
	fstream.newLine();
	fstream.write(Integer.toString(getNumber()));
	fstream.newLine();
	fstream.write(getAddress());
	fstream.newLine();
	fstream.write(getCity());
	fstream.newLine();
	fstream.write(getState());
	fstream.newLine();
	fstream.write(Integer.toString(getZipCode()));
	fstream.newLine();
	fstream.write(getStatus());
	fstream.close();
	}
}
