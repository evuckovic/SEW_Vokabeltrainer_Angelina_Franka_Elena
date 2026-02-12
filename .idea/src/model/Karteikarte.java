package model;

public class Karteikarte{
    private String[] vokabelpaar = new String[2];  //immer in dem Format gespeichert: deutsch, englisch

    public Karteikarte(String[] vokabelpaar, String name) {
        this.vokabelpaar = vokabelpaar;
    }

    public String[] getVokabelpaar() {
        return vokabelpaar;
    }

    public void setVokabelpaar(String[] vokabelpaar) {
        this.vokabelpaar = vokabelpaar;
    }
}
