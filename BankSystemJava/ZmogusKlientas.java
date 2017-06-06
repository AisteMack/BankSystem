
package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class ZmogusKlientas extends Zmogus{

    private String vartotojoVardas;
    private String adresas;
    private String gimimoData;
    private String telNumeris;
    private String asmensKodas;
    private String elPastas;
    
    private List<Saskaita> saskaitos;
    
    public ZmogusKlientas(String vardas, String pavarde, String asmensKodas, String vartotojoVardas){
        super(vardas, pavarde);
        this.asmensKodas = asmensKodas;
        saskaitos = new ArrayList<>();
        this.vartotojoVardas = vartotojoVardas;
    }

    public ZmogusKlientas(String asmensKodas, String vardas, String pavarde, String telNumeris, String vartotojoVardas) {
        super(vardas, pavarde);
        this.telNumeris = telNumeris;
        this.asmensKodas = asmensKodas;
        this.vartotojoVardas = vartotojoVardas;
        saskaitos = new ArrayList<>();
    }
    
 
    public ZmogusKlientas(String asmensKodas, String vardas, String pavarde, String telNumeris,  String elPastas, String vartotojoVardas) {
        super(vardas, pavarde);
        this.telNumeris = telNumeris;
        this.asmensKodas = asmensKodas;
        this.elPastas = elPastas;
        this.vartotojoVardas = vartotojoVardas;
        saskaitos = new ArrayList<>();
    }

    public String getVartotojoVardas() {
        return vartotojoVardas;
    }
    
    public void setAdresas(String adresas){
        this.adresas = adresas;
    }
    public String getAdresas(){
        return this.adresas;
    }
    public void setGimimoData(String gimimoData){
        this.gimimoData = gimimoData;
    }
    public String getGimimoData(){
        return this.gimimoData;
    }
    public void setTelNumeris(String telNumeris){
        this.telNumeris = telNumeris;
    }
    public String getTelNumeris(){
        return this.telNumeris;
    }
    public void setAsmensKodas(String asmensKodas){
        this.asmensKodas = asmensKodas;
    }
    public String getAsmensKodas(){
        return this.asmensKodas;
    }
    public void setElPastas(String elPastas){
        this.elPastas = elPastas;
    }
    public String getElPastas(){
        return this.elPastas;
    }
    public void setSaskaitasIsSQL(Connection con) throws SQLException{
        saskaitos.clear();
      PreparedStatement stmt = con.prepareStatement("SELECT * FROM aima3213.saskaita "
                    + "WHERE savininkas = ?");
        stmt.setString(1, this.asmensKodas);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            
            String swt = rs.getString(2);
            String sasNr = rs.getString(1);
            int bankas = rs.getInt(3);
            double likutis = rs.getBigDecimal(5).doubleValue();
            double kreditas = rs.getBigDecimal(6).doubleValue();
            System.out.println(swt);
            Saskaita saskaita = null;
            switch(swt.toLowerCase()){
                case "debetine  ":
                    System.out.println("!Debetine");
                    saskaita = new SaskaitaDebetine(sasNr, bankas, likutis);
                    break;
                case "kreditine ":
                    System.out.println("!Kreditine");
                    saskaita = new SaskaitaKreditine(sasNr, kreditas, bankas, likutis);
                    break;
                case "taupomoji ":
                    System.out.println("!Taupomoji");
                    saskaita = new SaskaitaTaupomoji(sasNr, bankas, likutis);
                    break;
                default:
                    System.out.println("Neradom");
            }
            
            saskaitos.add(saskaita);
        }
           this.getSaskaitosSarasa();
    }
    public boolean pridetiSaskaita(Saskaita sas){
            return saskaitos.add(sas);

    }

    public Saskaita getSaskaita(String saskaitosNr){
        for(Saskaita c : saskaitos){
           if(saskaitosNr.equals(c.getNumeris())){
               return c;
           }
        }
           return null;
    }
    
    
    public List getSaskaitos(){
        return this.saskaitos;
    }
    public void getSaskaitosSarasa(){
        System.out.println(Arrays.toString(saskaitos.toArray()));
    }
    
    public void guiRealizacija(Bankas bank, GUIprisijungimas gui){
       GUIklientoMeniu formMeniu = new GUIklientoMeniu(bank, this, gui);
       formMeniu.setVisible(true);
    }

    @Override
    public String toString(){
        return "KLIENTAS " + super.toString() +
                " AK: " + asmensKodas;
    }
}
