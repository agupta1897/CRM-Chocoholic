package cs200fall2016team9;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Develops Single or All member Reports
 * @author Sean Martin
 */
public class MemberReport {
	/**
	 * Constructor
	 */
	MemberReport(){
		
	}
	/**
	 * Send all member Files
	 * @throws IOException
	 */
	void memberReport() throws IOException{
		File a = new File("src/files/member files/allMembers.txt");//check if using Jar or Eclipse
		String s = "files/member files/allMembers.txt";
		if(a.exists()){//If using eclipse add SRC to address
			s="src/"+s;
		}
		BufferedReader Charlie=new BufferedReader(new FileReader(s));
		String line = null;// Read through all members and file memberReport for each member number
		while((line=Charlie.readLine())!=null){
			memberReport(Integer.parseInt(line));
		}
		Charlie.close();//close allMembers
	}
	/**
	 * Creates a single Member Report
	 * @param numberID
	 * @throws IOException
	 */
	void memberReport(int numberID) throws IOException{
		File a = new File("src/files/member files/allMembers.txt");//check if using Jar or Eclipse
		String s = "files/member files/";
		if(a.exists()){//If using eclipse add SRC to address
			s="src/"+s;
		}//Open member File
		BufferedReader alpha = new BufferedReader(new FileReader(s+numberID+".txt"));
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		a = new File("src/files/member files/allMembers.txt");//check if using Jar or Eclipse
		s = "files/report files/member report files/";
		if(a.exists()){//If using eclipse add SRC to address
			s="src/"+s;
		}//Open member report file to write
		BufferedWriter beta = new BufferedWriter(new FileWriter(s+numberID+date+".txt"));
		String line = new String();
		for(int i=0;i<=5;i++){//copy member information
			line=alpha.readLine();
			beta.write(line);
			beta.newLine();
		}
		alpha.close();//close file
		a = new File("src/files/member files/allMembers.txt");//check if using Jar or Eclipse
		s = "files/visit files/member visit files/";
		if(a.exists()){//If using eclipse add SRC to address
			s="src/"+s;
		}
		alpha = new BufferedReader(new FileReader(s+numberID+"v.txt"));
		while((line = alpha.readLine())!= null){
			beta.write(line);//Copy member visit information
			beta.newLine();
		}
		alpha.close();
		beta.close();
	}
}
