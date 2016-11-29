package cs200fall2016team9.test;

import static org.junit.Assert.*;

import java.io.File;
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
		File f = new File("src/files/report files/provider reports files/23456789011-29-2016Report.txt");
		assertTrue(f.exists());
	}
}
