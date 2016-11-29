package cs200fall2016team9.test;
/**
 * 
 * This is a JUnit testing file for Class MemberDatabase and Class Member.
 * @author amber
 * 
 * 
 */
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs200fall2016team9.Member;
import cs200fall2016team9.MemberDatabase;

public class MemberDatabaseTest {

	MemberDatabase md= new MemberDatabase();
	Member m= new Member();
	@Before
	public void setUp() {
		
		
	}

	/**
	 * 
	 * @throws IOException throws error
	 */
	@Test
	public void testforSanity() throws IOException {
		md.addEntry("Mike", 123456799, "JFK INTERNATIONAL AIRPORT", "Tuscaloosa", "Alabama", 25415);
		assertEquals("Mike", m.returnName(123456799));
		assertEquals("Alabama", m.returnState(123456799));
		md.removeEntry(123456799);
		assertEquals("Invalid number",m.returnStatus(123456799));
		
	}
	
	/**
	 * 
	 * @throws IOException throws error
	 */
	@Test
	public void testforFailureofremoveEntry()throws IOException{
		md.addEntry("Mike", 123456799, "JFK INTERNATIONAL AIRPORT", "Tuscaloosa", "Alabama", 25415);
		md.removeEntry(125699);
		assertTrue(m.returnStatus(123456799).equals("Validated"));
		
	}
	
	/**
	 * 
	 * @throws IOException throws error
	 */
	@Test
	public void testforSuccess() throws IOException{
		md.addEntry("Mike", 123456799, "JFK INTERNATIONAL AIRPORT", "Tuscaloosa", "Alabama", 25415);
		assertEquals("Validated",m.returnStatus(123456799));
		md.removeEntry(123456799);
		assertEquals("Invalid number",m.returnStatus(123456799));
	}
	
	@After
	public void closeUp() throws IOException {
		md.removeEntry(123456799);
	}
	
}
