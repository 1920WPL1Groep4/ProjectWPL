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
            "SELECT distinct(type) FROM plant";
    private static final String GETALLSORTS =
            "SELECT distinct(soort_naam) FROM soort";
    private static final String GetAllGeslacht =
            "SELECT distinct(GESLACHT_NAAM) FROM GESLACHT";
    private static final String GetAllFamilie =
            "SELECT distinct(familie_naam) FROM familie";
    private static final String GetAllBezonning =
            "select distinct(waarde) from bezonning";
    private static final String GetAllOntwikkeling =
            "select distinct(waarde) from ontwikkelingssnelheid";
    private static final String GetAllLevensDuur =
            "select distinct(waarde) from levensduur_concurrentiekracht";
    private static final String GetAllSociabiliteit =
            "select distinct(waarde) from sociabiliteit";
    private static final String GetallBladvorm =
            "select distinct(waarde) from bladvorm";
    private static final String GetRatio =
            "select distinct(waarde) from ratio_bloeiblad";

    //PreparedStatements die input toelaten om de query aan te vullen
    private static final String GETPLANTSBYNAME =
            "SELECT * FROM plant WHERE fgsv LIKE ? and type like ? and familie like ? and geslacht like ? and soort like ? ";

    private PreparedStatement stmtSelectByName;



    public PlantDao(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectByName = dbConnection.prepareStatement(GETPLANTSBYNAME);
    }
    //alle list voor de comboboxes op te vullen
    //list voor alle types
    public List<String> getAllTypes() {
        List<String> typeList = new ArrayList<>();
        typeList.add(0,"");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLTYPES);
            while (rs.next()) {
              typeList.add(rs.getString("type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeList;
    }
    //list voor alle soorten
    public List<String> getallsoort() {
        List<String> soortlist = new ArrayList<>();
        soortlist.add(0,"");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLSORTS);
            while (rs.next()) {
                soortlist.add(rs.getString("soort_naam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soortlist;
    }
    //LIST VOOR ALLE GESLACHTEN
    public List<String> geslachtsoort() {
    List<String> geslachtlist = new ArrayList<>();
    geslachtlist.add(0,"");
    try {
        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GetAllGeslacht);
        while (rs.next()) {
            geslachtlist.add(rs.getString("geslacht_naam"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return geslachtlist;
}
    //list voor alle familie
    public List<String> getAllFamilie() {
        List<String> FamilieList = new ArrayList<>();
        FamilieList.add(0,"");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GetAllFamilie);
            while (rs.next()) {
                FamilieList.add(rs.getString("familie_naam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FamilieList;
    }
    //list voor bezonning
    public List<String> getBezonning() {
        List<String> bezonningList = new ArrayList<>();
        bezonningList.add(0, "");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GetAllBezonning);
            while (rs.next()) {
                bezonningList.add(rs.getString("waarde"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bezonningList;
    }
    //list voor ontwikkeling
    public List<String> getontwikkeling() {
        List<String> ontwikkelingList = new ArrayList<>();
        ontwikkelingList.add(0, "");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GetAllOntwikkeling);
            while (rs.next()) {
                ontwikkelingList.add(rs.getString("waarde"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ontwikkelingList;
    }
    //list voor levensduur
    public List<String> GetLevensduur() {
        List<String> LevensduurList = new ArrayList<>();
        LevensduurList.add(0, "");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GetAllLevensDuur);
            while (rs.next()) {
                LevensduurList.add(rs.getString("waarde"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return LevensduurList;
    }
    //list voor sociabiliteit
    public List<String> GetSociabiliteit() {
        List<String> SociabiliteitList = new ArrayList<>();
        SociabiliteitList.add(0, "");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GetAllSociabiliteit);
            while (rs.next()) {
                SociabiliteitList.add(rs.getString("waarde"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SociabiliteitList;
    }
    //list voor de bladvormen
    public List<String> getBladVorm() {
        List<String> BladvormList = new ArrayList<>();
        BladvormList.add(0, "");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GetallBladvorm);
            while (rs.next()) {
                BladvormList.add(rs.getString("waarde"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return BladvormList;
    }
    //list voor ratio
    public List<String> getRatio() {
        List<String> RatioList = new ArrayList<>();
        RatioList.add(0, "");
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GetRatio);
            while (rs.next()) {
                RatioList.add(rs.getString("waarde"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return RatioList;
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
