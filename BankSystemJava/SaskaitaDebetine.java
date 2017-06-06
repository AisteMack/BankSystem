
package bank;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class SaskaitaDebetine extends Saskaita{
    
    public SaskaitaDebetine(String numeris, int bankoNr, double likutis) {
        super(numeris, bankoNr, likutis);
    }
    
    @Override
    void paimti(double kiekis) throws SaskaitaException
    {
        if(kiekis <= 0){
           throw new SaskaitaException("Negalima paimti neigiamo kiekio pinigu."); 
           
        }else if(kiekis > this.likutis)
        {
            System.out.println("Nepakanka pinigu debetine " + likutis + " " + (likutis - kiekis));
           throw new SaskaitaException("Saskaitoje nepakanka pinigu.", this.likutis - kiekis);
        }else{
            this.likutis = this.likutis - kiekis;
        }
    }
    
    @Override
    public String toString(){
        return "DEBETINE SAS., " + super.toString();
    }
}
