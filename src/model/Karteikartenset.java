package model;

public class Karteikartenset {
    private final int arraygröße = 10;
    private final Karteikarte[] kt = new Karteikarte[arraygröße];
    private String name = "DefaultName";

    public Karteikartenset(String name) {
        setName(name);
    }

    public Karteikartenset() {
        setName("AutomatischerKarteikartensetName");
    }

    public void karteikarteHinzufuegen(Karteikarte neu) throws Exception {
        if (neu != null) {
            for (int i = 0; i < kt.length; i++) {
                if (kt[i] == null) {
                    kt[i] = neu;
                    return; // Beendet die Schleife, sobald ein Platz gefunden wurde
                }
            }
            throw new Exception("Maximale Anzahl an Karteikarten erreicht (max 10).");
        }
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public Karteikarte getKarteikarte(int index) {
        if (index >= 0 && index < arraygröße) {
            return kt[index];
        }
        return null;
    }
}