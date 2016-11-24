package cs200fall2016team9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * 
 * @author Amber Gupta
 *
 */
/*Void returnName(int num) throws IOException{
	File f = new File("src/files/member files/"+num+".txt");
	String line = new String();
	if(f.exists()){
		BufferedReader read = new BufferedReader(new FileReader(f));
		line = read.readLine();
		read.close();
		return line;
	}
	else
		return "Invalid number";
}
*/
public class VisitDatabase extends Visit {
	
	 Vector<String> VmemberId = new Vector<String>();
	 Vector<String> VproviderId = new Vector<String>();
	 Vector<String> VserviceCode= new Vector<String>();
	 Vector<String> Vdate = new Vector<String>();
	 Vector<String> VcurrentDateAndTime = new Vector<String>();



	void addVisitInfo(int providerId, int memberId, String currentDateAndTime, String date, int serviceCode, String comment) {
		
		
		setProviderId(providerId);
		setMemberId(memberId);
		setCurrentDateAndTime(currentDateAndTime);
		setDate(date);
		setServiceCode(serviceCode);
		setComment(comment);
		try 
		{
			addEntry();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
	}
	
	void lookUpVisit ( int Filename, String type) throws IOException {
		String str;
		File f = new File("src/files/visit files/"+Filename+".txt");
		if(type=="member"){
			VproviderId.clear();
			VserviceCode.clear();
			Vdate.clear();
			if(f.exists()){
				BufferedReader read = new BufferedReader(new FileReader(f));
				VproviderId.addElement(read.readLine());
				VserviceCode.addElement(read.readLine());
				Vdate.addElement(read.readLine());
				read.readLine();
				while((str=read.readLine())!=null){
				VproviderId.addElement(str);
				VserviceCode.addElement(read.readLine());
				Vdate.addElement(read.readLine());
				read.readLine();
					}
				read.close();
				}
			}
		else if(type=="provider"){
			VmemberId.clear();
			VserviceCode.clear();
			Vdate.clear();
			VcurrentDateAndTime.clear();
			if(f.exists()){
				BufferedReader read = new BufferedReader(new FileReader(f));
				VmemberId.addElement(read.readLine());
				VserviceCode.addElement(read.readLine());
				Vdate.addElement(read.readLine());
				VcurrentDateAndTime.addElement(read.readLine());
				read.readLine();
				while((str=read.readLine())!=null){
				VmemberId.addElement(read.readLine());
				VserviceCode.addElement(read.readLine());
				Vdate.addElement(read.readLine());
				VcurrentDateAndTime.addElement(read.readLine());
				read.readLine();
				}
			read.close();
				}
		}
	}
	

	
	
	@Override
	void addEntry() throws IOException{
		File f = new File("src/files/visit files/"+getProviderId()+".txt");
		if(!f.exists())
			f.createNewFile();
		BufferedWriter fstream = null;
		fstream = new BufferedWriter(new FileWriter(f));
		fstream.write(getMemberId());
		fstream.newLine();
		fstream.write(Integer.toString(getServiceCode()));
		fstream.newLine();
		fstream.write(getDate());
		fstream.newLine();
		fstream.write(getCurrentDateAndTime());
		fstream.newLine();
		fstream.write("\n");
		fstream.close();
		File f1 = new File("src/files/visit files/"+getMemberId()+".txt");
		if(!f1.exists())
			f1.createNewFile();
		BufferedWriter fstream1 = null;
		fstream1 = new BufferedWriter(new FileWriter(f1));
		fstream1.write(getProviderId());
		fstream1.newLine();
		fstream1.write(Integer.toString(getServiceCode()));
		fstream1.newLine();
		fstream1.write(getDate());
		fstream1.write("\n");
		fstream1.close();
		}
		// TODO Auto-generated method stub
		

void removeEntry(int filename) throws IOException{
    File a = new File("src/files/member files/"+filename+".txt");
    if(a.exists()){
       a.delete();
    	}
	}
}
