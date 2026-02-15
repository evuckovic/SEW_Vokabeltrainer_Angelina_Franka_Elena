package controller;

import model.*;
import view.*;
import javax.swing.JOptionPane;

public class TrainerController {
    private MainFrame mainFrame;
    private Trainer trainer;
    private LadenSpeichernTrainer storage;
    private Benutzer aktuellerBenutzer;

    public TrainerController() {
        // 1. Daten-Management initialisieren
        this.storage = new LadenSpeichernTrainer();

        // 2. Bestehende Daten laden (falls Datei vorhanden)
        this.trainer = storage.laden("daten.txt");

        // 3. GUI erstellen und Referenz auf diesen Controller übergeben
        this.mainFrame = new MainFrame(this);
    }

    // --- Logik für die GUI ---

    /**
     * Prüft, ob ein Benutzer mit Name und Passwort existiert.
     */
    public void login(String name, String passwort) {
        Benutzer[] alleBenutzer = trainer.getBenutzer();

        for (int i = 0; i < alleBenutzer.length; i++) {
            if (alleBenutzer[i] != null &&
                    alleBenutzer[i].getName().equals(name) &&
                    alleBenutzer[i].getPw().equals(passwort)) {

                this.aktuellerBenutzer = alleBenutzer[i];
                mainFrame.showPanel("START");
                return;
            }
        }
        JOptionPane.showMessageDialog(mainFrame, "Benutzername oder Passwort falsch!", "Login Fehler", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Erstellt einen neuen Benutzer und speichert sofort.
     */
    public void registrieren(String name, String passwort) {
        try {
            Benutzer neu = new Benutzer(name, passwort);
            Benutzer[] liste = trainer.getBenutzer();

            for (int i = 0; i < liste.length; i++) {
                if (liste[i] == null) {
                    liste[i] = neu;
                    storage.speichern(trainer, "daten.txt");
                    JOptionPane.showMessageDialog(mainFrame, "Registrierung erfolgreich!");
                    mainFrame.showPanel("LOGIN");
                    return;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "Fehler: " + e.getMessage());
        }
    }

    /**
     * Erstellt ein neues Set für den eingeloggten Nutzer.
     */
    public void neuesSetErstellen(String setName) {
        if (aktuellerBenutzer != null) {
            try {
                Karteikartenset neu = new Karteikartenset(setName);
                aktuellerBenutzer.ktsHinzufuegen(neu);

                // GUI updaten
                mainFrame.getLernPanel().addSet(setName);

                // Daten sichern
                storage.speichern(trainer, "daten.txt");
                mainFrame.showPanel("LERNEN");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "Fehler: " + e.getMessage());
            }
        }
    }

    public Benutzer getAktuellerBenutzer() {
        return aktuellerBenutzer;
    }
}