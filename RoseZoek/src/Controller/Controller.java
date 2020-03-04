package Controller;

import dbo.Database;
import javafx.event.ActionEvent;

import java.sql.*;

public class Controller {


    private Connection dbconnection;
    //Statement is static zoals hier prepared statement is dynamisch en laat dus toe waarden in te brengen om op te zoeken
    private PreparedStatement stmtselectbyid;

    public Controller() throws SQLException {
        dbconnection = Database.getInstance().getConnection();
        System.out.println("ok");
        System.out.println(dbconnection);

    }
    

    public void btnSearchAll(ActionEvent actionEvent) {
        System.out.println("just for testing purposes");
    }
}

