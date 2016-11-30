package cs200fall2016team9;

import java.io.*;

/**
 * @author Jake Bailey
 * Class manages information of a provider and can write
 *	new information to the group of provider files.
 */

public class Provider extends DatabaseEntry{
	/**
	 * Function looks up provider's listed name and returns it.
	 * @param num - provider's ID number
	 * @return provider's listed name
	 * @throws IOException throws error
	 */
	public String returnName(int num) throws IOException{
		File f = new File("src/files/provider files/"+num+".txt");
		if(!f.exists())	//If filed doesn't exist files are under implied directory
			f = new File("files/provider files/"+num+".txt");
		String line = new String();
		if(f.exists()){	//File exists and name can be read and output
			BufferedReader read = new BufferedReader(new FileReader(f));
			line = read.readLine();
			read.close();
			return line;
		}
		else	//No such provider file under given ID
			return "Invalid number";
	}
	
	/**
	 * Function looks up provider's listed address and returns it.
	 * @param num - provider's ID number
	 * @return provider's listed address
	 * @throws IOException throws error
	 */
	String returnAddress(int num) throws IOException{
		File f = new File("src/files/provider files/"+num+".txt");
		if(!f.exists())	//If filed doesn't exist files are under implied directory
			f = new File("files/provider files/"+num+".txt");
		String line = new String();
		if(f.exists()){	//File exists and address can be read and output
			BufferedReader read = new BufferedReader(new FileReader(f));
			for(int i=0;i<=2;i++){
				line = read.readLine();
			}
			read.close();
			return line;
		}
		else	//No such provider file under given ID
			return "Invalid number";
	}
	
	/**
	 * Function looks up provider's listed city and returns it.
	 * @param num - provider's ID number
	 * @return memeber's listed city
	 * @throws IOException throws error
	 */
	String returnCity(int num) throws IOException{
		File f = new File("src/files/provider files/"+num+".txt");
		if(!f.exists())	//If filed doesn't exist files are under implied directory
			f = new File("files/provider files/"+num+".txt");
		String line = new String();
		if(f.exists()){	//File exists and city can be read and output
			BufferedReader read = new BufferedReader(new FileReader(f));
			for(int i=0;i<=3;i++){
				line = read.readLine();
			}
			read.close();
			return line;
		}
		else	//No such provider file under given ID
			return "Invalid number";
	}
	
	/**
	 * Function looks up provider's listed state and returns it.
	 * @param num - provider's ID number
	 * @return provider's listed state
	 * @throws IOException throws error
	 */
	public String returnState(int num) throws IOException{
		File f = new File("src/files/provider files/"+num+".txt");
		if(!f.exists())	//If filed doesn't exist files are under implied directory
			f = new File("files/provider files/"+num+".txt");
		String line = new String();
		if(f.exists()){	//File exists and state can be read and output
			BufferedReader read = new BufferedReader(new FileReader(f));
			for(int i=0;i<=4;i++){
				line = read.readLine();
			}
			read.close();
			return line;
		}
		else	//No such provider file under given ID
			return "Invalid number";
	}
	
	/**
	 * Function looks up provider's zip code and returns it.
	 * @param num - provider's ID number
	 * @return provider's zip code
	 * @throws IOException
	 */
	int returnZip(int num) throws IOException{
		File f = new File("src/files/provider files/"+num+".txt");
		if(!f.exists())	//If filed doesn't exist files are under implied directory
			f = new File("files/provider files/"+num+".txt");
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
		else {	//No such provider file under given ID
			System.out.println("Something went wrong in returnZip()");
            return 00000;
		}
	}
	
	/**
	 * Function adds new provider to provider files.
	 * @param name - provider's name
	 * @param num - provider's ID number
	 * @param address - provider's address
	 * @param city - provider's city
	 * @param state - provider's state
	 * @param zip - provider's zip code
	 */
	void addNewProvider(String name, int num, String address, String city, String state, int zip){
		File x = new File("src/files/Provider Directory.txt");	//File for location verification
		BufferedWriter writer = null;
		setName(name);
		setNumber(num);
		setAddress(address);
		setCity(city);
		setState(state);
		setZIP(zip);
		try {
			saveEntry();	//Write info to file with proper format
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(x.exists())	//File exists and so files are under src directory
				writer = new BufferedWriter(new FileWriter("src/files/provider files/allProviders.txt", true));
			else	//File doesn't exist and so files are under implied directory
				writer = new BufferedWriter(new FileWriter("files/provider files/allProviders.txt", true));
			writer.newLine();	//Move to last line of allProviders file
			writer.append(Integer.toString(num));	//Append new provider ID to end of allProviders file
			writer.close();	//Close allProviders file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Function writes provider's information to a new provider file
	 * 	with the provider ID as the title.
	 */
	void saveEntry() throws IOException{
	File f = new File("src/files/provider files/"+getNumber()+".txt");
	File x = new File("src/files/Provider Directory.txt");	//File for location verification
	if(!x.exists())	//File doesn't exist and so files are under implied directory
		f = new File("files/provider files/"+getNumber()+".txt");
	if(!f.exists())	//File isn't made yet so needs to be made
		f.createNewFile();
	BufferedWriter fstream = null;
	fstream = new BufferedWriter(new FileWriter(f));	//Write info to file with proper format
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
	fstream.close();
	}
}
