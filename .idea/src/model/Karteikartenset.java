package model;

public class Karteikartenset {
    private final int arraygröße = 10; //Jedes Karteikartenset hat maximal 10 Karteikarten
    private final  Karteikarte[] kt = new Karteikarte[arraygröße];
    private String name = "DefaultName";

    public Karteikartenset(String name) {
        setName(name);
    }

    public Karteikartenset() {
        setName("AutomatischerKarteikartensetName");
    }

    public void karteikarteHinzufeuegen(Karteikarte neu) throws Exception {
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

}
