package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class MaterialMapper {
    private Database database;

    public MaterialMapper(Database database) {
        this.database = database;
    }

    public void createMaterial(Material material) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO material(name,description,price,unit_id,length,height,width) value(?,?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, material.getName());
                ps.setString(2, material.getDescription());
                ps.setDouble(3, material.getPrice());
                ps.setInt(4, material.getUnit_id());
                ps.setDouble(5, material.getLength());
                ps.setDouble(6, material.getHeight());
                ps.setDouble(7, material.getWidth());
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                throw new Exception();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteMaterial(Material material) {

    }

    public void editMaterial(Material material) {

    }

    public Material getMaterial(Material material) {

        return null;
    }
}
