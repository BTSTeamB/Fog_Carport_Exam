package DataAccessLayer.Mappers;


import DataAccessLayer.Database;
import PresentationLayer.Entities.Roofing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoofingMapper
{
    private Database database;

    protected RoofingMapper(Database database)
    {
        this.database = database;
    }

    protected void createRoofing(Roofing roofing) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO roofing(material_id) value(?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, roofing.getType());
                ps.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    protected void deleteRoofing(Roofing roofing) {
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

    protected void editRoofing(Roofing roofing) {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE roofing SET material_id="+roofing.getType()+" WHERE roof_id="+ roofing.getRoofing_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, roofing.getType());
                ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected List<Roofing> getAllRoofing() {
        List<Roofing> roofingList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM roofing";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("roof_id");
                    String type = rs.getString("type");
                    Roofing tmpRoofing = new Roofing(id, type);
                    roofingList.add(new Roofing(id, tmpRoofing.getType()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roofingList;
    }


    protected Roofing receiveRoofingByObject(Roofing paraRoofing) {
        Roofing tmpRoofing = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT type FROM roofing WHERE roof_id=" + paraRoofing.getRoofing_id();

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    String type = rs.getString("type");
                    tmpRoofing = new Roofing(paraRoofing.getRoofing_id(), type);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpRoofing;
    }


    protected Roofing receiveRoofingById(int roofing_id) {
        Roofing roofing = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM roofing WHERE roof_id=" + roofing_id;

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int id = rs.getInt("roof_id");
                    String type = rs.getString("type");
                    roofing = new Roofing(id,type);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roofing;
    }
}
