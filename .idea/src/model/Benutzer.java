package model;

public class Benutzer {
    private String name = "DefaultName";
    private String pw;
    private int anzahlRichtig = 0;
    private int anzhalFalsch = 0;
    private double qoute = ( (anzahlRichtig+anzhalFalsch) / (anzahlRichtig) )*100; //Berechnet immer die Quote vom letzten vollendeten "Testen". Nach jedem Ende des Testvorgangs wird die Quote neu angezeigt.
    //so brauchen wir keine quotenberechnung nach jedem mal lernen sondern wenn die richtigen und flaschen aktualisiert werden wird die quote einfach jedes mal neu gegettet und somit ist die quote aktuell

    //Weil jeder Benutzer seine eigenen Karteikartensets hat und aber auch 3 Default sets
    private Karteikartenset[] kts = new Karteikartenset[20]; //Jeder User kann 20 Sets erstellen

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
        // 1. Economics Set (10 Vokabeln)
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

        // 2. Food Set (10 Vokabeln)
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

        // 3. Leisure Set (10 Vokabeln)
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
        if(neu != null) {
            for(int i = 0; i < kts.length; i ++){
                if (kts[i] == null){
                    kts[i] = neu;
                }
            }
        }else{
            throw new Exception("Maximale Anzahl an Karteikartensets erreicht (max 20 möglich)");
        }
    }

    public void setName(String name) {
        if(!name.isEmpty() && name != null) {
            this.name = name;
        }
    }

    public void setPw(String pw) {
        if(!pw.isEmpty() && pw != null) {
            this.pw = pw;
        }    }

    public void setAnzahlRichtig(int anzahlRichtig) {
        if(anzahlRichtig >= 0){
            this.anzahlRichtig = anzahlRichtig;
        }
        //else fehöer - exception
    }

    public void setAnzhalFalsch(int anzhalFalsch) {
        if(anzhalFalsch >= 0){
            this.anzhalFalsch = anzhalFalsch;
        }
    }

    public String getName() {
        return name;
    }

    public String getPw() {
        return pw;
    }

    public int getAnzahlRichtig() {
        return anzahlRichtig;
    }

    public int getAnzhalFalsch() {
        return anzhalFalsch;
    }

    public double getQoute() {
        return qoute;
    }
}
