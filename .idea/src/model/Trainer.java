package model;

public class Trainer {
    private Benutzer[] benutzer;
    private Karteikartenset[] kts;

    public Trainer(Benutzer[] b, Karteikartenset[] k) {
        setBenutzer(b);
        setKts(k);
    }

    public void lernen(String ktsName){

    }
    public int[] testen(){
        return new int[2];
    }
    public void spielen(){

    }

    public Benutzer[] getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer[] b) {
        if(b != null){
            benutzer = b;
        }
    }

    public Karteikartenset[] getKts() {
        return kts;
    }

    public void setKts(Karteikartenset[] k) {
        if(k != null){
            kts = k;
        }
    }

}
