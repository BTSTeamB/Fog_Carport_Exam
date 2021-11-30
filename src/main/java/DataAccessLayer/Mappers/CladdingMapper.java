package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Cladding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class CladdingMapper {
    private Database database;

    public CladdingMapper(Database database) {
        this.database = database;
    }

    public void createCladding(Cladding cladding) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO cladding(material_id) value(?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, cladding.getMaterial_id());
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                throw new Exception();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteCladding(Cladding cladding) {

    }

    public void editCladding(Cladding cladding) {

    }

    public Cladding getCladding(Cladding cladding) {

        return null;
    }

}
