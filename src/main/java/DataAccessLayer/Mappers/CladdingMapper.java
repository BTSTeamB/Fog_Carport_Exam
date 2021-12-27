package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import PresentationLayer.Entities.Cladding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CladdingMapper
{
    private Database database;

    protected CladdingMapper(Database database)
    {
        this.database = database;
    }

    protected void createCladding(Cladding cladding) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO cladding(type) value(?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, cladding.getType());
                ps.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    protected void deleteCladding(Cladding cladding) {
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM cladding WHERE cladding_id="+cladding.getCladding_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, cladding.getCladding_id());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void editCladding(Cladding cladding) {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE cladding SET type="+cladding.getType()+" WHERE cladding_id="+cladding.getCladding_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, cladding.getType());
                ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected Cladding receiveCladdingByObject(Cladding paraCladding) {
        Cladding tmpCladding = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT type FROM cladding WHERE cladding_id="+paraCladding.getCladding_id();

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    String type = rs.getString("type");
                    tmpCladding = new Cladding(paraCladding.getCladding_id(), type);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tmpCladding;
    }

    protected Cladding receiveCladdingById(int claddingId) {
        Cladding cladding = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cladding WHERE cladding_id=" + claddingId;

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int id = rs.getInt("cladding_id");
                    String type = rs.getString("type");
                    cladding = new Cladding(id, type);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cladding;
    }

    protected List<Cladding> getAllCladding() {
        List<Cladding> claddingList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cladding";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("cladding_id");
                    String type = rs.getString("type");
                    Cladding tmpCladding = new Cladding(id, type);
                    claddingList.add(new Cladding(id, tmpCladding.getType()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return claddingList;
    }
}
