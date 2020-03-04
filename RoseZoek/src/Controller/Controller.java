package Controller;

import Model.Plant;
import dao.Database;
import dao.PlantDao;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class Controller {
    //Index i
    int i;
    public Label lblPlantResultaat; //Label naam waar het resultaat

    public Spinner sType;       //Spinner naam voor het type van de plant.
    public Spinner sFamilie;    //Spinner naam voor de familie van de plant.
    public Spinner sGeslacht;   //Spinner naam voor het geslacht van de plant.
    public Spinner sSoort;      //Spinner naam voor de soort van de plant.

    public TextArea txtUitkomst;    //Dit is de naam van de textarea waar de uitkomst van de zoek opdracht getoont wordt.

    public Button btnZoeken;        //Button naam voor de button zoeken.
    public Button btnAchterwaards;  //Button naam voor de button achterwaards.
    public Button btnVoorwaards;    //Button naam voor de button Voorwaards.

    public TitledPane tlpExtraEigenschappen;    //TitlePane voor de extra eigenschappen waar opgezocht kan worden.
    public TextField txtPlant;

    //array van object plant
    public List<Plant> plantjes;

    public ComboBox cmbbBezonning;          //Combox naam voor bezonning.
    public ComboBox cmbbOntwikkelingsS;     //Combox naam voor ontwikkelingssnelheid.
    public ComboBox cmbbSociabiliteit;      //Combox naam voor sociabiliteit.
    public ComboBox cmbbLevensduur;         //Combox naam voor levensduus.
    public ComboBox cmbbBladvorm;           //Combox naam voor bladvorm.
    public ComboBox cmbbRatio;              //Combox naam voor ratio bloei en blad.
    public ComboBox cmbbSpruitfenologie;    //Combox naam voor spruitfenologie.
    public ComboBox cmbbGrondstof;          //Combox naam voor grondstof.
    public ComboBox cmbbVochtbehoefte;      //Combox naam voor vochtbehoefte.
    public ComboBox cmbbVoedingsbehoefte;   //Combox naam voor voedingsbehoefte.


    private Connection dbconnection;

    public Controller() throws SQLException {
        dbconnection = Database.getInstance().getConnection();
        System.out.println("ok");
        System.out.println(dbconnection);

    }

    //Button die ervoorzorgt dat er een zoek resultaat wordt weergegeven in de textarea
    public void clicked_Zoeken(MouseEvent mouseEvent) throws SQLException {
        txtUitkomst.clear();
        String sRequest = String.valueOf(txtPlant.getText());
        dao.PlantDao plantDao = new PlantDao(dbconnection);
        plantjes = plantDao.getAllStartingByName(sRequest);
        refreshRecords(plantjes);

        if (txtPlant.getText().equals("") && plantjes.size() > 1000) {
            longWaitingTimesWarning();
        }
        for (Plant plantje : plantjes
        ) {
            txtUitkomst.setText(txtUitkomst.getText() + plantje.myToString() + "\r\n");
        }
        if (plantjes.size() == 0) {
            txtUitkomst.setText("Geen planten gevonden");
            JOptionPane.showMessageDialog(null, "Geen planten gevonden");
        } else {
            btnAchterwaards.setDisable(false);
            btnVoorwaards.setDisable(false);
            i = 0;
        }

    }

    //Gaat een plant terug wanneer er op de button btnAchterwaards gedrukt wordt.
    public void clicked_Achterwaards(MouseEvent mouseEvent) {
        i--;
        if (i < 0) {
            i = plantjes.size()-1;
        }
        plantjes.get(i);
    }

    //Gaat een plant naar voor wanneer er op de button btnVoorwaards gedrukt wordt.
    public void clicked_Voorwaards(MouseEvent mouseEvent) {
        i++;
        if (i > plantjes.size()) {
            i = 0;
        }
        plantjes.get(i);
    }

    public void refreshRecords(List<Plant> plantjes) {
        System.out.println(plantjes.size());
    }

    public void longWaitingTimesWarning() {
        JOptionPane.showMessageDialog(null, "deze zoekfunctie kan meer tijd in beslag nemen dan gewoonlijk. Dank u voor u geduld.");
    }
}

