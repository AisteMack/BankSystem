
package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class main {
   
 
    private final String url = "jdbc:postgresql://localhost:5432/DB";
    private final String user = "postgres";
    private final String password = "***";
 
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
   
    /**
     * @param args the command line arguments
     * */
    
         
    public static void main(String[] args) {

        
            main app = new main();
            Connection conn = app.connect();

        try {
            Bankas bank = new Bankas("DNB", "Adresas, Vilnius", conn);
            System.out.println(bank.toString());
            bank.bankasSuGui();
            
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    

    
}
