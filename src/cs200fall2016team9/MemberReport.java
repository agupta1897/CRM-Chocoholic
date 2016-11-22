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
		BufferedReader Charlie=new BufferedReader(new FileReader("src/files/member files/allMembers.txt"));
		String line = null;
		while((line=Charlie.readLine())!=null){
			memberReport(Integer.parseInt(line));
		}
		Charlie.close();
	}
	/**
	 * Creates a single Member Report
	 * @param numberID
	 * @throws IOException
	 */
	void memberReport(int numberID) throws IOException{
		BufferedReader alpha = new BufferedReader(new FileReader("src/files/member files/"+numberID+".txt"));
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		//TODO get member name
		BufferedWriter beta = new BufferedWriter(new FileWriter("src/files/report files/member reports/"+numberID+date+".txt"));
		String line = new String();
		for(int i=0;i<=5;i++){
			line=alpha.readLine();
			beta.write(line);
			beta.newLine();
		}
		alpha.close();
		alpha = new BufferedReader(new FileReader("src/files/visit files/member visit files/"+numberID+"v.txt"));
		while((line = alpha.readLine())!= null){
			beta.write(line);
			beta.newLine();
		}
		alpha.close();
		beta.close();
	}
}
