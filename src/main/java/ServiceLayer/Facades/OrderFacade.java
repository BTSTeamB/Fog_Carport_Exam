package ServiceLayer.Facades;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.OrderMapper;
import Entities.Cladding;
import Entities.Order;
import Entities.Roofing;

public class OrderFacade {
    OrderMapper orderMapper;

    public OrderFacade(Database database) {
        orderMapper = new OrderMapper(database);
    }

    public Order creatOrder(int user_id,double price, int carport_length, int carport_width, int cladding_id, int roofing_id, int shed_width, int shed_length) throws Exception {
        Order order = new Order(user_id,price, carport_length, carport_width, cladding_id, roofing_id, shed_width, shed_length);
            orderMapper.createOrder(order);

        return order;
    }

}

