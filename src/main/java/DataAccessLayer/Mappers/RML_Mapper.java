package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Roofing;
import Entities.RoofingMaterialLine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RML_Mapper
{
    private Database database;

    protected RML_Mapper(Database database)
    {
        this.database = database;
    }

    protected void createLine(RoofingMaterialLine rml) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO roofing_material_line(roof_id, material_id) value(?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, rml.getRoofingId());
                ps.setInt(2, rml.getMaterialId());
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected List<RoofingMaterialLine> getAllRMLBySpecificId(int id) {
        List<RoofingMaterialLine> rmlList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM roofing_material_line WHERE roof_id="+id;

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                while (rs.next()) {
                    int rmlId = rs.getInt("roofing_material_line_id");
                    int roofingId = rs.getInt("roof_id");
                    int materialId = rs.getInt("material_id");
                    rmlList.add(new RoofingMaterialLine(rmlId, roofingId, materialId));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rmlList;
    }
}
