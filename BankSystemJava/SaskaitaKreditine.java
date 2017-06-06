
package bank;

/**
 *
 * @author Aistė Mackevičiūtė
 */
public class SaskaitaKreditine extends Saskaita{
    
    double kreditas;

    public double getKreditas() {
        return kreditas;
    }

    public void setKreditas(double kreditas) {
        this.kreditas = kreditas;
    }
   public SaskaitaKreditine(String numeris, double kreditas, int bankoNr, double likutis) {
        super(numeris, bankoNr, likutis);
        this.kreditas = kreditas;
        
    }
    public SaskaitaKreditine(String numeris, int bankoNr) {
        super(numeris, bankoNr);
        this.kreditas = 0.0;
        
    }
    
    @Override
    public void paimti(double kiekis) throws SaskaitaException{
        if(kiekis <= 0){
           throw new SaskaitaException("Negalima paimti neigiamo kiekio pinigu."); 
        }else if(kiekis >= (this.likutis + this.kreditas))
        {
            System.out.println("Nepakanka pinigu kreditas " + likutis + " " + (likutis - kiekis));
           throw new SaskaitaException("Saskaitoje nepakanka pinigu.", (this.likutis + this.kreditas) - kiekis);
        }else{
            this.likutis = this.likutis - kiekis;
            if(this.likutis < 0){
                this.kreditas += this.likutis;
                this.likutis = 0;
            }
        }
    }
    
    @Override
    public String toString(){
        return "KREDITINE SAS., " + super.toString() + " KREDITAS: " + this.kreditas;
    }
}
