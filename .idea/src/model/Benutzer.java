package model;

public class Benutzer {
    private String name = "DefaultName";
    private String pw;
    private int anzahlRichtig = 0;
    private int anzhalFalsch = 0;
    private Karteikartenset[] kts = new Karteikartenset[20];

    public Benutzer(String name, String pw) throws Exception {
        setName(name);
        setPw(pw);
        erzeugeStandardSets();
    }

    public Benutzer() throws Exception {
        setName("AutomatischerBenutzer");
        setPw("AutomatischerBenutzer");
        erzeugeStandardSets();
    }

    private void erzeugeStandardSets() throws Exception {
        Karteikartenset economics = new Karteikartenset("Economics");
        economics.karteikarteHinzufuegen(new Karteikarte("Wirtschaft", "Economics"));
        economics.karteikarteHinzufuegen(new Karteikarte("Angebot", "Supply"));
        economics.karteikarteHinzufuegen(new Karteikarte("Nachfrage", "Demand"));
        economics.karteikarteHinzufuegen(new Karteikarte("Markt", "Market"));
        economics.karteikarteHinzufuegen(new Karteikarte("Gewinn", "Profit"));
        economics.karteikarteHinzufuegen(new Karteikarte("Verlust", "Loss"));
        economics.karteikarteHinzufuegen(new Karteikarte("Steuer", "Tax"));
        economics.karteikarteHinzufuegen(new Karteikarte("Währung", "Currency"));
        economics.karteikarteHinzufuegen(new Karteikarte("Zinsen", "Interest"));
        economics.karteikarteHinzufuegen(new Karteikarte("Aktien", "Stocks"));
        ktsHinzufuegen(economics);

        Karteikartenset food = new Karteikartenset("Food");
        food.karteikarteHinzufuegen(new Karteikarte("Essen", "Food"));
        food.karteikarteHinzufuegen(new Karteikarte("Frühstück", "Breakfast"));
        food.karteikarteHinzufuegen(new Karteikarte("Mittagessen", "Lunch"));
        food.karteikarteHinzufuegen(new Karteikarte("Abendessen", "Dinner"));
        food.karteikarteHinzufuegen(new Karteikarte("Gemüse", "Vegetables"));
        food.karteikarteHinzufuegen(new Karteikarte("Obst", "Fruit"));
        food.karteikarteHinzufuegen(new Karteikarte("Fleisch", "Meat"));
        food.karteikarteHinzufuegen(new Karteikarte("Getränk", "Beverage"));
        food.karteikarteHinzufuegen(new Karteikarte("Rezept", "Recipe"));
        food.karteikarteHinzufuegen(new Karteikarte("Zutaten", "Ingredients"));
        ktsHinzufuegen(food);

        Karteikartenset leisure = new Karteikartenset("Leisure");
        leisure.karteikarteHinzufuegen(new Karteikarte("Freizeit", "Leisure"));
        leisure.karteikarteHinzufuegen(new Karteikarte("Hobby", "Hobby"));
        leisure.karteikarteHinzufuegen(new Karteikarte("Urlaub", "Vacation"));
        leisure.karteikarteHinzufuegen(new Karteikarte("Sport", "Sports"));
        leisure.karteikarteHinzufuegen(new Karteikarte("Unterhaltung", "Entertainment"));
        leisure.karteikarteHinzufuegen(new Karteikarte("Reisen", "Traveling"));
        leisure.karteikarteHinzufuegen(new Karteikarte("Ausflug", "Excursion"));
        leisure.karteikarteHinzufuegen(new Karteikarte("Entspannung", "Relaxation"));
        leisure.karteikarteHinzufuegen(new Karteikarte("Verein", "Club"));
        leisure.karteikarteHinzufuegen(new Karteikarte("Kino", "Cinema"));
        ktsHinzufuegen(leisure);
    }

    public void ktsHinzufuegen(Karteikartenset neu) throws Exception {
        if (neu != null) {
            for (int i = 0; i < kts.length; i++) {
                if (kts[i] == null) {
                    kts[i] = neu;
                    return; // Wichtig Nur einmal hinzufügen
                }
            }
        }
    }

    public double getQoute() {
        int gesamt = anzahlRichtig + anzhalFalsch;
        if (gesamt == 0) return 0.0;
        return ((double) anzahlRichtig / gesamt) * 100;
    }

    public void setName(String name) { if (name != null && !name.isEmpty()) this.name = name; }
    public void setPw(String pw) { if (pw != null && !pw.isEmpty()) this.pw = pw; }
    public String getName() { return name; }
    public String getPw() { return pw; }
    public int getAnzahlRichtig() { return anzahlRichtig; }
    public void setAnzahlRichtig(int r) { this.anzahlRichtig = r; }
    public int getAnzhalFalsch() { return anzhalFalsch; }
    public void setAnzhalFalsch(int f) { this.anzhalFalsch = f; }
    public Karteikartenset[] getKts() { return kts; }
}