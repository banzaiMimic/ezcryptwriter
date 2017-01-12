package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author devstackio.net
 */
public enum Reader {
    
    INSTANCE;
    
    public List<String> readFile( String filepath ) {
        
        List<String> returnobj = new LinkedList();
        
        try (Stream<String> stream = Files.lines( Paths.get( filepath ) )) {

            returnobj = stream
                    .collect( Collectors.toList() );

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return returnobj;
    }
    
    public List<String> decryptFile( String key, String initVector, String filepath ) {
        
        List<String> returnobj = new LinkedList();
        List<String> eLines = this.readFile( filepath );
        
        eLines.stream().map((s) -> Encrypt.INSTANCE.decrypt( key, initVector, s )).forEach((dLine) -> {
            returnobj.add( dLine );
        });
        
        return returnobj;
        
    }
    
}
