package cs200fall2016team9;

/**
 * 
 * @author Nate Wade
 *
 */

public abstract class Database {
	abstract void addEntry();
	abstract void removeEntry(int id);
	abstract void updateEntry(int id);
}