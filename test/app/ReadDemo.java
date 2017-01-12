package app;

import java.util.List;

/**
 *
 * @author devstackio.net
 */
public class ReadDemo {
    
    private static final String FILENAME = "./sU1484203690812.txt";
    private static final String KEY = "Fr3Cu3nCIe7l2345";
    private static final String INITVECTOR = "Rand0mThR34t5tor";
    
    public static void main(String[] args) {
        
        List<String> lines = Reader.INSTANCE.decryptFile( KEY, INITVECTOR, FILENAME );
        for( String s : lines ) {
            System.out.println(s);
        }
        
    }
    
}
