package app;

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
public class EncryptTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("[EncryptTest] goblin tests completed.");
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of encrypt method, of class Encrypt.
     */
    @Test
    public void testDefaultEncrypt() {
        Encrypt instance = Encrypt.INSTANCE;
        String key = instance.getKey();
        String initVector = instance.getInitVector();
        String value = "goblin engineers";
        String expResult = "GMHMvEbLICo6XD6nAmonWoYBLtR4f1rNqzmMcD2nCtE=";
        String result = instance.encrypt( key, initVector, value );
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class Encrypt.
     */
    @Test
    public void testDecrypt() {
        Encrypt instance = Encrypt.INSTANCE;
        String key = instance.getKey();
        String initVector = instance.getInitVector();
        String value = "GMHMvEbLICo6XD6nAmonWoYBLtR4f1rNqzmMcD2nCtE=";
        String expResult = "goblin engineers";
        String result = instance.decrypt( key, initVector, value );
        assertEquals(expResult, result);
    }
    
}
