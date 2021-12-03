package DataAccessLayer.Mappers;


import DataAccessLayer.Database;
import Entities.Roofing;

import java.sql.*;

public class RoofingMapper {
    private Database database;

    public RoofingMapper(Database database) {
        this.database = database;
    }

    public void createRoofing(Roofing roofing) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO roofing(material_id) value(?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, roofing.getMaterial_id());
                ps.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void deleteRoofing(Roofing roofing) {
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM roofing WHERE roof_id=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, roofing.getRoofing_id());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editRoofing(Roofing roofing) {

    }

    public Roofing recevieRoofing(Roofing roofing) {
        try (Connection connection = database.connect()) {
            String sql = "SELECT material_id FROM roofing WHERE roof_id=" + roofing.getRoofing_id();
            System.out.println(roofing.getRoofing_id());
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int material_id = rs.getInt("material_id");
                   // System.out.println(material_id);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roofing;
    }
}
