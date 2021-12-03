package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Cladding;
import Entities.Order;
import Entities.Roofing;

import java.sql.*;

public class OrderMapper {
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public void createOrder(Order order) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO Fog_carport.order(user_id,price,carport_length,carport_width,cladding_id,roofing_id,shed_width,shed_length) values(?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

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
        try (Connection connection = database.connect()) {
            String sql = " DELETE FROM order WHERE order_id=" + order.getOrder_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order.getOrder_id());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editOrder(Order order) {
        try (Connection connection = database.connect()) {
            String sql = " UPDATE order SET user_id=?,price=?,carport_length=?,carport_width=?,cladding_id=?,roofing_id=?,shed_width=?,shed_length=? WHERE order_id=" + order.getOrder_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order.getUser_id());
                ps.setDouble(2, order.getPrice());
                ps.setInt(3, order.getCarport_length());
                ps.setInt(4, order.getCarport_width());
                ps.setInt(5, order.getCladding_id());
                ps.setInt(6, order.getRoofing_id());
                ps.setInt(7, order.getShed_width());
                ps.setInt(8, order.getShed_length());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Order recevieOrder(Order order) {
        try (Connection connection = database.connect()) {
            String sql = "SELECT user_id,price,carport_length,carport_width,cladding_id,roofing_id,shed_width,shed_length FROM Fog_carport.order WHERE order_id=" + order.getOrder_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    double price = rs.getDouble("price");
                    int carport_length = rs.getInt("carport_length");
                    int carport_width = rs.getInt("carport_width");
                    int cladding_id = rs.getInt("cladding_id");
                    int roofing_id = rs.getInt("roofing_id");
                    int shed_width = rs.getInt("shed_width");
                    int shed_length = rs.getInt("shed_length");
                    System.out.println(user_id +","+ carport_length + ","+ price + "," + carport_width + "," + cladding_id+ "," + roofing_id+ "," + shed_width+ "," + shed_length);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }
}
