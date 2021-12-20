package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.PredefinedCarport;
import Entities.PredefinedShed;
import Entities.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PredefinedShedMapper {
    Database database;

    protected PredefinedShedMapper(Database database) {
        this.database = database;
    }

    protected void createPredefinedShed(PredefinedShed predefinedShed) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO predefined_shed(width,length,price,imageUrl) values(?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, predefinedShed.getWidth());
                ps.setInt(2, predefinedShed.getLength());
                ps.setDouble(3, predefinedShed.getPrice());
                ps.setString(4, predefinedShed.getImgUrl());
                ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected PredefinedShed receivePredefinedShed(PredefinedShed predefinedShed)throws Exception {
        PredefinedShed tmpPdShed = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM predefined_shed WHERE id="+predefinedShed.getId();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()){
                    int id = rs.getInt("id");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    double price = rs.getDouble("price");
                    String imgUrl = rs.getString("imageUrl");
                    tmpPdShed = new PredefinedShed(id, width, length, price, imgUrl);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return tmpPdShed;
    }

    protected List<PredefinedShed> receiveAllPredefinedShed()throws Exception {
        PredefinedShed pdShed = null;
        List<PredefinedShed> pdShedList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM predefined_shed";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                while (rs.next()){
                    int id = rs.getInt("id");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    double price = rs.getDouble("price");
                    String imgUrl = rs.getString("imageUrl");
                    pdShed = new PredefinedShed(id ,width, length, price, imgUrl);
                    pdShedList.add(pdShed);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }

        }
        return pdShedList;
    }

    protected void editPredefinedShed(PredefinedShed predefinedShed) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE predefiend_shed SET width=?,length=?, price=?, imageUrl=? WHERE id="+predefinedShed.getId();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, predefinedShed.getWidth());
                ps.setInt(2, predefinedShed.getLength());
                ps.setDouble(3, predefinedShed.getPrice());
                ps.setString(4, predefinedShed.getImgUrl());
                ps.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void deletePredefinedShed(PredefinedShed predefinedShed) {
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