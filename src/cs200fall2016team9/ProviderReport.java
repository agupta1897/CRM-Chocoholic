package cs200fall2016team9;

import java.io.*;

/**
 * @author Sean Martin
 */
public class ProviderReport {

	ProviderReport(){
		
	}
	//send group
	void providerReport() throws IOException{
		BufferedReader Charlie=new BufferedReader(new FileReader("\\files\\Provider files\\allProviders.txt"));
		String line = null;
		while((line=Charlie.readLine())!=null){
			providerReport(Integer.parseInt(line));
		}
		Charlie.close();
	}
	//Send individual
	void providerReport(int numberID) throws IOException{
		BufferedReader alpha = new BufferedReader(new FileReader("\\files\\Provider files\\"+numberID+".txt"));
		BufferedWriter beta = new BufferedWriter(new FileWriter("\\files\\Provider reports\\"+numberID+"Report.txt"));
		String line = new String();
		for(int i=0;i<=5;i++){
			line=alpha.readLine();
			beta.write(line);
			beta.newLine();
		}
		alpha.close();
		alpha = new BufferedReader(new FileReader("\\files\\visit files\\Provider visit files\\"+numberID+"v.txt"));
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
