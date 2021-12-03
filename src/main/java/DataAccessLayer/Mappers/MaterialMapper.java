package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Material;

import java.sql.*;

public class MaterialMapper {
    private Database database;

    public MaterialMapper(Database database) {
        this.database = database;
    }

    public void createMaterial(Material material) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "insert into material(name,description,price,unit_id,length,height,width) value(?,?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, material.getName());
                ps.setString(2, material.getDescription());
                ps.setDouble(3, material.getPrice());
                ps.setInt(4, material.getUnit_id());
                ps.setDouble(5, material.getLength());
                ps.setDouble(6, material.getHeight());
                ps.setDouble(7, material.getWidth());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public void deleteMaterial(Material material) {
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM material WHERE material_id = ?" + material.getMaterial_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, material.getName());
                ps.setString(2, material.getDescription());
                ps.setDouble(3, material.getPrice());
                ps.setInt(4, material.getUnit_id());
                ps.setDouble(5, material.getLength());
                ps.setDouble(6, material.getHeight());
                ps.setDouble(7, material.getWidth());
                ps.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void editMaterial(Material material) {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE material SET  name=?,description=?,price=?,unit_id=?,length=?,height=?,width=? WHERE material_id" + material.getMaterial_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, material.getName());
                ps.setString(2, material.getDescription());
                ps.setDouble(3, material.getPrice());
                ps.setInt(4, material.getUnit_id());
                ps.setDouble(5, material.getLength());
                ps.setDouble(6, material.getHeight());
                ps.setDouble(7, material.getWidth());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Material recevieMaterial(Material material) {
        try (Connection connection = database.connect()) {
            String sql = "SELECT  name,description,price,unit_id,length,height,width FROM material WHERE material_id=" + material.getMaterial_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    double price = rs.getInt("price");
                    int unit_id = rs.getInt("unit_id");
                    double lenth = rs.getInt("length");
                    double height = rs.getInt("height");
                    double width = rs.getInt("width");
                    System.out.println(name + description + price + unit_id + lenth + height + width);


                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return material;
    }
}
