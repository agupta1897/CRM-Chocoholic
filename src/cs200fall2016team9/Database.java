package cs200fall2016team9;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class is the base abstracts for these functions.
 * 
 * @author Nate Wade
 *
 */

public abstract class Database {
	/**
	 * Base abstract function for adding an entry.
	 * @param name // name of member/provider
	 * @param num // id number
	 * @param address // address of member/provider
	 * @param city // city they live in
	 * @param state // state they live in
	 * @param zip // their zip code number
	 */
	abstract void addEntry(String name, int num, String address, String city, String state, int zip);
	/**
	 * Base abstract function for removing an entry.
	 * @param id the id
	 * @throws FileNotFoundException throws error
	 * @throws IOException throws error
	 */
	abstract void removeEntry(int id) throws IOException;
	/**
	 * Base abstract function for updating a current entry.
	 * @param id // id number for entry
	 * @param name // name of entry
	 * @param address // address of entry
	 * @param city // city of entry
	 * @param state // state of entry
	 * @param zip // zip code number of entry
	 * @param oldId // last id of entry
	 */
	abstract void updateEntry(int id, String name, String address, String city, String state, int zip, int oldId);
}
