package model;

public class Karteikarte{
    private String[] vokabelpaar; //immer in dem Format gespeichert: deutsch, englisch
    private String name; //der Name der Karteikarte ist immer der Deutsche Begriff

    public String[] getVokabelpaar() {
        return vokabelpaar;
    }

    public String getName() {
        return name;
    }
}
