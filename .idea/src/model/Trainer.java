package model;

import javax.swing.JOptionPane;

public class Trainer {
    private Benutzer[] benutzer;
    private Karteikartenset[] kts;

    public Trainer(Benutzer[] b, Karteikartenset[] k) {
        setBenutzer(b);
        setKts(k);
    }

    /**
     * Gibt das deutsche Wort einer Karteikarte in einem bestimmten Set zurück.
     */
    public String lernen(String setName, int kartenIndex) {
        // Suche nach dem Set mit dem passenden Namen
        for (int i = 0; i < kts.length; i++) {
            if (kts[i] != null && kts[i].getName().equals(setName)) {
                try {
                    // Hole die Karteikarte über den Index
                    Karteikarte k = kts[i].getKarteikarte(kartenIndex);
                    // Sicherstellen, dass die Karte an diesem Index existiert
                    if (k != null && k.getVokabelpaar() != null) {
                        // Index 0 des Vokabelpaars ist Deutsch
                        return k.getVokabelpaar()[0];
                    }
                } catch (Exception e) {
                    return "Karte an diesem Index nicht gefunden";
                }
            }
        }
        return "Set nicht gefunden";
    }

    /**
     * Überprüft die Eingabe, aktualisiert Statistiken und zeigt bei Fehlern eine Meldung.
     */
    public boolean testen(String benutzerName, String setName, String englischWort, String benutzerEingabe) {
        Benutzer b = null;

        // 1. Benutzer suchen
        for (int i = 0; i < benutzer.length; i++) {
            if (benutzer[i] != null && benutzer[i].getName().equals(benutzerName)) {
                b = benutzer[i];
                break;
            }
        }

        if (b == null) return false;

        // 2. Set suchen
        for (int i = 0; i < kts.length; i++) {
            if (kts[i] != null && kts[i].getName().equals(setName)) {

                // 3. Karte im Set suchen, die dem englischen Wort entspricht
                // Wir nutzen 10, da dies die feste arraygröße im Karteikartenset ist
                for (int j = 0; j < 10; j++) {
                    try {
                        Karteikarte k = kts[i].getKarteikarte(j);

                        // Prüfen, ob Karte existiert und ob das englische Wort (Index 1) übereinstimmt
                        if (k != null && k.getVokabelpaar()[1].equalsIgnoreCase(englischWort)) {

                            String korrekteAntwort = k.getVokabelpaar()[0];

                            // Vergleich der Eingabe (ignoriert Groß-/Kleinschreibung)
                            if (benutzerEingabe != null && benutzerEingabe.equalsIgnoreCase(korrekteAntwort)) {
                                b.setAnzahlRichtig(b.getAnzahlRichtig() + 1);
                                return true;
                            } else {
                                b.setAnzhalFalsch(b.getAnzhalFalsch() + 1);
                                // Fehlermeldung mit JOptionPane
                                JOptionPane.showMessageDialog(null,
                                        "Leider falsch! Die richtige Antwort für '" + englischWort + "' ist: " + korrekteAntwort,
                                        "Falsche Antwort",
                                        JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        }
                    } catch (Exception e) {
                        // Falls ein Index-Fehler auftritt, ignorieren wir diesen Slot und suchen weiter
                    }
                }
            }
        }
        return false;
    }

    /**
     * Wählt eine einfache Vokabel zum Starten aus.
     */
    public void spielen() {
        // Prüfen, ob überhaupt Sets und Karten vorhanden sind
        if (kts != null && kts.length > 0 && kts[0] != null) {
            try {
                Karteikarte k = kts[0].getKarteikarte(0);
                if (k != null) {
                    JOptionPane.showMessageDialog(null, "Spiel-Modus Start! Übersetze: " + k.getVokabelpaar()[1]);
                } else {
                    JOptionPane.showMessageDialog(null, "Das erste Set ist leer.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Fehler beim Laden der Spieldaten.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Keine Karteikartensets zum Spielen verfügbar.");
        }
    }

    // --- Getter & Setter ---
    public Benutzer[] getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer[] b) {
        if (b != null) {
            this.benutzer = b;
        }
    }

    public Karteikartenset[] getKts() {
        return kts;
    }

    public void setKts(Karteikartenset[] k) {
        if (k != null) {
            this.kts = k;
        }
    }
}