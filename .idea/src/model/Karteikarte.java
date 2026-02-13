package model;

public class Karteikarte{
    private String[] vokabelpaar = new String[2];  //immer in dem Format gespeichert: deutsch, englisch
    //Bild zur Karteikarte als Link aus dem Internet


    public Karteikarte(String[] vokabelpaar) throws Exception {
        setVokabelpaar(vokabelpaar);
    }

    public Karteikarte(String deutsch, String englsich) throws Exception {
        setDeutsch(deutsch);
        setEnglisch(englsich);
    }

    public Karteikarte(){

    }

    public String[] getVokabelpaar() {
        return vokabelpaar;
    }

    public void setDeutsch(String deutsch) throws Exception {
        if(deutsch != null && !deutsch.isEmpty()){
            if(this.vokabelpaar[0] == null){
                this.vokabelpaar[0] = deutsch; //erste stelle im array ist immer deutsch
            }else{
                throw new Exception("Deutsches Wort wurde bereits festgelegt");
            }
        }
    }

    public void setEnglisch(String englisch) throws Exception {
        if(englisch != null && !englisch.isEmpty()){
            if(this.vokabelpaar[1] == null){
                this.vokabelpaar[1] = englisch; //zweite stelle im array ist immer englisch
            }else{
                throw new Exception("Englischer Begriff wurde schon festgelegt");
            }
        }
    }

    public void setVokabelpaar(String[] vokabelpaar) throws Exception {
        if(vokabelpaar != null){
            for(int i = 0; i < 2; i++){
                if(vokabelpaar[i] != null){
                    throw new Exception("Vokabelpaar bereits fetgelegt");
                }
            }
            this.vokabelpaar = vokabelpaar; //wenn alle null waren wird es übernommen
        }
    }

}
