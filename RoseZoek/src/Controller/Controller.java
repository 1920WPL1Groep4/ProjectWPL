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

    //Dit zijn de namen van de labels van plant, type, familie, geslacht en soort.
    public Label lblPlant;
    public Label lblType;
    public Label lblFamilie;
    public Label lblGelsacht;
    public Label lblSoort;

    //Dit zijn de namen van de spinners van soort, geslacht, familie en type.
    public Spinner sSoort;
    public Spinner sGeslacht;
    public Spinner sFamilie;
    public Spinner sType;

    //Dit is de naam van de textarea waar de uitkomst van de zoek opdracht getoont wordt.
    public TextArea txtUitkomst;

    //Dit zijn de namen van de button.
    public Button btnZoeken;
    public Button btnAchterwaards;
    public Button btnVoorwaards;
    public TextField txtPlant;
    public List<Plant> plantjes;

    private Connection dbconnection;
    //Statement is static zoals hier prepared statement is dynamisch en laat dus toe waarden in te brengen om op te zoeken
    private PreparedStatement stmtselectbyid;

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
        List<Plant> plantjes = plantDao.getAllStartingByName(sRequest);
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
        }

    }

    public void clicked_Achterwaards(MouseEvent mouseEvent) {
    }

    public void clicked_Voorwaards(MouseEvent mouseEvent) {
    }

    public void refreshRecords(List<Plant> plantjes) {
        System.out.println(plantjes.size());
    }

    public void longWaitingTimesWarning() {
        JOptionPane.showMessageDialog(null, "deze zoekfunctie kan meer tijd in beslag nemen dan gewoonlijk. Dank u voor u geduld.");
    }
}

