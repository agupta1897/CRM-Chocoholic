package cs200fall2016team9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * @author Nate Wade
 *
 */

public class ProviderDatabase extends Database {

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

	@Override
	void removeEntry(int id) {
		try {
			Files.deleteIfExists(Paths.get("src/files/member files/" + id + ".txt"));
		} catch (Exception e) {

		}
	}

	@Override
	void updateEntry(int id, String name, String address, String city, String state, int zip, int oldId) {
		Provider p = new Provider();
		if(id == oldId)
			p.addNewProvider(name, id, address, city, state, zip);
		else {
			oldFile.renameTo(newFile);
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
