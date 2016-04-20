package app;

import java.io.PrintWriter;

public enum Writer {
    
    INSTANCE;
    
    private PrintWriter console;
    private Encrypt encrypt;
    private String key;
    private String initVector;
    
    Writer() {
        
        try {
            
            System.out.println("initializing Writer...");
            this.console = new PrintWriter( this.getNewFileName(), "UTF-8" );
            this.encrypt = Encrypt.INSTANCE;
            this.key = this.encrypt.getKey();
            this.initVector = this.encrypt.getInitVector();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * returns "sU" with sys.curtimemilis...
     * @return 
     */
    private String getNewFileName() {
        return "sU" + String.valueOf( System.currentTimeMillis() + ".txt" );
    }
    /**
     * encrypts, then writes single char to open file
     * @param c 
     */
    public void writeChar( String c ) {
        
        String eC = Encrypt.INSTANCE.encrypt( this.key, this.initVector, c );
        this.console.print( eC );
        
    }
    public void writeNewLine() {
        this.console.println("");
    }
    public void destroy() {
        
        System.out.println( "closing writer..." );
        this.console.close();
        
    }
    
}
