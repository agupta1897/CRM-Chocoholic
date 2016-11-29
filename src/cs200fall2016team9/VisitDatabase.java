package cs200fall2016team9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Amber Gupta
 * VisitDatabase Class extends the abstract Visit Class.
 * This class manages functions to write both the ProviderVisit and MemberVisit Files.
 */

public class VisitDatabase extends Visit {
	
	/**
	 * 
	 * As the name suggests, this function sets the visit information to respective parameter and then calls the add entry function to add the new visit Information.
	 * @param providerId - setProviderId(providerId);
	 * @param memberId - setMemberId(memberId);
	 * @param currentDateAndTime - setCurrentDateAndTime(currentDateAndTime);
	 * @param date - setDate(date);
	 * @param serviceCode - setServiceCode(serviceCode);
	 * @param comment - setComment(comment);
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
	
	
	@Override
	/**
	 * This function writes the respective details in both the Provider and Member visit files.
	 * This function calls other functions from Visit, Member, Provider to fetch Data to save in Visit files.
	 *
	 */
	void addEntry() throws IOException{
		File f;
		File a = new File("src/files/member files/allMembers.txt");
		if(a.exists()) 
			 f = new File("src/files/visit files/provider visit files/"+getProviderId()+"v.txt");
		else 
			 f = new File("files/visit files/provider visit files/"+getProviderId()+"v.txt");
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
        fstream.write(m.returnName(getMemberId()));
        fstream.newLine();
		fstream.write(Integer.toString(getMemberId()));
		fstream.newLine();
		fstream.write(Integer.toString(getServiceCode()));
		fstream.newLine();
		fstream.write(Double.toString(pd.getServiceFee(getServiceCode())));
		fstream.newLine();
		fstream.write(getComment());
		fstream.write("\n");
		fstream.close();
		File f1;
		File b = new File("src/files/member files/allMembers.txt");
		if(b.exists()) 
			 f1 = new File("src/files/visit files/provider visit files/"+getMemberId()+"v.txt");
		else 
			 f1 = new File("files/visit files/provider visit files/"+getMemberId()+"v.txt");
		if(!f1.exists())
			f1.createNewFile();
		BufferedWriter fstream1 = null;
		fstream1 = new BufferedWriter(new FileWriter(f1));
		fstream1.write(getDate());
		fstream1.newLine();
		fstream1.write(p.returnName(getProviderId()));
        fstream1.newLine();
		fstream1.write(pd.getServiceName(getServiceCode()));
		fstream1.write("\n");
		fstream1.close();
		}
		// TODO Auto-generated method stub
		


}
