package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class UnitMapper {
    private Database database;

    public UnitMapper(Database database) {
        this.database = database;
    }

    public void createUnit(Unit unit) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO unit(name) values(?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, unit.getName());
                ps.executeUpdate();

            } catch (SQLIntegrityConstraintViolationException e) {
                throw new Exception();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteUnit(Unit unit) {
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM unit WHERE name = ? ";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, unit.getName());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUnit(Unit unit) {

    }

    public Unit getUnit(Unit unit) {

        return null;
    }
}
