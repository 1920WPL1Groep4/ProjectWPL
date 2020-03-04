package Controller;

import dao.Database;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.sql.*;

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


    private Connection dbconnection;
    //Statement is static zoals hier prepared statement is dynamisch en laat dus toe waarden in te brengen om op te zoeken
    private PreparedStatement stmtselectbyid;

    public Controller() throws SQLException {
        dbconnection = Database.getInstance().getConnection();
        System.out.println("ok");
        System.out.println(dbconnection);

    }

    //Button die ervoorzorgt dat er een zoek resultaat wordt weergegeven in de textarea
    public void clicked_Zoeken(MouseEvent mouseEvent) {

    }

    public void clicked_Achterwaards(MouseEvent mouseEvent) {
    }

    public void clicked_Voorwaards(MouseEvent mouseEvent) {
    }
}

