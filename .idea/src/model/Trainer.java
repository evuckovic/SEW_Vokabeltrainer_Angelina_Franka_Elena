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
                    if (k != null) {
                        // Index 0 des Vokabelpaars ist immer Deutsch
                        return k.getVokabelpaar()[0];
                    }
                } catch (Exception e) {
                    return "Index nicht gefunden";
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

                // 3. Karte im Set suchen, die dem englischen Wort entspricht (max 10 Karten laut Karteikartenset)
                for (int j = 0; j < 10; j++) {
                    try {
                        Karteikarte k = kts[i].getKarteikarte(j);
                        if (k != null && k.getVokabelpaar()[1].equals(englischWort)) {

                            String korrekteAntwort = k.getVokabelpaar()[0];

                            // Vergleich der Eingabe (ignoriert Groß-/Kleinschreibung)
                            if (benutzerEingabe.equalsIgnoreCase(korrekteAntwort)) {
                                b.setAnzahlRichtig(b.getAnzahlRichtig() + 1);
                                return true;
                            } else {
                                b.setAnzhalFalsch(b.getAnzhalFalsch() + 1);
                                // Fehlermeldung ausgeben
                                JOptionPane.showMessageDialog(null,
                                        "Leider falsch! Die richtige Antwort für '" + englischWort + "' ist: " + korrekteAntwort,
                                        "Falsche Antwort",
                                        JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        }
                    } catch (Exception e) {
                        // Karte an diesem Index existiert nicht, Schleife geht weiter
                    }
                }
            }
        }
        return false;
    }

    /**
     * Wählt eine zufällige Vokabel aus allen verfügbaren Sets aus.
     */
    public void spielen() {
        // Einfache Logik: Wähle das erste verfügbare Set und die erste Karte
        if (kts != null && kts.length > 0 && kts[0] != null) {
            try {
                Karteikarte k = kts[0].getKarteikarte(0);
                JOptionPane.showMessageDialog(null, "Spiel-Modus Start! Übersetze: " + k.getVokabelpaar()[1]);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Keine Karten zum Spielen vorhanden.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Keine Sets vorhanden.");
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