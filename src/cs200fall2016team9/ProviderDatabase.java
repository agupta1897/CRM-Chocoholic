package cs200fall2016team9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class details the functions of the provider database.
 * 
 * 
 * @author Nate Wade
 *
 */

public class ProviderDatabase extends Database {

	/**
	 * Adds a new provider to database.
	 * @param name // name of provider
	 * @param num // id number of provider
	 * @param address // address of provider
	 * @param city // city they live in
	 * @param state // state they live in
	 * @param zip // their zip code number
	 */
	@Override
	void addEntry(String name, int num, String address, String city, String state, int zip) {
		Provider p = new Provider();
		p.addNewProvider(name, num, address, city, state, zip);
		try {
			p.saveEntry();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Removes a provider from database.
	 * @param id // id number of provider
	 */
	@Override
	void removeEntry(int id) {
		try {
			Files.deleteIfExists(Paths.get("src/files/provider files/" + id + ".txt"));
		} catch (Exception e) {

		}
	}
	
	/**
	 * Updates current provider in database.
	 * @param name // name of provider
	 * @param num // id number of provider
	 * @param address // address of provider
	 * @param city // city they live in
	 * @param state // state they live in
	 * @param zip // their zip code number
	 * @param oldId // last id provider had
	 */
	@Override
	void updateEntry(int id, String name, String address, String city, String state, int zip, int oldId) {
		Provider p = new Provider();
		if(id == oldId)
			p.addNewProvider(name, id, address, city, state, zip);
		else {
			File oldFile = new File("src/files/provider files/" + oldId + ".txt");
		    if(!oldFile.exists())
		    	oldFile = new File("files/provider files/" + oldId + ".txt");
		    File newFile = new File("src/files/provider files/" + id + ".txt");
		    if(!newFile.exists())
		    	newFile = new File("files/provider files/" + id + ".txt");
		    File oldVisitFile = new File("src/files/provider visit files/" + oldId + "v.txt");
		    if(!oldVisitFile.exists())
		    	oldVisitFile = new File("files/provider visit files/" + oldId + "v.txt");
		    File newVisitFile = new File("src/files/provider visit files/" + id + "v.txt");
		    if(!newVisitFile.exists())
		    	newVisitFile = new File("files/provider visit files/" + id + "v.txt");
            oldFile.renameTo(newFile);
            oldVisitFile.renameTo(newVisitFile);
			p.addNewProvider(name, id, address, city, state, zip);
		}
		try {
			removeEntry(id);
			p.saveEntry();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
