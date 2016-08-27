package app;

import java.io.PrintWriter;

public enum Writer {
    
    INSTANCE;
    
    private PrintWriter printWriter;
    private Encrypt encrypt;
    private String key;
    private String initVector;
    private String builder;
    
    Writer() {
        
        try {
            
            System.out.println("initializing Writer...");
            this.builder = "";
            this.printWriter = new PrintWriter( this.getNewFileName(), "UTF-8" );
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
     * concatenates letter to builder for printing on enter
     * @param c 
     */
    public void writeChar( String c ) {
        
        this.builder += c;
        
    }
    /**
     * encryts builder and writes new line to file
     * clears builder
     */
    public void writeNewLine() {
        String eC = Encrypt.INSTANCE.encrypt( this.key, this.initVector, this.builder );
        this.printWriter.println(eC);
        this.builder = "";
    }
    public void destroy() {
        
        System.out.println( "closing writer..." );
        this.printWriter.close();
        
    }
    
}
