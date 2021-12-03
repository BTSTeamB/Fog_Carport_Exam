package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Cladding;
import Entities.Roofing;

import java.sql.*;

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


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void deleteCladding(Cladding cladding) {
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM cladding WHERE cladding_id=?" + cladding.getCladding_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, cladding.getCladding_id());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editCladding(Cladding cladding) {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE cladding SET material_id = ? WHERE cladding_id="+cladding.getCladding_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, cladding.getMaterial_id());
                ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Cladding recevieCladding(Cladding cladding) {
        try (Connection connection = database.connect()) {
            String sql = "SELECT material_id FROM cladding WHERE cladding_id=" + cladding.getCladding_id();

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int material_id = rs.getInt("material_id");

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cladding;
    }

}
