package cs200fall2016team9.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs200fall2016team9.ProviderReport;

public class ProviderReportTest {
	
	ProviderReport pr;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testProviderReportIntForSuccess() {
		ProviderReport.providerReport(234567899);
	}

}
