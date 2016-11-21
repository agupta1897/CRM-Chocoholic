package cs200fall2016team9;

import java.io.*;

/**
 * @author Sean Martin
 */
public class MemberReport {

	MemberReport(){
		
	}
	//send group
	void memberReport() throws IOException{
		BufferedReader Charlie=new BufferedReader(new FileReader("\\files\\member files\\allMembers.txt"));
		String line = null;
		while((line=Charlie.readLine())!=null){
			memberReport(Integer.parseInt(line));
		}
		Charlie.close();
	}
	//Send individual
	void memberReport(int numberID) throws IOException{
		BufferedReader alpha = new BufferedReader(new FileReader("\\files\\member files\\"+numberID+".txt"));
		BufferedWriter beta = new BufferedWriter(new FileWriter("\\files\\member reports\\"+numberID+"Report.txt"));
		String line = new String();
		for(int i=0;i<=5;i++){
			line=alpha.readLine();
			beta.write(line);
			beta.newLine();
		}
		alpha.close();
		alpha = new BufferedReader(new FileReader("\\files\\visit files\\member visit files\\"+numberID+"v.txt"));
		while((line = alpha.readLine())!= null){
			beta.write(line);
			beta.newLine();
		}
		alpha.close();
		beta.close();
	}
}
