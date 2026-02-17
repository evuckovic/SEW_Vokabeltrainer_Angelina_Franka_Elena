package model;

public class Trainer {

    private Benutzer[] benutzer;
    private Karteikartenset[] kts;

    public Trainer(Benutzer[] b, Karteikartenset[] k) {
        this.benutzer = b;
        this.kts = k;
    }

    // Deutsches Wort holen
    public String lernen(String setName, int index) {

        for (Karteikartenset set : kts) {
            if (set != null && set.getName().equals(setName)) {

                try {
                    Karteikarte k = set.getKarteikarte(index);
                    return k.getVokabelpaar()[0]; // Deutsch
                } catch (Exception e) {
                    return "Karte nicht gefunden";
                }
            }
        }

        return "Set nicht gefunden";
    }

    // Englisches Wort holen
    public String lernenEnglisch(String setName, int index) {

        for (Karteikartenset set : kts) {
            if (set != null && set.getName().equals(setName)) {

                try {
                    Karteikarte k = set.getKarteikarte(index);
                    return k.getVokabelpaar()[1]; // Englisch
                } catch (Exception e) {
                    return null;
                }
            }
        }

        return null;
    }

    // Nur Vergleich – KEINE Punkte hier zählen!
    public boolean pruefen(String setName, int index, String eingabe) {

        String korrekt = lernenEnglisch(setName, index);

        if (korrekt == null) return false;

        return eingabe != null && eingabe.equalsIgnoreCase(korrekt);
    }

    public Benutzer[] getBenutzer() {
        return benutzer;
    }

    public Karteikartenset[] getKts() {
        return kts;
    }

    public void setKts(Karteikartenset[] kts) {
        this.kts = kts;
    }

    public int getAnzahlKarten(String setName) {

        for (Karteikartenset set : kts) {
            if (set != null && set.getName().equals(setName)) {

                int count = 0;

                while (true) {
                    try {
                        set.getKarteikarte(count);
                        count++;
                    } catch (Exception e) {
                        break;
                    }
                }

                return count;
            }
        }

        return 0;
    }

}
