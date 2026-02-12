package model;

public class Benutzer {
    private String name;
    private String pw;
    private int anzahlRichtig;
    private int anzhalFalsch;
    private double qoute = ( (anzahlRichtig+anzhalFalsch) / (anzahlRichtig) )*100; //Berechnet immer die Quote vom letzten vollendeten "Testen". Nach jedem Ende des Testvorgangs wird die Quote neu angezeigt.

    public Benutzer(String name, String pw, int anzahlRichtig, int anzhalFalsch) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setAnzahlRichtig(int anzahlRichtig) {
        this.anzahlRichtig = anzahlRichtig;
    }

    public void setAnzhalFalsch(int anzhalFalsch) {
        this.anzhalFalsch = anzhalFalsch;
    }

    public void setQoute(double qoute) {
        this.qoute = qoute;
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
