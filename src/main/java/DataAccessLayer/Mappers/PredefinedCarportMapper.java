package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.PredefinedCarport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PredefinedCarportMapper {
    Database database;

    public PredefinedCarportMapper(Database database) {
        this.database = database;
    }

    public void createPredefinedCarport(PredefinedCarport predefinedCarport) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO predefiend_carport(width,length) values(?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, predefinedCarport.getWidth());
                ps.setInt(2, predefinedCarport.getLength());
                ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editPredefinedCarport(PredefinedCarport predefinedCarport)throws Exception{
        try(Connection connection = database.connect()){
            String sql = "UPDATE predefiend_carport SET width=?,length=? WHERE id="+predefinedCarport.getId();
        try (PreparedStatement ps = connection.prepareStatement(sql)){
           ps.setInt(1,predefinedCarport.getWidth());
           ps.setInt(2,predefinedCarport.getLength());
           ps.executeUpdate();
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
