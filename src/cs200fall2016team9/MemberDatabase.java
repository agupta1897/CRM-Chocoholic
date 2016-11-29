package cs200fall2016team9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class details the functions of the member database.
 * 
 * 
 * @author Nate Wade
 *
 */

public class MemberDatabase extends Database {
	
	/**
	 * Adds a new member to database.
	 * @param name // name of member
	 * @param num // id number of member
	 * @param address // address of member
	 * @param city // city they live in
	 * @param state // state they live in
	 * @param zip // their zip code number
	 */
	@Override
	void addEntry(String name, int num, String address, String city, String state, int zip) {
		Member m = new Member();
		m.addNewMember(name, num, address, city, state, zip);
		try {
			m.saveEntry();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Removes a member from database.
	 * @param id // id number of member
	 */
	@Override
	void removeEntry(int id) {
		try {
			Files.deleteIfExists(Paths.get("src/files/member files/" +id + ".txt"));
		} catch (Exception e) {

		}
	}
	
	/**
	 * Updates current member in database.
	 * @param id // id number of member
	 * @param name // name of member
	 * @param address // address of member
	 * @param city // city they live in
	 * @param state // state they live in
	 * @param zip // their zip code number
	 * @param oldId // last id member had
	 */
	@Override
	void updateEntry(int id, String name, String address, String city, String state, int zip, int oldId) {
		Member m = new Member();
		if(id == oldId)
			m.addNewMember(name, id, address, city, state, zip);
		else {
		    File oldFile = new File("src/files/member files/" + oldId + ".txt");
		    if(!oldFile.exists())
		    	oldFile = new File("files/member files/" + oldId + ".txt");
		    File newFile = new File("src/files/member files/" + id + ".txt");
		    if(!newFile.exists())
		    	newFile = new File("files/member files/" + id + ".txt");
		    File oldVisitFile = new File("src/files/member visit files/" + oldId + "v.txt");
		    if(!oldVisitFile.exists())
		    	oldVisitFile = new File("files/member visit files/" + oldId + "v.txt");
		    File newVisitFile = new File("src/files/member visit files/" + id + "v.txt");
		    if(!newVisitFile.exists())
		    	newVisitFile = new File("files/member visit files/" + id + "v.txt");
		    oldFile.renameTo(newFile);
		    oldVisitFile.renameTo(newVisitFile);
		    m.addNewMember(name, id, address, city, state, zip);
		}
		try {
			removeEntry(id);
			m.saveEntry();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
