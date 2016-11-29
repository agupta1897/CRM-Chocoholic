package cs200fall2016team9.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import cs200fall2016team9.ProviderReport;

public class ProviderReportTest {
	
	ProviderReport pr;

	@Before
	public void setUp() throws Exception {
		pr = new ProviderReport();
	}

	@Test
	public void testProviderReportIntForSuccess() {
		try {
			pr.providerReport(234567890);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		File f = new File("src/files/report files/provider report files/234567890"+date+"Report.txt");
		assertTrue(f.exists());
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testProviderReportIntForFailureWithBadID() throws IOException{
		try {
			pr.providerReport(234567899);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		File f = new File("src/files/report files/provider report files/234567899"+date+"Report.txt");
		assertFalse(f.exists());
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testProviderReportIntForFailureWithGarbage() throws IOException{
		try {
			pr.providerReport(555555555);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		File f = new File("src/files/report files/provider report files/555555555"+date+"Report.txt");
		assertFalse(f.exists());
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testProviderReportIntForFailureWithHugeNum() throws IOException{
		try {
			pr.providerReport(1234567890*75737);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		String date= new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		File f = new File("src/files/report files/provider report files/555555555"+date+"Report.txt");
		assertFalse(f.exists());
	}
}
