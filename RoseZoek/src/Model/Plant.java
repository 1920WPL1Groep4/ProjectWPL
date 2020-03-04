package Model;

public class Plant {
    String sType;
    String sFamilie;

    public Plant(String sType, String sFamilie) {
        this.sType = sType;
        this.sFamilie = sFamilie;
    }

    public String myToString(){
        String sAnswer = "type = "+sType+ "\r\n"+ "Familie = "+sFamilie;

        return sAnswer;
    }
}
