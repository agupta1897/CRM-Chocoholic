package cs200fall2016team9.test;

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
        pDir.searchCode(123456);
    }
    
    @Test
    public void testForFailure(){
        pDir.searchCode(1234567);
    }
}
