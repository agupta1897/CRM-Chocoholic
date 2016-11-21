package cs200fall2016team9;
import java.io.*;
/**
 * 
 * @author Sean Martin
 *
 */

public class SummaryReport {
	
	SummaryReport(){}
	
	void summaryReport() throws IOException{
		BufferedReader provider = new BufferedReader(new FileReader("\\files\\provider files\\allProviders.txt"));
		BufferedWriter fstream = new BufferedWriter( new FileWriter("\\files\\SummaryReports\\summary.txt"));
		String list=null;
		int totalProviders=0;
		int totalConsul=0;
		double overAllFee=0;
		while((list = provider.readLine())!=null){
			File file = new File("\\files\\visit files\\provider visit files\\"+list+"v.txt");
			if(file.exists()){
				totalProviders++;
				BufferedReader proFile = new BufferedReader(new FileReader("\\files\\provider files\\"+list+".txt"));					
				fstream.write(proFile.readLine());//Writes in provider name
				fstream.newLine();
				proFile.close();
				proFile = new BufferedReader(new FileReader("\\files\\visit files\\provider visit files\\"+list+".vtxt"));
				String line=null;
				int lineNumber=0;
				int proFee=0;
				int proConsul=0;
				while((line=proFile.readLine())!=null){
					lineNumber++;
					if(lineNumber%7==6){
						proFee+=Integer.parseInt(line);
						proConsul++;
					}
				}
				fstream.write(proConsul);
				fstream.newLine();
				fstream.write(Double.toString(proFee));
				fstream.newLine();
				totalConsul+=proConsul;
				overAllFee+=proFee;
				proFile.close();
			}		
		}
		provider.close();
		fstream.write(totalProviders);
		fstream.newLine();
		fstream.write(totalConsul);
		fstream.newLine();
		fstream.write(Double.toString(overAllFee));
		fstream.close();
	}
}
