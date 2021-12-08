package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{
    private Database database;

    public OrderMapper(Database database)
    {
        this.database = database;
    }

    public void createOrder(Order order) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO Fog_carport.order(user_id,price,carport_length,carport_width,cladding_id,roofing_id,shed_width,shed_length) values(?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, order.getUser_id());
                ps.setDouble(2, order.getPrice());
                ps.setDouble(3, order.getCarport_length());
                ps.setDouble(4, order.getCarport_width());
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
                ps.setDouble(3, order.getCarport_length());
                ps.setDouble(4, order.getCarport_width());
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

    public List<Order> getOrderListById(int userId)
    {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM Fog_carport.order WHERE user_id="+userId;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    double price = rs.getDouble("price");
                    double carport_length = rs.getDouble("carport_length");
                    double carport_width = rs.getDouble("carport_width");
                    int cladding_id = rs.getInt("cladding_id");
                    int roofing_id = rs.getInt("roofing_id");
                    int shed_width = rs.getInt("shed_width");
                    int shed_length = rs.getInt("shed_length");

                    orderList.add(new Order(order_id, user_id,price, carport_length, carport_width, cladding_id, roofing_id, shed_width, shed_length));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }

    public Order getOrderByOrderId(int id) {
        Order order = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM Fog_carport.order WHERE order_id=" + id;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    double price = rs.getDouble("price");
                    double carport_length = rs.getDouble("carport_length");
                    double carport_width = rs.getDouble("carport_width");
                    int cladding_id = rs.getInt("cladding_id");
                    int roofing_id = rs.getInt("roofing_id");
                    int shed_width = rs.getInt("shed_width");
                    int shed_length = rs.getInt("shed_length");
                    order = new Order(order_id, user_id, price, carport_length,carport_width, cladding_id, roofing_id, shed_width, shed_length);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}
