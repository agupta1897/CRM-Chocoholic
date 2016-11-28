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

public class VisitDatabase extends Visit {
	
	/* Vector<String> VmemberId = new Vector<String>();
	 Vector<String> VproviderId = new Vector<String>();
	 Vector<String> VserviceCode= new Vector<String>();
	 Vector<String> Vdate = new Vector<String>();
	 Vector<String> VcurrentDateAndTime = new Vector<String>();


*/

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
	
	/*void lookUpVisit ( int Filename, String type) throws IOException {
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
	

	
	*/
	@Override
	void addEntry() throws IOException{
		File f = new File("src/files/visit files/provider visit files/"+getProviderId()+"v.txt");
		Member m = new Member();
		Provider p = new Provider();
		ProviderDirectory pd= new ProviderDirectory();
		if(!f.exists())
			f.createNewFile();
		BufferedWriter fstream = null;
		fstream = new BufferedWriter(new FileWriter(f));
		fstream.write(getDate());
        fstream.newLine();
        fstream.write(getCurrentDateAndTime());
        fstream.newLine();
        //TODO look up member name
        fstream.write(m.returnName(getMemberId()));
        fstream.newLine();
		fstream.write(Integer.toString(getMemberId()));
		fstream.newLine();
		fstream.write(Integer.toString(getServiceCode()));
		fstream.newLine();
		fstream.write(Double.toString(pd.getServiceFee(getServiceCode())));
		//TODO look up service fee and print it
		fstream.write(getComment());
		fstream.write("\n");
		fstream.close();
		File f1 = new File("src/files/visit files/member visit files/"+getMemberId()+"v.txt");
		if(!f1.exists())
			f1.createNewFile();
		BufferedWriter fstream1 = null;
		fstream1 = new BufferedWriter(new FileWriter(f1));
		fstream1.write(getDate());
		fstream1.newLine();
		//TODO look up provider name with ID
		//temp print providerID
		fstream1.write(p.returnName(getProviderId()));
        fstream1.newLine();
		fstream1.write(Integer.toString(getProviderId()));
		fstream1.newLine();
		//TODO look up service name with ID
		//temp print service code
		fstream1.write(pd.getServiceName(getServiceCode()));
		fstream1.write("\n");
		fstream1.close();
		}
		// TODO Auto-generated method stub
		

/*void removeEntry(int filename) throws IOException{
    File a = new File("src/files/member files/"+filename+".txt");
    if(a.exists()){
       a.delete();
    	}
	}
*/
}
