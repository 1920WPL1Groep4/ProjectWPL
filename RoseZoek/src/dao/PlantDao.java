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

    String sTFGSV;
    //statements voor het opvullen van de Dropdowns

    //Statements waar geen externe input aan te pas komt
    private static final String GETALLTYPESDD =
            "SELECT type_naam FROM type ";
    private static final String GETALLFAMDD =
            "SELECT Distinct familie_naam FROM familie ";
    private static final String GETALLGESLACHTDD =
            "SELECT Distinct geslacht_naam FROM geslacht ";
    private static final String GETALLSOORTDD =
            "SELECT Distinct soort_id FROM soort ";


    //PreparedStatements die input toelaten om de query aan te vullen
    private static final String GETPLANTSBYNAME =
            "SELECT * FROM plant WHERE fgsv LIKE ? and type like ? and familie like ? and geslacht like ? and soort like ? ";
    private static final String GETPLANTSBYFGSV =
            "SELECT ? FROM ? WHERE ? = ?";

    private PreparedStatement stmtSelectByName;
    private PreparedStatement stmtSelectByFgsv;

    public PlantDao(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectByName = dbConnection.prepareStatement(GETPLANTSBYNAME);
        stmtSelectByFgsv= dbConnection.prepareStatement(GETPLANTSBYFGSV);
    }


    //DROPDOWNS
    public List<String> getAllTypes() {
        List<String> typeList = new ArrayList<>();
        typeList.add(0, "");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLTYPESDD);
            while (rs.next()) {
                typeList.add(rs.getString("type_naam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeList;
    }

    public List<String> getAllFams() {

        List<String> famList = new ArrayList<>();
        famList.add(0, "");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLFAMDD);
            while (rs.next()) {
                famList.add(rs.getString("familie_naam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return famList;
    }

    public List<String> getAllGeslacht() {

        List<String> gesList = new ArrayList<>();
        gesList.add(0, "");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLGESLACHTDD);
            while (rs.next()) {
                gesList.add(rs.getString("geslacht_naam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gesList;
    }

    public List<String> getAllSoort() {

        List<String> soortList = new ArrayList<>();
        soortList.add(0, "");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLSOORTDD);
            while (rs.next()) {
                soortList.add(rs.getString("soort_naam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soortList;
    }

    public List<Plant> getAllStartingByName(String naam, String type, String familie, String geslacht, String soort) throws SQLException {
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
    public List<Plant> getDropDownResearch(String Column, String Value, String Result) throws SQLException {
        List<Plant> plantList = new LinkedList<>();
        stmtSelectByName.setString(1, Column);
        stmtSelectByName.setString(2, Value);
        stmtSelectByName.setString(3, Result);

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
