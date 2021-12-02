package DataAccessLayer.Mappers;


import DataAccessLayer.Database;
import Entities.Roofing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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

    }

    public void editRoofing(Roofing roofing) {

    }

    public Roofing getRoofing(Roofing roofing) {

        return null;
    }
}
