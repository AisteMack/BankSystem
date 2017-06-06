
package bank;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class ZmogusDarbuotojas extends Zmogus{
    
    public ZmogusDarbuotojas(String vardas, String pavarde) {
        super(vardas, pavarde);
    }
    
    public void guiRealizacija(Bankas bank, GUIprisijungimas gui){
        GUIdarbMeniu admin = new GUIdarbMeniu(bank, gui);
        admin.setVisible(true);
    }
    @Override
    public String toString(){
        return "DARBUOTOJAS " + super.toString();
    }
}
