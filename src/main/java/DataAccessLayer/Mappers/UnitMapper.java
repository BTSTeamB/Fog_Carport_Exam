package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Unit;

import java.sql.*;

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
        try (Connection connection = database.connect()) {
            String sql = "UPDATE unit SET name=?, WHERE id" + unit.getUnit_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, unit.getName());
                ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Unit recevieUnit(Unit unit) {
        try (Connection connection = database.connect()) {
            String sql = "SELECT name FROM unit WHERE unit_id="+unit.getUnit_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    String name = rs.getString("name");
                    System.out.println(name);
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return unit;
    }
}
