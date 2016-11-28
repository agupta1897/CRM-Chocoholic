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

	/*
	 * Adds a new provider to database.
	 * (non-Javadoc)
	 * @see cs200fall2016team9.Database#addEntry(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int)
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
	
	/*
	 * Removes a provider from database.
	 * (non-Javadoc)
	 * @see cs200fall2016team9.Database#removeEntry(int)
	 */
	@Override
	void removeEntry(int id) {
		try {
			Files.deleteIfExists(Paths.get("src/files/provider files/" + id + ".txt"));
		} catch (Exception e) {

		}
	}
	
	/*
	 * Updates current provider in database.
	 * (non-Javadoc)
	 * @see cs200fall2016team9.Database#updateEntry(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	void updateEntry(int id, String name, String address, String city, String state, int zip, int oldId) {
		Provider p = new Provider();
		if(id == oldId)
			p.addNewProvider(name, id, address, city, state, zip);
		else {
		    File oldFile = new File("src/files/provider files/" + oldId + ".txt");
            File newFile = new File("src/files/provider files/" + id + ".txt");
            File oldVisitFile = new File("src/files/provider visit files/" + oldId + "v.txt");
            File newVisitFile = new File("src/files/provider visit files/" + id + "v.txt");
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
