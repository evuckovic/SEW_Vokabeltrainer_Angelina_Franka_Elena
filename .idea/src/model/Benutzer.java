package model;

public class Benutzer {
    private String name = "DefaultName";
    private String pw;
    private int anzahlRichtig = 0;
    private int anzhalFalsch = 0;
    private double qoute = ( (anzahlRichtig+anzhalFalsch) / (anzahlRichtig) )*100; //Berechnet immer die Quote vom letzten vollendeten "Testen". Nach jedem Ende des Testvorgangs wird die Quote neu angezeigt.

    //Weil jeder Benutzer seine eigenen Karteikartensets hat und aber auch 3 Default sets
    private Karteikartenset[] kts = new Karteikartenset[20]; //Jeder User kann 20 Sets erstellen

    public Benutzer(String name, String pw) {
        setName(name);
        setPw(pw);

    }

    public Benutzer() {
        setName("User");
        setPw("User");
    }

    public boolean ktsHinzufuegen(Karteikartenset kts){
        if(kts != null) {
            for(int i = 0; i < this.kts.length; i ++){
                if (this.kts[i] == null){
                    this.kts[i] = kts;
                    return true;
                }
            }
        }
        return false;
    }

    public void setName(String name) {
        if(!name.isEmpty() && name != null) {
            this.name = name;
        }
    }

    public void setPw(String pw) {
        if(!pw.isEmpty() && pw != null) {
            this.pw = pw;
        }    }

    public void setAnzahlRichtig(int anzahlRichtig) {
        if(anzahlRichtig >= 0){
            this.anzahlRichtig = anzahlRichtig;
        }
        //else fehöer - exception
    }

    public void setAnzhalFalsch(int anzhalFalsch) {
        if(anzhalFalsch >= 0){
            this.anzhalFalsch = anzhalFalsch;
        }
    }

    public void setQoute(double qoute) {
        if(qoute >= 0){
            this.qoute = qoute;
        }
    }

    public String getName() {
        return name;
    }

    public String getPw() {
        return pw;
    }

    public int getAnzahlRichtig() {
        return anzahlRichtig;
    }

    public int getAnzhalFalsch() {
        return anzhalFalsch;
    }

    public double getQoute() {
        return qoute;
    }
}
