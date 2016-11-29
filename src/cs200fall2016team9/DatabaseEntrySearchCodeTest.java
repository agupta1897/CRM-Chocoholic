package cs200fall2016team9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DatabaseEntrySearchCodeTest {

	
	Member M;
	@Before
	public void setUp() throws Exception {
		M = new Member();
	}

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		assertTrue(M.searchCode("Member",123456780));
	}
	 @SuppressWarnings("static-access")
	@Test
	    public void testForFailure(){
	        assertFalse(M.searchCode("Member",123456799));
	    }
}
