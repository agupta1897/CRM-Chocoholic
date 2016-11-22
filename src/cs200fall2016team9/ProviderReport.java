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
	ProviderReport(){
		
	}
	/**
	 * Send All Provider Reports
	 * @throws IOException
	 */
	void providerReport() throws IOException{
		BufferedReader Charlie=new BufferedReader(new FileReader("src/files/provider files/allProviders.txt"));
		String line = null;
		while((line=Charlie.readLine())!=null){
			providerReport(Integer.parseInt(line));
		}
		Charlie.close();
	}
	/**
	 * Compile and Save a Single Provider Report
	 * @param numberID
	 * @throws IOException
	 */
	void providerReport(int numberID) throws IOException{
		BufferedReader alpha = new BufferedReader(new FileReader("src/files/provider files/"+numberID+".txt"));
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		//TODO get provider name
		BufferedWriter beta = new BufferedWriter(new FileWriter("src/files/report files/provider reports/"+numberID+date+"Report.txt"));
		String line = new String();
		for(int i=0;i<=5;i++){
			line=alpha.readLine();
			beta.write(line);
			beta.newLine();
		}
		alpha.close();
		alpha = new BufferedReader(new FileReader("src/files/visit files/Provider visit file/"+numberID+"v.txt"));
		double totalFee=0;
		int totalConsul=0;
		int lineNumber=0;
		while((line = alpha.readLine())!= null){
			lineNumber++;
			if(lineNumber%7==6){
				totalConsul++;
				totalFee+=Integer.parseInt(line);
			}
			beta.write(line);
			beta.newLine();
		}
		if(totalConsul>=999){
			beta.write("999");
		}
		else{
			beta.write(totalConsul);
		}
		beta.newLine();
		if(totalFee>=99999.99){
			beta.write("99999.99");
		}
		else{
			beta.write(Double.toString(totalFee));
		}
		alpha.close();
		beta.close();
	}
}
