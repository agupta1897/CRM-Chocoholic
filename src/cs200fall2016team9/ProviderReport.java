package cs200fall2016team9;

import java.io.*;

public class ProviderReport {
	
	ProviderReport(){
	}
	
	void providerReport(String file){
		//add information
	}

	void providerReport(int numberID){
		
		File file=new File("/providerReports/"+numberID+"Report.txt");
		boolean exists = file.exists();
		BufferedWriter fstream;
		fstream = new BufferedWriter(new FileWriter("/providerReports/"+numberID+"Report.txt",true));
		if(!exists){
			ProviderDatabase db1;
			db1 = new ProviderDatabase();			
			db1.lookUpProvider(numberID);
			fstream.newLine();
			fstream.write(db1.spacer.getName());
			fstream.newLine();
			fstream.write(db1.spacer.getNumber().toString());
			fstream.newLine();
			fstream.write(db1.spacer.getAddress());
			fstream.newLine();
			fstream.write(db1.spacer.getCity());
			fstream.newLine();
			fstream.write(db1.spacer.getState());
			fstream.newLine();
			fstream.write(db1.spacer.getZIP().toString());
		}
		VisitDatabase db2;
		db2 = new VisitDatabase();
		db2.lookUpVisit(numberID);
		fstream.newLine();
		fstream.write(db2.visit.getDate());
		fstream.newLine();
		fstream.write(db2.visit.getDateSent());
		fstream.newLine();
		fstream.write(db2.visit.getMemberName());
		fstream.newLine();
		fstream.write(db2.visit.getMemberNumber());
		fstream.newLine();
		fstream.write(db2.visit.getServiceCode());
		fstream.newLine();
		//Create instance of provider directory for service fee
		fstream.write(db2.visit.getFee);
		
		//Develop this better
		//Also, remove spacer
		
	}
}
