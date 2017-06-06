
package bank;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class Bankas {
    private String pavadinimas;
    private String adresas;
    private int nr;
    private Connection db;
    private ZmogusKlientas vartotojas;
    public enum sasTipas {
        Debetine, Taupomoji, Kreditine
    }
    public Bankas(String pavadinimas, String adresas, Connection conn) throws SQLException {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO aima3213.bankas"
                    + "(\"pavadinimas\",\"adresas\") values (?, ?)");
            st.setString(1, pavadinimas);
            st.setString(2, adresas);
            st.executeUpdate();
            st.close();

        } catch (SQLException ex) {
            
            if(ex.getMessage().contains("duplicate key value violates unique constraint \"raktaspavadinimo\"")){
              //System.out.println("Pagavau!!"); 
            }else{
                throw ex;
            }
        }
        
            this.pavadinimas = pavadinimas;
            this.adresas = adresas;
            this.db = conn;
            PreparedStatement stmt = conn.prepareStatement("SELECT nr FROM aima3213.bankas "
                    + "WHERE pavadinimas = ? AND adresas = ?");
            stmt.setString(1, this.pavadinimas);
            stmt.setString(2, this.adresas);
            ResultSet rs = stmt.executeQuery();
                rs.next();
                this.nr = rs.getInt(1);
            if(rs.next()){
                throw new SQLException("Rasta daugiau nei vienas bankas!!");
            }
                    
        
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public String getAdresas() {
        return adresas;
    }

    public int getNr() {
        return nr;
    }
    


    private void pervestiPinigus(String sasNr, ZmogusKlientas klientas, double suma){
        Saskaita sas = klientas.getSaskaita(sasNr);
        sas.ideti(suma);
    }   
    private void paimtPinigus(String sasNr, ZmogusKlientas klientas, double suma) throws SaskaitaException{
        Saskaita sas = klientas.getSaskaita(sasNr);
        sas.paimti(suma);
    } 


    public void pavedimasSQL(String gavejoSasNr, String sasNr, double suma) throws SaskaitaException, SQLException{
        try{
            this.db.setAutoCommit(false);
            
            PreparedStatement stt = this.db.prepareStatement("" +
                   "INSERT INTO aima3213.transakcija"
                    + "(\"suma\",\"gavejosasnr\",\"siuntejosasnr\")"
                   + " values (?, ?, ?)");
            stt.setDouble(1, suma);
            stt.setString(2, gavejoSasNr);
            stt.setString(3, sasNr);
            stt.executeUpdate();
            
            PreparedStatement st = this.db.prepareStatement("" +
                   "UPDATE aima3213.Saskaita SET pinigulikutis = ? WHERE nr = ?");
            if(gavejoSasNr != null){
                double gavejoLikutis = this.getSaskaitosLikutiSQL(gavejoSasNr).doubleValue();
                System.out.println(gavejoSasNr + " Likutis gavejo " + gavejoLikutis); 
                st.setDouble(1, gavejoLikutis + suma);
                st.setString(2, gavejoSasNr);
                st.executeUpdate();
            }
            if(sasNr != null){
                double siuntejoLikutis = this.getSaskaitosLikutiSQL(sasNr).doubleValue();
                System.out.println(sasNr + " Likutis siuntejo " + siuntejoLikutis);
                st.setDouble(1, siuntejoLikutis - suma);
                st.setString(2, sasNr);
                st.executeUpdate();
            }

            this.db.commit();
            this.db.setAutoCommit(true);
            
        }catch(SQLException ex){
          //  Logger.getLogger(GUInaujaSaskaita.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Transakcija neivyko. ");
            System.err.println("Error: " + ex.getMessage());
            this.db.rollback();
            this.db.setAutoCommit(true);
            throw new SQLException("Transakcija neivyko! ");
        }
        
           
            if(sasNr != null && vartotojas.getSaskaita(sasNr) != null){
                paimtPinigus(sasNr, vartotojas, suma);
            }
            if(gavejoSasNr != null && vartotojas.getSaskaita(gavejoSasNr) != null){
                pervestiPinigus(gavejoSasNr, vartotojas, suma);
            }

    }
   
   
   public void pridetiKlientaSQL(String vardas, String pavarde, String asmensKodas, String telNr, String elPastas,
                                    String prisijungimoVardas, String slaptazodis) throws SQLException{
       
        if(!yraZmogus(asmensKodas)){
            if(elPastas.length()!= 0){
                System.out.println(elPastas.length());
                PreparedStatement st = this.db.prepareStatement(""
                        + "INSERT INTO aima3213.Zmogus "
                        + "values (?, ?, ?, ?, ?)");
                st.setString(1, asmensKodas);
                st.setString(2, vardas);
                st.setString(3, pavarde);
                st.setString(4, telNr);
                st.setString(5, elPastas);
                st.executeUpdate();
                st.close(); 
            }else{
                PreparedStatement st = this.db.prepareStatement(""
                        + "INSERT INTO aima3213.Zmogus "
                        + "values (?, ?, ?, ?)");
                st.setString(1, asmensKodas);
                st.setString(2, vardas);
                st.setString(3, pavarde);
                st.setString(4, telNr);
                st.executeUpdate();
                st.close(); 
            }
        }

        PreparedStatement st = this.db.prepareStatement(""
                   + "INSERT INTO aima3213.prisijungimoDuomenys"
                   + "(\"prisijungimovardas\",\"slaptazodis\",\"zmogus\",\"bankas\") "
                   + "values (?, ?, ?, ?)");
        st.setString(1, prisijungimoVardas);
        st.setString(2, slaptazodis);
        st.setString(3, asmensKodas);
        st.setInt(4, this.nr);
        st.executeUpdate();
        st.close(); 
       
       
   }
   
   public void pasalintiKlientaSQL(String ak) throws SQLException{
 
            PreparedStatement st = this.db.prepareStatement("" +
                   "DELETE FROM aima3213.PrisijungimoDuomenys WHERE zmogus = ? AND bankas = ?");
            st.setString(1, ak);
            st.setInt(2, this.nr);
            st.executeUpdate();
            st.close(); 
   }
   
   public void atnaujintiKlientoInfoSQL(String kaAtnaujinti, String info) throws SQLException{
       
       PreparedStatement st = null;
       switch(kaAtnaujinti){
           case("vardas") :
               st = this.db.prepareStatement("" +
                   "UPDATE aima3213.Zmogus SET vardas = ? WHERE ak = ?");
               break;
           case("pavarde") :
               st = this.db.prepareStatement("" +
                   "UPDATE aima3213.Zmogus SET pavarde = ? WHERE ak = ?");
               break;
           case("elpastas") :
               st = this.db.prepareStatement("" +
                   "UPDATE aima3213.Zmogus SET elpastas = ? WHERE ak = ?");
               break;
           case("telnumeris") :
               st = this.db.prepareStatement("" +
                   "UPDATE aima3213.Zmogus SET telnumeris = ? WHERE ak = ?");
               break;
       }

        st.setString(2, this.vartotojas.getAsmensKodas());
        st.setString(1, info);
        st.executeUpdate();
        st.close(); 
       
   }
   public void atnaujintiKlientoSlapSQL(String senas, String naujas) throws SQLException{
       
       PreparedStatement st = null;
               st = this.db.prepareStatement("" +
                   "UPDATE aima3213.prisijungimoduomenys SET slaptazodis = ? "
                       + "WHERE slaptazodis = ? AND bankas = ? AND zmogus = ?");


        st.setString(4, this.vartotojas.getAsmensKodas());
        st.setString(1, naujas);
        st.setString(2, senas);
        st.setInt(3, this.nr);
        st.executeUpdate();
        st.close(); 
       
   }
   
    public void pasalintiSaskaitaSQL(String ak, String sasNr) throws SQLException{
 
            PreparedStatement st = this.db.prepareStatement("" +
                   "DELETE FROM aima3213.saskaita WHERE savininkas = ? AND bankas = ? AND nr = ?");
            st.setString(1, ak);
            st.setInt(2, this.nr);
            st.setString(3, sasNr);
            st.executeUpdate();
            st.close(); 
   }
    
    public BigDecimal getSaskaitosLikutiSQL(String sasNr) throws SQLException{
        PreparedStatement stmt = this.db.prepareStatement("SELECT pinigulikutis FROM aima3213.saskaita "
                    + "WHERE nr = ?");
            stmt.setString(1, sasNr);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
          //  System.out.println());
            java.math.BigDecimal nn = rs.getBigDecimal(1);
            return nn;
            }
        return null;
    }
      
   public void sukurtiSaskaitaSQL(String sasNr, String tipas, double likutis, double kreditas) throws SQLException{
       PreparedStatement st = this.db.prepareStatement(""
                   + "INSERT INTO aima3213.saskaita "
                   + "values (?, ?, ?, ?, ?, ?)");
        st.setString(1, sasNr);
        st.setString(2, tipas);
        st.setInt(3, this.nr);
        st.setString(4, this.vartotojas.getAsmensKodas());
        st.setDouble(5, likutis);
        st.setDouble(6, kreditas);
        st.executeUpdate();
        st.close();
        
        vartotojas.setSaskaitasIsSQL(this.db);
        return;
       
   }
   private Boolean yraZmogus(String ak) throws SQLException{
        PreparedStatement stmt = this.db.prepareStatement("SELECT COUNT(*) FROM aima3213.zmogus "
                    + "WHERE ak = ?");
            stmt.setString(1, ak);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        return rs.getInt(1) != 0;
       
       
   }
 

   public void bankasSuGui(){
       GUIprisijungimas form = new GUIprisijungimas(this);
       form.setVisible(true);
   }
   
   public Boolean rastiKlientaSQL(String prisijungimas, String slaptazodis) throws SQLException{
       PreparedStatement stmt = this.db.prepareStatement("SELECT COUNT(*) FROM aima3213.prisijungimoduomenys "
                    + "WHERE prisijungimovardas = ? AND slaptazodis = ? AND bankas = ?");
            stmt.setString(1, prisijungimas);
            stmt.setString(2, slaptazodis);
            stmt.setInt(3, this.nr);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        return rs.getInt(1) != 0;
       
   }
   
    public ZmogusKlientas getKlientaSQL(String prisijungimas, String slaptazodis) throws SQLException{
       PreparedStatement stmt = this.db.prepareStatement("SELECT zmogus FROM aima3213.prisijungimoduomenys "
                    + "WHERE prisijungimovardas = ? AND slaptazodis = ? AND bankas = ?");
        stmt.setString(1, prisijungimas);
        stmt.setString(2, slaptazodis);
        stmt.setInt(3, this.nr);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        String ak = rs.getString(1);
        stmt = this.db.prepareStatement("SELECT * FROM aima3213.zmogus "
                    + "WHERE ak = ?");
        stmt.setString(1, ak);
        rs = stmt.executeQuery();
        rs.next();
        if(rs.getString(1) != null){
            
            if(rs.getString(5) != null){
                this.vartotojas = new ZmogusKlientas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), prisijungimas);
            }else{
                this.vartotojas = new ZmogusKlientas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), prisijungimas);
            }
            vartotojas.setSaskaitasIsSQL(this.db);
            return this.vartotojas;
                
        }else{
            return null;
        }
   }

    public ZmogusKlientas getVartotojas() {
        return vartotojas;
    }
    
    public List getAkKlientu() throws SQLException{
        PreparedStatement stmt = this.db.prepareStatement("SELECT zmogus FROM aima3213.prisijungimoDuomenys "
                    + "WHERE bankas = ?");
        stmt.setInt(1, this.nr);
        List <String> sarasas = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            
            sarasas.add(rs.getString(1));
        }
        
        return sarasas;
    }
    
    public List getSasNrKliento(String ak) throws SQLException{
        PreparedStatement stmt = this.db.prepareStatement("SELECT nr FROM aima3213.saskaita "
                    + "WHERE bankas = ? AND savininkas = ?");
        stmt.setInt(1, this.nr);
        stmt.setString(2, ak);
        List <String> sarasas = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            
            sarasas.add(rs.getString(1));
        }
        
        return sarasas;
    }
    

    public String getVardasSQL(String ak) throws SQLException{
        PreparedStatement stmt = this.db.prepareStatement("SELECT vardas FROM aima3213.zmogus "
                    + "WHERE ak = ?");
         stmt.setString(1, ak);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getString(1);   
    }
    public String getPavardeSQL(String ak) throws SQLException{
        PreparedStatement stmt = this.db.prepareStatement("SELECT pavarde FROM aima3213.zmogus "
                    + "WHERE ak = ?");
         stmt.setString(1, ak);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getString(1);   
    }
   
    public List getVisasSaskaitas() throws SQLException{
        List <String> sarasas = new ArrayList<>();
        
        PreparedStatement stmt = this.db.prepareStatement("SELECT A.nr, B.Vardas, B.Pavarde "
                + "FROM aima3213.zmogus as B, aima3213.saskaita as A "
                    + "WHERE B.ak = A.savininkas");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            sarasas.add(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
        return sarasas;
    }
    public List getVisasSaskaitasVartotojoSuLikuciais() throws SQLException{
        List <String> sarasas = new ArrayList<>();
        
        PreparedStatement stmt = this.db.prepareStatement(""
                + "SELECT A.nr, A.pinigulikutis, A.kreditas, C.pavadinimas "
                + "FROM aima3213.zmogus as B, aima3213.saskaita as A, aima3213.bankas as C "
                    + "WHERE B.ak = ? AND B.ak = A.savininkas AND A.bankas = C.nr");
        stmt.setString(1, vartotojas.getAsmensKodas());
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            sarasas.add(rs.getString(1) + "   " + rs.getBigDecimal(2)+ "   " + rs.getBigDecimal(3) + "   " + rs.getString(4));
        }
        return sarasas;
    }
    public List getVisasSaskaitasSuLikuciais() throws SQLException{
        List <String> sarasas = new ArrayList<>();
        
        PreparedStatement stmt = this.db.prepareStatement(""
                + "SELECT A.nr, A.pinigulikutis, A.kreditas, C.pavadinimas "
                + "FROM aima3213.zmogus as B, aima3213.saskaita as A, aima3213.bankas as C "
                    + "WHERE B.ak = A.savininkas AND A.bankas = C.nr");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            sarasas.add(rs.getString(1) + "   " + rs.getBigDecimal(2)+ "   " + rs.getBigDecimal(3) + "   " + rs.getString(4));
        }
        return sarasas;
    }
    
    public List getTransakcijuSarasasGautu() throws SQLException{
        List <String> sarasas = new ArrayList<>();
        
        PreparedStatement stmt = this.db.prepareStatement(""
                + "SELECT B.gavejosasnr, B.siuntejosasnr, B.suma "
                + "FROM aima3213.transakcija as B, aima3213.saskaita as A "
                    + "WHERE A.savininkas = ? AND B.gavejosasnr = A.nr");
        
        stmt.setString(1, vartotojas.getAsmensKodas());
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            sarasas.add(rs.getString(2) + "   " + rs.getString(1)+ "   " + rs.getBigDecimal(3));
        }
        return sarasas;
    }
    public List getTransakcijuSarasasIssiustu() throws SQLException{
        List <String> sarasas = new ArrayList<>();
        
        PreparedStatement stmt = this.db.prepareStatement(""
                + "SELECT B.gavejosasnr, B.siuntejosasnr, B.suma "
                + "FROM aima3213.transakcija as B, aima3213.saskaita as A "
                    + "WHERE A.savininkas = ? AND B.siuntejosasnr = A.nr");
        
        stmt.setString(1, vartotojas.getAsmensKodas());
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            sarasas.add(rs.getString(2) + "   " + rs.getString(1)+ "   " + rs.getBigDecimal(3));
        }
        return sarasas;
    }
   
    @Override
   public String toString(){
       return this.nr + " " + this.pavadinimas + " " + this.adresas;
   }
   
}
