package model;

public class Karteikartenset {
    private final int arraygröße = 10; //Jedes Karteikartenset hat maximal 10 Karteikarten
    private final Karteikarte Karteikarte[] = new Karteikarte[arraygröße];
    private String name = "DefaultName";

    public Karteikartenset(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
