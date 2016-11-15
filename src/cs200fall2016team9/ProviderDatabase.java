package cs200fall2016team9;

import java.util.HashMap;

public class ProviderDatabase extends Database {

	private HashMap<Integer, Provider> map = new HashMap<Integer, Provider>();

	@Override
	void addEntry() {
		// TODO Auto-generated method stub

	}

	@Override
	void removeEntry(int id) {
		map.remove(id);
	}

	@Override
	void updateEntry(int id) {
		// TODO Auto-generated method stub

	}
	
	void lookUpProvider(int id) {
		// TODO
	
	}
}
