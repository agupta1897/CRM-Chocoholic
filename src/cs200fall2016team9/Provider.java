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
	 * @throws IOException
	 */
	String returnName(int num) throws IOException{
		File f = new File("\\files\\provider files\\"+num+".txt");
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
	 * Function looks up provider's listed address and returns it.
	 * @param num - provider's ID number
	 * @return provider's listed address
	 * @throws IOException
	 */
	String returnAddress(int num) throws IOException{
		File f = new File("\\files\\provider files\\"+num+".txt");
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
	 * Function looks up provider's listed city and returns it.
	 * @param num - provider's ID number
	 * @return memeber's listed city
	 * @throws IOException
	 */
	String returnCity(int num) throws IOException{
		File f = new File("\\files\\provider files\\"+num+".txt");
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
	 * Function looks up provider's listed state and returns it.
	 * @param num - provider's ID number
	 * @return provider's listed state
	 * @throws IOException
	 */
	String returnState(int num) throws IOException{
		File f = new File("\\files\\provider files\\"+num+".txt");
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
	 * Function looks up provider's zip code and returns it.
	 * @param num - provider's ID number
	 * @return provider's zip code
	 * @throws IOException
	 */
	String returnZip(int num) throws IOException{
		File f = new File("\\files\\provider files\\"+num+".txt");
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
	 * Function adds new provider to provider files.
	 * @param name - provider's name
	 * @param num - provider's ID number
	 * @param address - provider's address
	 * @param city - provider's city
	 * @param state - provider's state
	 * @param zip - provider's zip code
	 */
	void addNewProvider(String name, int num, String address, String city, String state, int zip){
		setName(name);
		setNumber(num);
		setAddress(address);
		setCity(city);
		setState(state);
		setZIP(zip);
		try {
			saveEntry();
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
	File f = new File("\\files\\provider files\\"+getNumber()+".txt");
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
	fstream.close();
	}
}
