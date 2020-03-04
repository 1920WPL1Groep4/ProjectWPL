package dao;

import Model.Plant;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlantDao {
    private Connection dbConnection;

    //Statements waar geen externe input aan te pas komt
    private static final String GETALLPLANTS =
            "SELECT * FROM Combined";


    //PreparedStatements die input toelaten om de query aan te vullen
    private static final String GETPLANTSBYNAME =
            "SELECT * FROM Combined WHERE plantnaam LIKE ? " +
                    "and Familienaam like ? " +
                    "and groep like ?";


    private PreparedStatement stmtSelectByName;


    public PlantDao(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectByName = dbConnection.prepareStatement(GETPLANTSBYNAME);
    }

    public List<Plant> getAllPlants() {
        List<Plant> plantList = new ArrayList<>();
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLPLANTS);
            while (rs.next()) {
                Plant plantje = new Plant(rs.getString("plantnaam"), rs.getString("Familienaam"));
                plantList.add(plantje);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plantList;
    }


    public List<Plant> getAllStartingByName(String naam) throws SQLException {
        List<Plant> plantList = new LinkedList<>();
        stmtSelectByName.setString(1, "%" + naam + "%");
        stmtSelectByName.setString(2, "%" + naam + "%");
        stmtSelectByName.setString(3, "%" + naam + "%");
        ResultSet rs = stmtSelectByName.executeQuery();
        while (rs.next()) {
            Plant plantje = new Plant(rs.getString("plantnaam"), rs.getString("Familienaam"));
            plantList.add(plantje);
        }
        return plantList;
    }

}
