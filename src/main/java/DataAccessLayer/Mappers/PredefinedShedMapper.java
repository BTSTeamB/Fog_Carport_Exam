package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.PredefinedCarport;
import Entities.PredefinedShed;
import Entities.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PredefinedShedMapper {
    Database database;

    public PredefinedShedMapper(Database database) {
        this.database = database;
    }

    public void createPredefinedShed(PredefinedShed predefinedShed) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO predefined_shed(width,length) values(?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, predefinedShed.getWidth());
                ps.setInt(2, predefinedShed.getLength());
                ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editPredefinedShed(PredefinedShed predefinedShed) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE predefiend_shed SET width=?,length=? WHERE id=" + predefinedShed.getId();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, predefinedShed.getWidth());
                ps.setInt(2, predefinedShed.getLength());
                ps.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletePredefinedShed(PredefinedShed predefinedShed) {
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM predefined_shed WHERE id=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, predefinedShed.getId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}