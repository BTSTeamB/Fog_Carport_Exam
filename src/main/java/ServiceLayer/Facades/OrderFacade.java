package ServiceLayer.Facades;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.OrderMapper;
import Entities.Cladding;
import Entities.Order;
import Entities.Roofing;

public class OrderFacade
{
    OrderMapper orderMapper;

    public OrderFacade(Database database){
        orderMapper = new OrderMapper(database);
    }

   public Order creatOrder(double price, int carport_length, int carport_width, Cladding cladding, Roofing roofing, int shed_width, int shed_length){
        Order order = new Order(price,carport_length,carport_width,cladding,roofing,shed_width,shed_length);
        orderMapper.createOrder(order);
        return order;
   }

}

