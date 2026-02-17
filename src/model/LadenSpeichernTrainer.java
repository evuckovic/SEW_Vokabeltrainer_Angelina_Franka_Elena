package model;
import java.io.*;

public class LadenSpeichernTrainer {

    private String defaultPfad = "";

    /**
     * Speichert den gesamten Zustand des Trainers (alle Benutzer, Sets und Karten).
     */
    public void speichern(Trainer trainer, String filename) {
        // Sicherstellen, dass der Dateiname auf .txt endet
        if (!filename.endsWith(".txt")) {
            filename = filename + ".txt";
        }

        try (PrintWriter w = new PrintWriter(new FileWriter(defaultPfad + filename))) {
            Benutzer[] alleBenutzer = trainer.getBenutzer();

            // Alle Benutzer durchgehen
            for (int i = 0; i < alleBenutzer.length; i++) {
                Benutzer b = alleBenutzer[i];
                if (b == null) continue;

                // Benutzer-Block starten
                w.println("+++");
                w.println(b.getName());
                w.println(b.getPw());
                w.println(b.getAnzahlRichtig());
                w.println(b.getAnzhalFalsch());

                // Karteikartensets des Benutzers durchgehen
                Karteikartenset[] sätze = b.getKts();
                for (int j = 0; j < sätze.length; j++) {
                    Karteikartenset set = sätze[j];
                    if (set == null) continue;

                    // Set-Block starten
                    w.println("***");
                    w.println(set.getName());

                    // Karten des Sets durchgehen (maximale Größe 10)
                    for (int k = 0; k < 10; k++) {
                        Karteikarte karte = set.getKarteikarte(k);
                        if (karte != null) {
                            // Format: deutsch=englisch
                            String[] paar = karte.getVokabelpaar();
                            w.println(paar[0] + "=" + paar[1]);
                        }
                    }
                }
            }
            // Abschlusszeichen für das Dateiende
            w.println("+++");

        } catch (IOException e) {
            System.out.println("FEHLER beim Speichern: " + e.getMessage());
        }
    }

    /**
     * Lädt alle Benutzer und deren Daten aus einer Textdatei.
     */
    public Trainer laden(String filename) {
        if (!filename.endsWith(".txt")) {
            filename = filename + ".txt";
        }

        Benutzer[] benutzerListe = new Benutzer[100]; // Puffer für geladene Benutzer
        int benutzerAnzahl = 0;

        try (BufferedReader r = new BufferedReader(new FileReader(defaultPfad + filename))) {
            String line;
            Benutzer aktuellerBenutzer = null;
            Karteikartenset aktuellesSet = null;

            while ((line = r.readLine()) != null) {
                // Ende-Erkennung oder neuer Benutzer
                if (line.equals("+++")) {
                    // Wenn wir schon einen Benutzer hatten, fangen wir einen neuen an
                    // oder beenden das Einlesen, falls die Datei leer ist
                    line = r.readLine();
                    if (line == null || line.equals("+++")) break;

                    String name = line;
                    String pw = r.readLine();
                    int richtig = Integer.parseInt(r.readLine());
                    int falsch = Integer.parseInt(r.readLine());

                    aktuellerBenutzer = new Benutzer(name, pw);
                    aktuellerBenutzer.setAnzahlRichtig(richtig);
                    aktuellerBenutzer.setAnzhalFalsch(falsch);

                    // Benutzer zur Liste hinzufügen
                    if (benutzerAnzahl < benutzerListe.length) {
                        benutzerListe[benutzerAnzahl] = aktuellerBenutzer;
                        benutzerAnzahl++;
                    }
                    continue;
                }

                // Ein neues Set wurde gefunden
                if (line.equals("***")) {
                    String setName = r.readLine();
                    aktuellesSet = new Karteikartenset(setName);

                    if (aktuellerBenutzer != null) {
                        aktuellerBenutzer.ktsHinzufuegen(aktuellesSet);
                    }
                    continue;
                }

                // Eine Vokabelkarte wurde gefunden
                if (line.contains("=")) {
                    String[] teile = line.split("=");
                    if (teile.length == 2 && aktuellesSet != null) {
                        try {
                            Karteikarte k = new Karteikarte(teile[0], teile[1]);
                            aktuellesSet.karteikarteHinzufuegen(k);
                        } catch (Exception e) {
                            // Fehler bei Karte ignorieren
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("FEHLER beim Laden: " + e.getMessage());
        }

        // Neues Trainer-Objekt mit den geladenen Daten zurückgeben
        // Wir nehmen hier das erste Set des ersten Nutzers als Standard-Sets für den Trainer-Konstruktor
        Karteikartenset[] sätze = (benutzerAnzahl > 0) ? benutzerListe[0].getKts() : new Karteikartenset[20];
        return new Trainer(benutzerListe, sätze);
    }
}