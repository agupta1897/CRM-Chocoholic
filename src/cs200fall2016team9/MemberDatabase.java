package cs200fall2016team9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    public void addEntry(String name, int num, String address, String city, String state, int zip) {
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
	 * @throws IOException 
	 */
	@Override
    public void removeEntry(int id) throws IOException {
		try {
			Files.deleteIfExists(Paths.get("src/files/member files/" +id + ".txt"));
		} catch (Exception e) {}
		//sees if from eclipse or jar
		File x = new File("src/files/Provider Directory.txt");
		File f = new File("src/files/member files/allMembers.txt");
		File t = new File("src/files/member files/temp.txt");
		//if jar
        if(!x.exists()) {
            f = new File("files/member files/allMembers.txt");
            t = new File("files/member files/temp.txt");
        }
        t.createNewFile();
        BufferedReader reader = new BufferedReader(new FileReader(f));
        BufferedWriter writer = new BufferedWriter(new FileWriter(t));
        String lineToRemove = Integer.toString(id);
        String currentLine;
        for(int i = 0;(currentLine = reader.readLine())!= null; i++){
            //if the line equals the one to remove skip iteration
            if (currentLine.equals(lineToRemove)) 
                continue;
            //if it's not the first line print newLine
            if (i>0)
                writer.newLine();
            writer.write(currentLine);
        }
        writer.close(); 
        reader.close(); 
        Files.deleteIfExists(Paths.get("src/files/member files/allMembers.txt"));
        t.renameTo(f);
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
		    File newFile = new File("src/files/member files/" + id + ".txt");
		    File oldVisitFile = new File("src/files/member visit files/" + oldId + "v.txt");
		    File newVisitFile = new File("src/files/member visit files/" + id + "v.txt");
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
