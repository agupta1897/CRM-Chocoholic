package cs200fall2016team9;

/**
 * 
 * @author Nate Wade
 *
 */

public abstract class Database {
	/**
	 * This class is the base abstracts for these functions.
	 * @param name // name of member/provider
	 * @param num // id number
	 * @param address // address of member/provider
	 * @param city // city they live in
	 * @param state // state they live in
	 * @param zip // their zip code number
	 */
	abstract void addEntry(String name, int num, String address, String city, String state, int zip);
	abstract void removeEntry(int id);
	abstract void updateEntry(int id, String name, String address, String city, String state, int zip, int oldId);
}
