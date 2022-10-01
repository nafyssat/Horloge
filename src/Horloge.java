public class Horloge {
    private CompteurCyclique heures , minutes,secondes;
    public Horloge(){
        this.secondes=new CompteurCyclique(60);
        this.heures=new CompteurCyclique(24);
        this.minutes=new CompteurCyclique(60);
    }
    public void setHeure(int h , int m){
        this.heures.setValeur(h);
        this.minutes.setValeur(m);
    }
    public void setHeure(int h){
        this.heures.setValeur(h);
    }
    public void incrementer(){
        if(this.secondes.incrementer()){
            if(this.minutes.incrementer()){
                this.heures.incrementer();
            }
        }
        
    }
    public String toString(){
        return heures.toString()+" : "+minutes.toString();
    }
    public CompteurCyclique getMinutes(){
        return this.minutes;
    }
    public CompteurCyclique getHeures(){
        return this.heures;
    }
    public CompteurCyclique getSecondes(){
        return this.secondes;
    }
}
