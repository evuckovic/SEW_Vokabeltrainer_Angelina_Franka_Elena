package model;

public class Speichern {
    private String defaultPfad = "";

    public void saveTrainerDefault(Trainer trainer, String filename) throws Exception {
        saveTrainer(trainer, filename, defaultPfad);
    }

    public void saveTrainer(Trainer trainer, String filename, String pfad) throws Exception {
        if(trainer == null){
            Benutzer db = new Benutzer();
            Karteikarte kt = new Karteikarte("deutsch", "germen");
            Karteikartenset kts = new Karteikartenset();
        }

    }
}
