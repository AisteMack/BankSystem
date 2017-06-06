
package bank;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class Zmogus implements InterfaceInfo {
    protected String vardas;
    protected String pavarde;

    public Zmogus(String vardas, String pavarde) {
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }
   
    @Override
    public String toString(){
        return "Vardas: " + vardas + " Pavarde: " + pavarde;
    }

    @Override
    public void spausdinkInfo() {
        System.out.println(toString());
    }
    
    
    
}
