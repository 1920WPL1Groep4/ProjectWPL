package Controller;

import dbo.Database;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.sql.*;

public class Controller {
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
    public TextField txtPlant;


    private Connection dbconnection;
    //Statement is static zoals hier prepared statement is dynamisch en laat dus toe waarden in te brengen om op te zoeken
    private PreparedStatement stmtselectbyid;

    public Controller() throws SQLException {
        dbconnection = Database.getInstance().getConnection();
        System.out.println("ok");
        System.out.println(dbconnection);

    }

    public void btn(ActionEvent actionEvent) {
        System.out.println("just for testing purposes");
    }

    //Button die ervoor zorgt dat er een zoek resultaat wordt weergegeven in de textarea
    public void clicked_Zoeken(MouseEvent mouseEvent) {
    }

    //Gaat een plant terug wanneer er op de button btnAchterwaards gedrukt wordt.
    public void clicked_Achterwaards(MouseEvent mouseEvent) {
    }

    //Gaat een plant naar voor wanneer er op de button btnVoorwaards gedrukt wordt.
    public void clicked_Voorwaards(MouseEvent mouseEvent) {
    }
}

