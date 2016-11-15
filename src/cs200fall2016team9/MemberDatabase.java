package cs200fall2016team9;

import java.util.HashMap;

public class MemberDatabase extends Database {

	private HashMap<Integer, Member> map = new HashMap<Integer, Member>();

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

	void lookUpMember(int id) {
		// TODO
	}
}
