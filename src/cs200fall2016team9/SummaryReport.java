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
		while((list = provider.readLine())!=null){
			File file = new File("\\files\\visit files\\provider visit files\\"+list+"v.txt");
			if(file.exists()){
				BufferedReader proFile = new BufferedReader(new FileReader("\\files\\provider files\\"+list+".txt"));					
				fstream.write(proFile.readLine());
				fstream.newLine();
				proFile.close();
				proFile = new BufferedReader(new FileReader("\\files\\visit files\\provider visit files\\"+list+".vtxt"));
				
				
			}
			
			
					
		}
	}
}
