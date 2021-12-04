package DataAccessLayer.Mappers;


import DataAccessLayer.Database;
import Entities.Cladding;
import Entities.Roofing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoofingMapper
{
    private Database database;

    public RoofingMapper(Database database)
    {
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
            String sql = "DELETE FROM roofing WHERE roof_id=?" + roofing.getRoofing_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, roofing.getRoofing_id());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editRoofing(Roofing roofing) {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE roofing SET material_id = ? WHERE roof_id" + roofing.getMaterial_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, roofing.getMaterial_id());
                ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Roofing> getAllRoofing() {
        List<Roofing> roofingList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM roofing";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("roof_id");
                    int material_id = rs.getInt("material_id");
                    Roofing tmpRoofing = new Roofing(id, material_id);
                    roofingList.add(new Roofing(id, tmpRoofing.getMaterial()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roofingList;
    }


    public Roofing receiveRoofingByObject(Roofing paraRoofing) {
        Roofing tmpRoofing = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT material_id FROM roofing WHERE roof_id=" + paraRoofing.getRoofing_id();

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int material_id = rs.getInt("material_id");
                    tmpRoofing = new Roofing(paraRoofing.getRoofing_id(), material_id);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpRoofing;
    }


    public Roofing receiveRoofingById(int roofing_id) {
        Roofing roofing = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM roofing WHERE roof_id=" + roofing_id;

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int id = rs.getInt("roof_id");
                    int material_id = rs.getInt("material_id");
                    roofing = new Roofing(id,material_id);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roofing;
    }
}
