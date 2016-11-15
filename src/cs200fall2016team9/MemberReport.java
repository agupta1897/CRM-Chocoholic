package cs200fall2016team9;

import java.io.*;

/**
 * @author Sean Martin
 */
/*public class MemberReport {

	MemberReport(){
	}
	//alpha beta charlie Ocelot
	void memberReport(String file){
		//add information
	}

	void memberReport(int numberID){
		
		File file=new File("/memberReports/"+numberID+"Report.txt");
		boolean exists = file.exists();
		BufferedWriter fstream;
		fstream = new BufferedWriter(new FileWriter("/memberReports/"+numberID+"Report.txt",true));
		if(!exists){
			MemberDatabase db1;
			db1 = new MemberDatabase();			
			db1.lookUpMember(numberID);
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
		fstream.write(db2.visit.getProviderName());
		fstream.newLine();
		fstream.write(db2.visit.getServiceName());
		
		//Develop this better
		//Also, remove spacer
		
	}
}*/
