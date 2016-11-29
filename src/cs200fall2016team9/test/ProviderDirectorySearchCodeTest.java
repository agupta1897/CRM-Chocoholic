package cs200fall2016team9.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs200fall2016team9.ProviderDirectory;

public class ProviderDirectorySearchCodeTest {

    ProviderDirectory pDir;
    
    @Before
    public void setUp() throws Exception {
        pDir = new ProviderDirectory();
    }

    @Test
    public void testForSuccess() {
        assertTrue(pDir.searchCode(123456));
        assertFalse(pDir.searchCode(000000));
    }
    
    @Test (expected = NumberFormatException.class)
    public void testForException(){
        pDir.searchCode(1234567);
    }
    
    @Test
    public void testForSanity() {
        pDir.addService("Tomahawk Throwing", 999999, 100);
        assertEquals("Tomahawk Throwing", pDir.getServiceName(999999));
        assertEquals(100, pDir.getServiceFee(999999), 0);
        assertTrue(pDir.searchCode(999999));
        pDir.removeService(999999);
        assertFalse(pDir.searchCode(999999));
    }
}
