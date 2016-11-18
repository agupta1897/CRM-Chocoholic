package cs200fall2016team9;

/**
 * 
 * @author Nate Wade
 *
 */

public abstract class Database {
	abstract void addEntry(String name, int num, String address, String city, String state, int zip);
	abstract void removeEntry(int id);
	abstract void updateEntry(int id, String name, String address, String city, String state, int zip);
}
