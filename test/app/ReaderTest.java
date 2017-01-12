package app;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author devstackio.net
 */
public class ReaderTest {
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("[ReaderTest] goblin tests completed.");
    }
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of readFile method, of class Reader.
     */
    @Test
    public void testReadFile() {
        
        List<String> lines = Reader.INSTANCE.readFile( "./demo.txt" );
        
        assertEquals( "first line read correctly","GMHMvEbLICo6XD6nAmonWoYBLtR4f1rNqzmMcD2nCtE=", lines.get(0) );
        assertEquals( "second line read correctly","IqEFOM9CEY1N+5kfRhO5mw==", lines.get(1) );

    }
    
    /**
     * Test of readFile method, of class Reader.
     */
    @Test
    public void testDecryptFile() {
        
        List<String> lines = Reader.INSTANCE.decryptFile( "Fr3Cu3nCIe7l2345","Rand0mThR34t5tor", "./demo.txt" );
        String exp0 = "goblin engineers";
        String exp1 = "another test";
        
        assertEquals( "first line decrypted correctly", exp0, lines.get(0) );
        assertEquals( "second line decrypted correctly", exp1, lines.get(1) );

    }
    
}
