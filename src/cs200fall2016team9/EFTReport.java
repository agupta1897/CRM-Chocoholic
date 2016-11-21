package cs200fall2016team9;
import java.io.*;
/**
 * 
 * @author Sean Martin
 *
 */

public class EFTReport {

	EFTReport(){
	}
	//all reports
	void eftReport() throws IOException{
		BufferedReader alpha=new BufferedReader(new FileReader("\\files\\provider files\\allProviders.txt"));
		BufferedWriter beta=new BufferedWriter(new FileWriter("\\files\\EFTReports\\eftReport.txt"));
		String line=null;
		while((line = alpha.readLine())!= null){
			BufferedReader charlie=new BufferedReader(new FileReader("\\files\\provider files\\"+line+".txt"));
			String delta;//Read in lines from the providers file
			for(int i=0;i<=1;i++){
				delta = charlie.readLine();
				beta.write(delta);
				beta.newLine();
			}
			charlie.close();
			charlie=new BufferedReader(new FileReader("\\files\\visit files\\provider visit files\\"+line+"v.txt"));
			String line2;
			int totalFee=0;
			int lineCounter=0;
			while((line2=charlie.readLine())!=null){
				lineCounter++;
				if(lineCounter%7==6){
					totalFee+=Integer.parseInt(line2);
				}
			}
			charlie.close();
			beta.write(totalFee);
			beta.newLine();
		}
		alpha.close();
		beta.close();
	}
}
