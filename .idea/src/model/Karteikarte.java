package model;

public class Karteikarte{
    private String[] vokabelpaar = new String[2];  //immer in dem Format gespeichert: deutsch, englisch
    //Bild zur Karteikarte als Link aus dem Internet


    public Karteikarte(String[] vokabelpaar, String name) {
        this.vokabelpaar = vokabelpaar;
    }

    public String[] getVokabelpaar() {
        return vokabelpaar;
    }

    public void setDeutsch(String deutsch){
        if(deutsch != null && !deutsch.isEmpty()){
            this.vokabelpaar[0] = deutsch; //erste stelle im array ist immer englisch
        }
    }

    public void setEnglisch(String englisch){
        if(englisch != null && !englisch.isEmpty()){
            this.vokabelpaar[1] = englisch; //zweite stelle im array ist immer englisch
        }
    }
    public void setVokabelpaar(String[] vokabelpaar) {
        this.vokabelpaar = vokabelpaar;
    }

}
