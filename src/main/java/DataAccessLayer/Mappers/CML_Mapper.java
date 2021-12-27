package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import PresentationLayer.Entities.CladdingMaterialLine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CML_Mapper
{

    //cladding_material_line

    private Database database;

    protected CML_Mapper(Database database)
    {
        this.database = database;
    }

    protected void createLine(CladdingMaterialLine cml) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO cladding_material_line(roof_id, material_id) value(?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, cml.getCladdingId());
                ps.setInt(2, cml.getMaterialId());
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected List<CladdingMaterialLine> getAllCMLBySpecificId(int id) {
        List<CladdingMaterialLine> cmlList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cladding_material_line WHERE cladding_id="+id;

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                while (rs.next()) {
                    int cmlId = rs.getInt("cladding_material_line_id");
                    int roofingId = rs.getInt("cladding_id");
                    int materialId = rs.getInt("material_id");
                    cmlList.add(new CladdingMaterialLine(cmlId, roofingId, materialId));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cmlList;
    }
}
