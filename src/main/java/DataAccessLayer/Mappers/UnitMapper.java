package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Unit;
import Entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class UnitMapper
{
    private Database database;

    protected UnitMapper(Database database)
    {
        this.database = database;
    }

    protected void createUnit(Unit unit) throws Exception {
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

    protected void editUser(User user) {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE user SET name=?, address=?,zip_code=?,phone_no=?, email=?, password=MD5(?) WHERE user_id="+user.getUser_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, user.getName());
                ps.setString(2, user.getAddress());
                ps.setString(3, user.getZipCode());
                ps.setString(4, user.getPhoneNumber());
                ps.setString(5, user.getEmail());
                ps.setString(6, user.getPassword());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void deleteUnit(Unit unit) {
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

    protected void editUnit(Unit unit)
    {

    }

    protected Unit getUnit (Unit unit)
    {

        return null;
    }
}
