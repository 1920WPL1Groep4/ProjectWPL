package Model;

public class Plant {
    String sNaam;
    String sType;
    String sFamilie;
    String sGeslacht;
    String sSoort;
    String sVariant;

    public Plant(String sNaam, String sType, String sFamilie) {
        this.sNaam = sNaam;
        this.sType = sType;
        this.sFamilie = sFamilie;
        this.sGeslacht = sGeslacht;
        this.sSoort = sSoort;
        this.sVariant = sVariant;
    }

    //functie geoffrey
    public String myToString() {
        String sAnswer = "plantnaam = " + sNaam + "\r\n" + "Familie = " + sFamilie + "\r\n" + "Type = " + sType;
        return sAnswer;
    }

    //functie bram
    public String MyPlantNameToString() {
        String sAnswer = "plantnaam: " + sNaam;
        return sAnswer;
    }

    ;

}
