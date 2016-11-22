package cs200fall2016team9;

import java.io.*;

/**
 * @author Jake Bailey
 * Class manages information of a provider and can write
 *	new information to the group of provider files.
 */

public class Provider extends DatabaseEntry{
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
	File f = new File("src/files/provider files/"+getNumber()+".txt");
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
