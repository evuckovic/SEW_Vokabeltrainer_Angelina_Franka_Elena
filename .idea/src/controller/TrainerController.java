package controller;

import model.*;

public class TrainerController {

    private Trainer trainer;
    private Benutzer aktuellerBenutzer;

    public TrainerController() throws Exception {

        // Standardbenutzer erzeugen
        Benutzer b = new Benutzer("TestUser", "1234");

        Benutzer[] benutzerListe = new Benutzer[10];
        benutzerListe[0] = b;

        trainer = new Trainer(benutzerListe, b.getKts());
        aktuellerBenutzer = b;
    }

    public String[] getSetNamen() {

        Karteikartenset[] sets = trainer.getKts();

        int count = 0;
        for (Karteikartenset s : sets) {
            if (s != null) count++;
        }

        String[] namen = new String[count];
        int index = 0;

        for (Karteikartenset s : sets) {
            if (s != null) {
                namen[index] = s.getName();
                index++;
            }
        }

        return namen;
    }

    public String getDeutsch(String setName, int index) {
        return trainer.lernen(setName, index);
    }

    public boolean pruefeAntwort(String setName, String englisch, String eingabe) {
        return trainer.testen(aktuellerBenutzer.getName(), setName, englisch, eingabe);
    }

    public Benutzer getAktuellerBenutzer() {
        return aktuellerBenutzer;
    }
}
