package controller;

import model.*;

public class TrainerController {

    private Trainer trainer;
    private Benutzer aktuellerBenutzer;

    public TrainerController() throws Exception {

        Benutzer b = new Benutzer("TestUser", "1234");

        Benutzer[] benutzerListe = new Benutzer[10];
        benutzerListe[0] = b;

        trainer = new Trainer(benutzerListe, b.getKts());
        aktuellerBenutzer = b;
    }

    public String[] getSetNamen() {

        Karteikartenset[] sets = trainer.getKts();

        int count = 0;
        for (Karteikartenset s : sets)
            if (s != null) count++;

        String[] namen = new String[count];
        int i = 0;

        for (Karteikartenset s : sets)
            if (s != null)
                namen[i++] = s.getName();

        return namen;
    }

    public String getDeutsch(String setName, int index) {
        return trainer.lernen(setName, index);
    }

    public boolean pruefeAntwort(String setName, int index, String eingabe) {
        return trainer.pruefen(setName, index, eingabe);
    }

    public Benutzer getAktuellerBenutzer() {
        return aktuellerBenutzer;
    }

    public boolean login(String name, String passwort) {

        Benutzer[] liste = trainer.getBenutzer();

        for (Benutzer b : liste) {

            if (b != null &&
                    b.getName().equals(name) &&
                    b.getPw().equals(passwort)) {

                aktuellerBenutzer = b;
                trainer.setKts(b.getKts());
                return true;
            }
        }

        return false;
    }

    public boolean registrieren(String name, String passwort) {

        try {
            Benutzer neuer = new Benutzer(name, passwort);

            Benutzer[] liste = trainer.getBenutzer();

            for (int i = 0; i < liste.length; i++) {
                if (liste[i] == null) {
                    liste[i] = neuer;
                    aktuellerBenutzer = neuer;
                    trainer.setKts(neuer.getKts());
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean neuesSet(String name) {

        try {
            Karteikartenset neu = new Karteikartenset(name);

            aktuellerBenutzer.ktsHinzufuegen(neu);
            trainer.setKts(aktuellerBenutzer.getKts());

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
