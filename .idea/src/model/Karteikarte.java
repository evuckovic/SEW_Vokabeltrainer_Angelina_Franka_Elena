package model;

public class Karteikarte {
    private String[] vokabelpaar = new String[2]; // Index 0: Deutsch, Index 1: Englisch

    public Karteikarte(String deutsch, String englisch) throws Exception {
        setDeutsch(deutsch);
        setEnglisch(englisch);
    }

    public Karteikarte() {
    }

    public String[] getVokabelpaar() {
        return vokabelpaar;
    }

    public void setDeutsch(String deutsch) throws Exception {
        if (deutsch != null && !deutsch.isEmpty()) {
            this.vokabelpaar[0] = deutsch;
        } else {
            throw new Exception("Deutsches Wort darf nicht leer sein.");
        }
    }

    public void setEnglisch(String englisch) throws Exception {
        if (englisch != null && !englisch.isEmpty()) {
            this.vokabelpaar[1] = englisch;
        } else {
            throw new Exception("Englischer Begriff darf nicht leer sein.");
        }
    }
}