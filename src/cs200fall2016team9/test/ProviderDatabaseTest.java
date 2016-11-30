package cs200fall2016team9.test;
/**
 * 
 * This is a JUnit testing file for Class ProviderDatabase and Class Provider.
 * @author amber
 * 
 * 
 */
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs200fall2016team9.Provider;
import cs200fall2016team9.ProviderDatabase;

public class ProviderDatabaseTest {

	ProviderDatabase pd = new ProviderDatabase();
	Provider p = new Provider();
	
	/**
	 * 
	 * @throws Exception throws error
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * 
	 * @throws IOException throws error
	 */
	@Test
	public void testforSanity() throws IOException {
		pd.addEntry("Mike", 123456799, "JFK INTERNATIONAL AIRPORT", "Tuscaloosa", "Alabama", 25415);
		assertEquals("Mike", p.returnName(123456799));
		assertEquals("Alabama", p.returnState(123456799));
		pd.removeEntry(123456799);
		assertEquals("Invalid number",p.returnState(123456799));
	}
	
	
	/**
	 * 
	 * @throws IOException throws error
	 */
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
	
	@After
	public void closeUp() throws IOException {
		pd.removeEntry(123456799);
	}
	
	
	}
