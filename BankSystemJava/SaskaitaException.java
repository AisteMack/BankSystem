
package bank;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class SaskaitaException extends Exception {

    private double balansas;
    private String msg;

    public double getBalansas() {
        return balansas;
    }
    
    public SaskaitaException() {
    }

    public SaskaitaException(String msg) {
        super(msg);
        this.msg = msg;
    }
    
    public SaskaitaException(String msg, double balansas){
        super(msg);
        this.balansas = balansas;
        this.msg = msg;
        
    }
    
    @Override
    public String toString(){
        return msg;
    }
    
}
