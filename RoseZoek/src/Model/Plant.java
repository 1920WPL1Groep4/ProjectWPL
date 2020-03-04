package Model;

public class Plant {
    String sNaam;
    String sFamilie;
    String sType;

    public Plant(String sType, String sFamilie) {
        this.sNaam = sType;
        this.sFamilie = sFamilie;
        this.sType = sType;

    }

    public String myToString(){
        String sAnswer = "plantnaam = "+sNaam+ "\r\n"+ "Familie = "+sFamilie+"\r\n"+ "Type = "+sType;
        return sAnswer;
    }
}
