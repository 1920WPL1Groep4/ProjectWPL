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
    private static final String GETALLTYPES =
            "SELECT type_naam FROM type";


    //PreparedStatements die input toelaten om de query aan te vullen
    private static final String GETPLANTSBYNAME =
            "SELECT * FROM plant WHERE fgsv LIKE ? and type like ? and familie like ? and geslacht like ? and soort like ? ";

    private PreparedStatement stmtSelectByName;



    public PlantDao(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectByName = dbConnection.prepareStatement(GETPLANTSBYNAME);
    }

    public List<String> getAllTypes() {
        List<String> typeList = new ArrayList<>();
        typeList.add(0,"");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLTYPES);
            while (rs.next()) {
              typeList.add(rs.getString("type_naam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeList;
    }


    public List<Plant> getAllStartingByName(String naam, String type, String familie, String geslacht,String soort) throws SQLException {
        List<Plant> plantList = new LinkedList<>();
        stmtSelectByName.setString(1, "%" + naam + "%");
        stmtSelectByName.setString(2, "%" + type + "%");
        stmtSelectByName.setString(3, "%" + familie + "%");
        stmtSelectByName.setString(4, "%" + geslacht + "%");
        stmtSelectByName.setString(5, "%" + soort + "%");
        ResultSet rs = stmtSelectByName.executeQuery();
        while (rs.next()) {
            Plant plantje = new Plant(rs.getString("fgsv"), rs.getString("familie"), rs.getString("type"));
            plantList.add(plantje);
        }
        return plantList;
    }







  /*  public List<Plant> getAllPlants() {
        List<Plant> plantList = new ArrayList<>();
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLPLANTS);
            while (rs.next()) {
                Plant plantje = new Plant(rs.getString("fgsv"), rs.getString("familie"), rs.getString("type"));
                plantList.add(plantje);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plantList;
    }
*/
}
