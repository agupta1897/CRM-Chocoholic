package cs200fall2016team9;

import java.io.IOException;

public class sendAutoReports {

	sendAutoReports(){	}
	
	void sendReports() throws IOException{
		MemberReport mem= new MemberReport();
		mem.memberReport();
		ProviderReport pro=new ProviderReport();
		pro.providerReport();
		SummaryReport sum=new SummaryReport();
		sum.summaryReport();
		EFTReport eft= new EFTReport();
		eft.eftReport();
		
		
	}
}
