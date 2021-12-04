package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Cladding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CladdingMapper
{
    private Database database;

    public CladdingMapper(Database database)
    {
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

    public Cladding receiveCladdingByObject(Cladding paraCladding) {
        Cladding tmpCladding = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT material_id FROM cladding WHERE cladding_id=" +paraCladding.getCladding_id();

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int material_id = rs.getInt("material_id");
                    tmpCladding = new Cladding(paraCladding.getCladding_id(), material_id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tmpCladding;
    }

    public Cladding receiveCladdingById(int claddingId) {
        Cladding cladding = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cladding WHERE cladding_id=" + claddingId;

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int id = rs.getInt("cladding_id");
                    int material_id = rs.getInt("material_id");
                    cladding = new Cladding(id, material_id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cladding;
    }

    public List<Cladding> getAllCladding() {
        List<Cladding> claddingList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cladding";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("cladding_id");
                    int material_id = rs.getInt("material_id");
                    Cladding tmpCladding = new Cladding(id, material_id);
                    claddingList.add(new Cladding(id, tmpCladding.getMaterial()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return claddingList;
    }

}
