package cs200fall2016team9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * @author Nate Wade
 *
 */

public class MemberDatabase extends Database {

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

	@Override
	void removeEntry(int id) {
		try {
			Files.deleteIfExists(Paths.get("src/files/member files/" +id + ".txt"));
		} catch (Exception e) {

		}
	}

	@Override
	void updateEntry(int id, String name, String address, String city, String state, int zip, int oldId) {
		Member m = new Member();
		if(id == oldId)
			m.addNewMember(name, id, address, city, state, zip);
		else {
		    File oldFile = new File("src/files/member files/" + oldId + ".txt");
		    File newFile = new File("src/files/member files/" + id + ".txt");
		    File oldVisitFile = new File("src/files/member visit files/" + oldId + ".txt");
		    File newVisitFile = new File("src/files/member visit files/" + id + ".txt");
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
