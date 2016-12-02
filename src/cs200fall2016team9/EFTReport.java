package cs200fall2016team9;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * 
 * @author Sean Martin
 * Produces EFTReport and saves it to a location
 */

public class EFTReport {
	/**
	 * Constructor
	 */
	EFTReport(){ //Constructs
	}
	/**
	 * compiles eftReport and saves it to a file location in a folder
	 * @throws IOException
	 */
	void eftReport() throws IOException{
		File a = new File("src/files/provider files/allProviders.txt");
		String s = "files/provider files/allProviders.txt";
		if(a.exists()){
			s="src/"+s;
		}
		BufferedReader alpha=new BufferedReader(new FileReader(s)); //Looks up provider file
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime()); //gets the date
		a = new File("src/files/provider files/allProviders.txt");
		s = "files/report files/eft report files/eftReport";
		if(a.exists()){
			s="src/"+s;
		}
		BufferedWriter beta=new BufferedWriter(new FileWriter(s+date+".txt")); //creates/overwrites eft report file
		String line=null;	//String variable is null;
		while((line = alpha.readLine())!= null){ // line gets strings from the BufferedReader alpha and the loop checks to make sure the file isn't ended
			a = new File("src/files/provider files/allProviders.txt");
			s = "files/provider files/";
			if(a.exists()){
				s="src/"+s;
			}
			a= new File(s+line+".txt");
			if(a.exists()){
				BufferedReader charlie=new BufferedReader(new FileReader(s+line+".txt")); //Open provider file
				String delta;//Read in lines from the providers file
				for(int i=0;i<=1;i++){  //a loop to copy the provider name and number
					delta = charlie.readLine();
					beta.write(delta);
					beta.newLine();
				}
				charlie.close(); //close provider file
				a = new File("src/files/provider files/allProviders.txt");
				s = "files/visit files/provider visit files/";
				if(a.exists()){
					s="src/"+s;
				}
				a = new File(s+line+"v.txt");
				Double totalFee=0.0;
				if(a.exists()){
					charlie=new BufferedReader(new FileReader(s+line+"v.txt")); //Open provider visit file
					String line2; // creates a new string variable
					int lineCounter=0; //While loop to copy fee data from the visit file
					while((line2=charlie.readLine())!=null){
						lineCounter++;//add to line counter to find the lines with fee information
						if(lineCounter%8==6){
							totalFee+=Double.parseDouble(line2);
						}
					}
				}
					charlie.close(); // close the visit file and then write the total fee
					beta.write(Double.toString(totalFee));
					beta.newLine();
			}
		}
		alpha.close();//close the all provider file
		beta.close();//close the eft report file
	}
}
