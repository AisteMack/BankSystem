
package bank;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class TransakcijaThread extends Thread{
    private String gavejoSasNr;
    private String siuntejoSasNr;
    private double suma;
    private String name;
    private Bankas bank;

    public TransakcijaThread(Bankas bank, String gavejoSasNr, String siuntejoSasNr, double suma, String name) {
        this.gavejoSasNr = gavejoSasNr;
        this.siuntejoSasNr = siuntejoSasNr;
        this.suma = suma;
        this.name = name;
        this.bank = bank;
    }
    
    public void run()
   {
       while(true){
            try { 
                
                bank.pavedimasSQL(gavejoSasNr, siuntejoSasNr, suma);
                System.out.println("Atlikom pavedima ");
                break;

             }
            catch (SaskaitaException | SQLException ex) {
                  Logger.getLogger(TransakcijaThread.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Nepavyko pervedimas " + this.name);
    
             }   
                
             try{
                    
                  sleep(1 *   // minutes to sleep
                            30 *   // seconds to a minute
                            1000);
                }
                catch (InterruptedException ex1) {
                    System.out.println("Gavau interrupted " + this.name);
                 
                }
      }
   }
}
