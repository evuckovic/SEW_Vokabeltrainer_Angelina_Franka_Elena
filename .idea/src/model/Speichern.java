package model;

public class Speichern {
    private String defaultPfad = "";

    public void saveTrainerDefault(Trainer trainer, String filename){
        saveTrainer(trainer, filename, defaultPfad);
    }

    public void saveTrainer(Trainer trainer, String filename, String pfad){
        if(trainer == null){
            Benutzer db = new Benutzer();
            Karteikarte kt = new Karteikarte();
            Karteikartenset kts = new Karteikartenset();
        }

    }
}
