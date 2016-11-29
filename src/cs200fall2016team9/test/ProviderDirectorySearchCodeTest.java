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
        assertFalse(pDir.searchCode(122222));
    }
    
    @Test (expected = NumberFormatException.class)
    public void testForException(){
        pDir.searchCode(1234567);
    }
}
