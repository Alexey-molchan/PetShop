package dataBase;

import pojo.Items;
import pojo.Order;

import java.util.List;

public interface OrderDAO {
    boolean createOrder (Order order);
    boolean updateOrder (Order order);
    Order getOrder (Long idUser);
    List<Items> getCartList (Long idUser);
    Double getSum (Long idUser);
     boolean setOrderZero(Long idUser);
}