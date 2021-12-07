package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.PredefinedCarport;
import Entities.PredefinedShed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PredefinedCarportMapper {
    Database database;

    public PredefinedCarportMapper(Database database) {
        this.database = database;
    }

    public void createPredefinedCarport(PredefinedCarport predefinedCarport) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO predefined_carport(width,length,price,imageUrl) values(?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setDouble(1, predefinedCarport.getWidth());
                ps.setDouble(2, predefinedCarport.getLength());
                ps.setDouble(3, predefinedCarport.getPrice());
                ps.setString(4, predefinedCarport.getImgUrl());
                ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editPredefinedCarport(PredefinedCarport predefinedCarport)throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE predefined_carport SET width=?,length=? ,price=?, imageUrl=? WHERE id=" + predefinedCarport.getId();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setDouble(1, predefinedCarport.getWidth());
                ps.setDouble(2, predefinedCarport.getLength());
                ps.setDouble(3, predefinedCarport.getPrice());
                ps.setString(4, predefinedCarport.getImgUrl());
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PredefinedCarport> receiveAllPredefinedCarport()throws Exception {
        PredefinedCarport pdCarport;
        List<PredefinedCarport> pdCarportList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM predefined_carport";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                while (rs.next()){
                    int id = rs.getInt("id");
                    double width = rs.getInt("width");
                    double length = rs.getInt("length");
                    double price = rs.getDouble("price");
                    String imgUrl = rs.getString("imageUrl");
                    String seeMoreUrl1 = rs.getString("seeMoreUrl1");
                    String seeMoreUrl2 = rs.getString("seeMoreUrl2");
                    pdCarport = new PredefinedCarport(id, width, length, price, imgUrl, seeMoreUrl1, seeMoreUrl2);
                    pdCarportList.add(pdCarport);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }

        }
        return pdCarportList;
    }

    public PredefinedCarport receivePredefinedCarport(PredefinedCarport predefinedCarport)throws Exception
    {
        PredefinedCarport pdCarport = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM predefined_carport WHERE id="+predefinedCarport.getId();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()){
                    int id = rs.getInt("id");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    double price = rs.getDouble("price");
                    String imgUrl = rs.getString("imgUrl");
                    String seeMoreUrl1 = rs.getString("seeMoreUrl1");
                    String seeMoreUrl2 = rs.getString("seeMoreUrl2");
                    pdCarport = new PredefinedCarport(id, width, length, price, imgUrl, seeMoreUrl1, seeMoreUrl2);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
            return pdCarport;
        }
    }

    public void deletePredefinedCarport(PredefinedCarport predefinedCarport) {
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM predefined_carport WHERE id="+predefinedCarport.getId();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, predefinedCarport.getId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}