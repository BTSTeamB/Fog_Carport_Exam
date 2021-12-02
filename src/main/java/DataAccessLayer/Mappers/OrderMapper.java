package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Cladding;
import Entities.Order;
import Entities.Roofing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class OrderMapper {
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public void createOrder(Order order) throws Exception {
        try (Connection connection = database.connect()) {
            String sql ="INSERT INTO Fog_carport.order(user_id,price,carport_length,carport_width,cladding_id,roofing_id,shed_width,shed_length) values(?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {

                ps.setInt(1, order.getUser_id());
                ps.setDouble(2, order.getPrice());
                ps.setInt(3, order.getCarport_length());
                ps.setInt(4, order.getCarport_width());
                ps.setInt(5, order.getCladding_id());
                ps.setInt(6, order.getRoofing_id());
                ps.setInt(7, order.getShed_width());
                ps.setInt(8, order.getShed_length());

                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteOrder(Order order) {

    }

    public void editOrder(Order order) {

    }

    public Order getOrder(Order order) {

        return null;
    }
}
