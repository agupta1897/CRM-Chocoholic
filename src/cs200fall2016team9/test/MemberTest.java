package cs200fall2016team9.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs200fall2016team9.Member;

public class MemberTest {
	
	Member m1;
	@Before
	public void setUp() throws Exception {
	}

	
	String m="available";
	@Test
	public void testforSanity() {
		m1.setStatus(m);
	}

}
