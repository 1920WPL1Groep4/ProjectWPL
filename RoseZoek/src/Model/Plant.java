package Model;

public class Plant {
    String sNaam;
    String sFamilie;

    public Plant(String sType, String sFamilie) {
        this.sNaam = sType;
        this.sFamilie = sFamilie;
    }

    public String myToString(){
        String sAnswer = "type = "+sNaam+ "\r\n"+ "Familie = "+sFamilie;

        return sAnswer;
    }
}
