package cs200fall2016team9;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Create Single or All Provider Reports
 * @author Sean Martin
 */
public class ProviderReport {
	/**
	 * Constructor
	 */
	public ProviderReport(){
		
	}
	/**
	 * Send All Provider Reports
	 * @throws IOException throws error
	 */
	void providerReport() throws IOException{
		File a = new File("src/files/provider files/allProviders.txt");//check if using Jar or Eclipse
		String s = "files/provider files/allProviders.txt";
		if(a.exists()){//If using eclipse add SRC to address
			s="src/"+s;
		}
		BufferedReader Charlie=new BufferedReader(new FileReader(s));
		String line = null;//Read through all providers and call provider report for each
		while((line=Charlie.readLine())!=null){
			providerReport(Integer.parseInt(line));
		}
		Charlie.close();//Close allProviders.txt
	}
	/**
	 * Compile and Save a Single Provider Report
	 * @param numberID the id number
	 * @throws IOException throws error
	 */
	public void providerReport(int numberID) throws IOException{
		File a = new File("src/files/provider files/allProviders.txt");
		String s = "files/provider files/"; //Check to see if using eclipse or Jar
		if(a.exists()){
			s="src/"+s;//if eclipse then add src/
		}
		BufferedReader alpha = new BufferedReader(new FileReader(s+numberID+".txt")); //Open provider file
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		a = new File("src/files/provider files/allProviders.txt");
		s = "files/report files/provider report files/";
		if(a.exists()){//Check to see if using Eclipse
			s="src/"+s;
		}//write provider report file
		BufferedWriter beta = new BufferedWriter(new FileWriter(s+numberID+date+"Report.txt"));
		String line = new String();
		for(int i=0;i<=5;i++){//Write provider information to provider report file
			line=alpha.readLine();
			beta.write(line);
			beta.newLine();
		}
		alpha.close();
		a = new File("src/files/provider files/allProviders.txt");
		s = "files/visit files/provider visit files/";
		if(a.exists()){//check to see if using eclipse
			s="src/"+s;
		}//Open provider visit file
		alpha = new BufferedReader(new FileReader(s+numberID+"v.txt"));
		double totalFee=0;//Create variables to measure total fee, consultation, and the line number of the file
		int totalConsul=0;
		int lineNumber=0;
		while((line = alpha.readLine())!= null){
			lineNumber++;//Read through the file while adding up the number of consultations and total fees.
			if(lineNumber%8==6){// Every 6th line is a fee line
				totalConsul++;
				totalFee+=Double.parseDouble(line);
			}
			if(lineNumber%8!=7){// Ignore every 7th line which is comment
				beta.write(line);
			}
			beta.newLine();
		}
		if(totalConsul>=999){//In the event of a large number of consultations, write 999
			beta.write("999");
		}
		else{
			beta.write(totalConsul);//Otherwise write normal
		}
		beta.newLine();
		if(totalFee>=99999.99){//In the event of large fee, write 99999.99 else normal
			beta.write("99999.99");
		}
		else{
			beta.write(Double.toString(totalFee));
		}
		alpha.close();//close files
		beta.close();
	}
}
