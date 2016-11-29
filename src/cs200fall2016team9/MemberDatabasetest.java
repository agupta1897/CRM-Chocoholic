package cs200fall2016team9;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class MemberDatabasetest {

	MemberDatabase md= new MemberDatabase();
	Member m= new Member();
	@Before
	public void setUp() {
		
		
	}

	@Test
	public void testforSanity() throws IOException {
		md.addEntry("Mike", 123456799, "JFK INTERNATIONAL AIRPORT", "Tuscaloosa", "Alabama", 25415);
		assertEquals("Mike", m.returnName(123456799));
		assertEquals("Alabama", m.returnState(123456799));
		md.removeEntry(123456799);
		assertEquals("Invalid number",m.returnStatus(123456799));
		
	}
	
	@Test
	public void testforFailureofremoveEntry()throws IOException{
		md.addEntry("Mike", 123456799, "JFK INTERNATIONAL AIRPORT", "Tuscaloosa", "Alabama", 25415);
		md.removeEntry(125699);
		assertTrue(m.returnStatus(123456799).equals("Validated"));
		
	}
	
	@Test
	public void testforSuccess() throws IOException{
		md.addEntry("Mike", 123456799, "JFK INTERNATIONAL AIRPORT", "Tuscaloosa", "Alabama", 25415);
		assertEquals("Validated",m.returnStatus(123456799));
		md.removeEntry(123456799);
		assertEquals("Invalid number",m.returnStatus(123456799));
	}
	
	
}
