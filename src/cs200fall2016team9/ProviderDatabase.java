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
 * This class details the functions of the provider database.
 * 
 * 
 * @author Nate Wade
 *
 */

public class ProviderDatabase extends Database {

	/**
	 * Adds a new provider to database.
	 * @param name // name of provider
	 * @param num // id number of provider
	 * @param address // address of provider
	 * @param city // city they live in
	 * @param state // state they live in
	 * @param zip // their zip code number
	 */
	@Override
    public void addEntry(String name, int num, String address, String city, String state, int zip) {
		Provider p = new Provider();
		p.addNewProvider(name, num, address, city, state, zip);
		try {
			p.saveEntry();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Removes a provider from database.
	 * @param id // id number of provider
	 * @throws IOException 
	 */
	@Override
    public void removeEntry(int id) throws IOException {
		try {
			Files.deleteIfExists(Paths.get("src/files/provider files/" + id + ".txt"));
		} catch (Exception e) {}
		File x = new File("src/files/Provider Directory.txt");
        File f = new File("src/files/Provider files/allProviders.txt");
        File t = new File("src/files/Provider files/temp.txt");
        if(!x.exists()) {
            f = new File("files/Provider files/allProviders.txt");
            t = new File("files/Provider files/temp.txt");
        }
            t.createNewFile();
        BufferedReader reader = new BufferedReader(new FileReader(f));
        BufferedWriter writer = new BufferedWriter(new FileWriter(t));
        String lineToRemove = Integer.toString(id);
        String currentLine;
        while((currentLine = reader.readLine())!= null){
            writer.write(currentLine);//Copy member visit information
            if (currentLine.equals(lineToRemove)) continue;
            writer.newLine();
        }
        writer.close(); 
        reader.close(); 
        Files.deleteIfExists(Paths.get("src/files/provider files/allProviders.txt"));
        t.renameTo(f);
	}
	
	/**
	 * Updates current provider in database.
	 * @param name // name of provider
	 * @param num // id number of provider
	 * @param address // address of provider
	 * @param city // city they live in
	 * @param state // state they live in
	 * @param zip // their zip code number
	 * @param oldId // last id provider had
	 */
	@Override
	void updateEntry(int id, String name, String address, String city, String state, int zip, int oldId) {
		Provider p = new Provider();
		if(id == oldId)
			p.addNewProvider(name, id, address, city, state, zip);
		else {
		    File oldFile = new File("src/files/provider files/" + oldId + ".txt");
            File newFile = new File("src/files/provider files/" + id + ".txt");
            File oldVisitFile = new File("src/files/provider visit files/" + oldId + "v.txt");
            File newVisitFile = new File("src/files/provider visit files/" + id + "v.txt");
            oldFile.renameTo(newFile);
            oldVisitFile.renameTo(newVisitFile);
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
