package cs200fall2016team9.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import cs200fall2016team9.MemberReport;

/**
 * JUnit test for Member Report.
 * @author Nate Wade
 *
 */

public class MemberReportTest {
	
	MemberReport mr;

	@Before
	public void setUp() throws Exception {
		mr = new MemberReport();
	}

	@Test
	public void testMemberReportIntForSuccess() {
		try {
			mr.memberReport(123456789);	//Call Member Report with valid Member with visit info
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		File f = new File("src/files/report files/member report files/123456789"+date+"Report.txt");
		assertTrue(f.exists());	//File should exist
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testMemberReportIntForFailureWithBadID() throws IOException{
		try {
			mr.memberReport(123456799);	//Call Member Report with valid Member with no visit data
		} catch (FileNotFoundException e) {		//Should have no visit file
			// TODO Auto-generated catch block
			throw e;
		}
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		File f = new File("src/files/report files/Member report files/12345699"+date+"Report.txt");
		assertFalse(f.exists());	//Should never make report file
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testMemberReportIntForFailureWithGarbage() throws IOException{
		try {
			mr.memberReport(555555555);	//Call Member Report with invalid Member 
		} catch (FileNotFoundException e) {		//Should have no Member file to reference
			// TODO Auto-generated catch block
			throw e;
		}
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		File f = new File("src/files/report files/Member report files/555555555"+date+"Report.txt");
		assertFalse(f.exists());	//Should never make report file
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testMemberReportIntForFailureWithHugeNum() throws IOException{
		try {
			mr.memberReport(1234567890*75737);	//Call Member report with large number as ID
		} catch (FileNotFoundException e) {		//Should have no Member id to reference
			// TODO Auto-generated catch block
			throw e;
		}
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		File f = new File("src/files/report files/Member report files/555555555"+date+"Report.txt");
		assertFalse(f.exists());	//Should never make report file
	}
}
