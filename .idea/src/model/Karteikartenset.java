package model;

public class Karteikartenset {
    private final int arraygröße = 10; //Jedes Karteikartenset hat maximal 10 Karteikarten
    private final  Karteikarte[] kt = new Karteikarte[arraygröße];
    private String name = "DefaultName";

    public Karteikartenset(String name) throws Exception {
        setName(name);
    }

    public Karteikartenset() throws Exception {
        setName("AutomatischerKarteikartensetName");
    }

    public void karteikarteHinzufuegen(Karteikarte neu) throws Exception {
        if(neu != null){
            for(int i = 0; i < kt.length; i ++){
                if (kt[i] == null){
                    kt[i] = neu;
                }
            }
        }else{
            throw new Exception("Maximale Anzahl an Karteikarten im Set erreicht (max 10 möglich)");
        }
    }

    public void setName(String name) {
        if(!name.isEmpty() && name != null) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public Karteikarte getKarteikarte(int index) throws Exception {
        if(index >= 0 && index < this.arraygröße){
            return kt[index]; // Kann null sein, wenn Platz leer ist
        } else {
            throw new Exception("Index außerhalb der Reichweite");
        }
    }


}
