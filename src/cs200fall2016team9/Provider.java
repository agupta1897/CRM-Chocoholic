package cs200fall2016team9;

import java.io.*;

/**
 * 
 * @author Jake Bailey
 *
 */

public class Provider extends DatabaseEntry{
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

	void saveEntry() throws IOException{
	File f = new File(Integer.toString(getNumber())+".txt");
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
