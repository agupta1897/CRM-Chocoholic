package cs200fall2016team9.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs200fall2016team9.ProviderDirectory;

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
    
    @Test	(expected=ClassCastException.class)
    public void testForFailure(){
    }
}
