package cs200fall2016team9.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import cs200fall2016team9.Provider;
import cs200fall2016team9.ProviderDatabase;

public class ProviderDatabaseTest {

	ProviderDatabase pd = new ProviderDatabase();
	Provider p = new Provider();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testforSanity() throws IOException {
		pd.addEntry("Mike", 123456799, "JFK INTERNATIONAL AIRPORT", "Tuscaloosa", "Alabama", 25415);
		assertEquals("Mike", p.returnName(123456799));
		assertEquals("Alabama", p.returnState(123456799));
		pd.removeEntry(123456799);
		assertEquals("Invalid number",p.returnState(123456799));
	}
	
	
	@Test
	public void testforSuccessOfaddEntry()throws IOException{
		pd.addEntry("Mike", 123456799, "JFK INTERNATIONAL AIRPORT", "Tuscaloosa", "Alabama", 25415);
		assertEquals("Mike", p.returnName(123456799));
	}
	
	@Test
	public void testforFailureOfremoveEntry()throws IOException{
		pd.addEntry("Mike", 123456799, "JFK INTERNATIONAL AIRPORT", "Tuscaloosa", "Alabama", 25415);
		pd.removeEntry(1234599);
		assertFalse(p.returnName(123456799).equals("Invalid number"));
	}
	
	//@Test
	
	
	}
