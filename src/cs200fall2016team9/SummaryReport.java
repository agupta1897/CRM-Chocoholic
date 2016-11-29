package cs200fall2016team9;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Create the Summary Report
 * @author Sean Martin
 *
 */

public class SummaryReport {
	/**
	 * Constructor
	 */
	SummaryReport(){}
	/**
	 * generate summary report
	 * @throws IOException
	 */
	void summaryReport() throws IOException{
		File a = new File("src/files/provider files/allProviders.txt");
		String s = "files/provider files/allProviders.txt";
		if(a.exists()){
			s="src/"+s;
		}
		BufferedReader provider = new BufferedReader(new FileReader(s)); //Open All providers
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());//gets the current date
		a = new File("src/files/provider files/allProviders.txt");
		s="files/report files/summary report files/summary";
		if(a.exists()){
			s="src/"+s;
		}
		BufferedWriter fstream = new BufferedWriter( new FileWriter(s+date+".txt")); //opens a summary report
		String list=null; //create variables
		int totalProviders=0;
		int totalConsul=0;
		double overAllFee=0;
		while((list = provider.readLine())!=null){ //Incrementally go through each line of the file
			a = new File("src/files/provider files/allProviders.txt");
			s="files/visit file/provider visit files/";
			if(a.exists()){
				s="src/"+s;
			}
			File file = new File(s+list+"v.txt");//check to see if the provider is listed in visit
			if(file.exists()){// under the assumption the file exists
				totalProviders++; //add number to total providers
				a = new File("src/files/provider files/allProviders.txt");
				s="files/provider files/";
				if(a.exists()){
					s="src/"+s;
				}
				BufferedReader proFile = new BufferedReader(new FileReader(s+list+".txt"));			// open the providers file		
				fstream.write(proFile.readLine());//Writes in provider name
				fstream.newLine();//goes to next line
				proFile.close();//close provider file
				a = new File("src/files/provider files/allProviders.txt");
				s="files/visit files/provider visit files/";
				if(a.exists()){
					s="src/"+s;
				}
				proFile = new BufferedReader(new FileReader(s+list+"v.txt"));
				String line=null;// open provider visit file
				int lineNumber=0;
				double proFee=0;
				int proConsul=0;//go through each line of the visit file
				while((line=proFile.readLine())!=null){
					lineNumber++;
					if(lineNumber%8==6){//every 6th line out of 8 is the fee line
						proFee+=Double.parseDouble(line);
						proConsul++;//add a number to the providers consultation
					}
				}
				fstream.write(proConsul);//Write in number of consultations
				fstream.newLine();
				fstream.write(Double.toString(proFee));//Write in fee
				fstream.newLine();
				totalConsul+=proConsul;// Add to total consultations
				overAllFee+=proFee;//Add to total Fee
				proFile.close();//Close provider visit file
			}		
		}
		provider.close();// close provider directory
		fstream.write(totalProviders);// Write in total providers and total consultations and overall Fee
		fstream.newLine();
		fstream.write(totalConsul);
		fstream.newLine();
		fstream.write(Double.toString(overAllFee));
		fstream.close();
	}
}
