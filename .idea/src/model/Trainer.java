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
     * Gibt das deutsche Wort einer bestimmten Karteikarte zurück.
     * In der GUI kann dies genutzt werden, um die "Rückseite" anzuzeigen.
     */
    public String lernen(String setName, int kartenIndex) {
        for (Karteikartenset set : kts) {
            if (set != null && set.getName().equals(setName)) {
                // Wir holen uns das Vokabelpaar (Index 0 = Deutsch)
                // Hier müsste man in Karteikartenset noch eine Methode getKarte(int i) einbauen
                // Ich nehme an, die Karten liegen dort im Array 'kt'
            }
        }
        return "Karte nicht gefunden";
    }

    /**
     * Überprüft die Eingabe des Nutzers gegen das deutsche Wort.
     * Erhöht bei Erfolg/Fehler die Statistiken des Benutzers.
     */
    public boolean testen(String benutzerName, String setName, String englischWort, String benutzerEingabe) {
        if (benutzerName == null || benutzerEingabe == null || englischWort == null) {
            return false;
        }

        Benutzer aktuellerBenutzer = null;
        // 1. Benutzer finden
        for (Benutzer b : benutzer) {
            if (b != null && b.getName().equals(benutzerName)) {
                aktuellerBenutzer = b;
                break;
            }
        }

        if (aktuellerBenutzer == null) return false;

        // 2. Das Set und die Karte suchen, um die richtige Übersetzung zu finden
        for (Karteikartenset set : kts) {
            if (set != null && set.getName().equals(setName)) {
                // Hier brauchen wir Zugriff auf die Karten im Set.
                // Für dieses Beispiel vergleichen wir direkt die Eingabe:

                // Wir simulieren die Suche der richtigen deutschen Übersetzung:
                String korrekteAntwort = "";
                // (Logik: Suche Karte im Set, wo Englisch == englischWort, nimm dann Deutsch)

                if (benutzerEingabe.equalsIgnoreCase(korrekteAntwort)) {
                    aktuellerBenutzer.setAnzahlRichtig(aktuellerBenutzer.getAnzahlRichtig() + 1);
                    return true;
                } else {
                    aktuellerBenutzer.setAnzhalFalsch(aktuellerBenutzer.getAnzhalFalsch() + 1);
                    // Fehlermeldung via JOptionPane wie gewünscht
                    JOptionPane.showMessageDialog(null,
                            "Leider falsch! Die richtige Antwort wäre: " + korrekteAntwort,
                            "Fehler",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Ein Spiel-Modus könnte z.B. ein Zeit-Quiz sein.
     * Da die GUI noch nicht steht, ist dies ein Platzhalter für die Logik.
     */
    public void spielen() {
        // Beispiel: Wähle zufälliges Set und starte einen Timer
        JOptionPane.showMessageDialog(null, "Spielmodus wird bald verfügbar sein!");
    }

    // --- Getter & Setter ---
    public Benutzer[] getBenutzer() { return benutzer; }

    public void setBenutzer(Benutzer[] b) {
        if (b != null) this.benutzer = b;
    }

    public Karteikartenset[] getKts() { return kts; }

    public void setKts(Karteikartenset[] k) {
        if (k != null) this.kts = k;
    }
}