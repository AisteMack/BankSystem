
package bank;

/**
 *
 * @author Aistė Mackevičiūtė
 */
abstract class Saskaita implements InterfaceInfo{
    protected double likutis;
    protected final String numeris;
    protected final int bankoNr;

    
    public Saskaita(String numeris, int bankoNr){
        this.numeris = numeris;
        this.likutis = 0.0;
        this.bankoNr = bankoNr;
    }
    
    public Saskaita(String numeris, int bankoNr, double likutis){
        this.numeris = numeris;
        this.likutis = likutis;
        this.bankoNr = bankoNr;
        
    }
    public boolean ideti(double kiekis){
        if(kiekis > 0){
            this.likutis = this.likutis + kiekis;  
            return true;
        }else{
            return false;
        }
        
    }
    abstract void paimti(double kiekis) throws SaskaitaException;

    
    public double getLikutis(){
        return this.likutis;
    }
    public String getNumeris(){
        return this.numeris;
    }
    
    @Override
    public String toString(){
        return "SAS. NR.: " + getNumeris() + " LIKUTIS: "+ getLikutis();
    }
    
    public String toStringNr(){
        return getNumeris();
    }
    
    public String toStringLikutis(){
        return " " + getLikutis();
    }
    @Override
    public void spausdinkInfo() {
        System.out.println(toString());
    }
}
