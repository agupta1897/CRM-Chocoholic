package cs200fall2016team9.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs200fall2016team9.ProviderDirectory;
/**
 * This is a JUnit test case of the provider directory function SearchName 
 * @author Sean Martin
 *
 */
public class ProviderDirectorySearchNameTest {

    ProviderDirectory directory;
    
    @Before
    public void setUp() throws Exception {
        directory= new ProviderDirectory();
    }

    @Test
    public void testForSuccess() {
        assertTrue(directory.searchName("Massage"));
    }
    
    @Test	(expected = NullPointerException.class)
    public void testForFailure(){
    	directory.searchName(null);
    }
    
    @Test
    public void testForSanity(){
    	directory.addService("Hero Training", 999999, 50.59);
    	assertEquals("Hero Training",directory.getServiceName(999999));
    	assertEquals(50.59,directory.getServiceFee(999999),0);
    	directory.removeService(999999);
    	assertFalse(directory.searchName("Hero Training"));
    }
}
