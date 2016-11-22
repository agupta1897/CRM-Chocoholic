package cs200fall2016team9;

import java.io.IOException;
/**
 * Send all reports
 * @author Sean
 *
 */
public class sendAutoReports {
	/**
	 * Constructor
	 */
	sendAutoReports(){	}
	/**
	 * Create all reports
	 * @throws IOException
	 */
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
