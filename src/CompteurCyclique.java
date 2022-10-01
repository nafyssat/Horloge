public class CompteurCyclique{
    private final int sup;
    private int valeur;
    public void setValeur(int i){
        if(i>sup){
            this.valeur=i%sup;
        }else{
            this.valeur=i;
        }
       
    }
    public CompteurCyclique(int sup){
        this.sup=sup;
        this.valeur=0;
    }
    public CompteurCyclique(int sup , int valeur){
        this(sup);
        this.setValeur(valeur);
    }
    public int getValeur(){
        return this.valeur;
    }
    public void reinitialiser(){
        this.valeur=0;
    }
    public boolean incrementer(){
        this.valeur++;
        if(this.valeur==sup){
            this.valeur=0;
            return true;
        }
        return false;
    }
    public String toString(){
        int nbchiffres=String.valueOf(sup).length();
        String s="%0"+nbchiffres+"d";
        return String.format(s,this.valeur);
    }
}
