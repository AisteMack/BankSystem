
package bank;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class SaskaitaTaupomoji extends Saskaita {
    String idejimoData;
    String atsiemimoData;
    public SaskaitaTaupomoji(String numeris, int bankoNr, double likutis) {
        super(numeris, bankoNr, likutis);
    }
    @Override
    public void paimti(double kiekis) throws SaskaitaException{
        if(kiekis <= 0){
           throw new SaskaitaException("Negalima paimti neigiamo kiekio pinigu."); 
        }else if(kiekis > this.likutis)
        {
            System.out.println("Nepakanka pinigu taupomoji " + likutis + " " + (likutis - kiekis));
           throw new SaskaitaException("Saskaitoje nepakanka pinigu.", this.likutis - kiekis);
        }else{
            this.likutis = this.likutis - kiekis;
        }
    }
    
}
