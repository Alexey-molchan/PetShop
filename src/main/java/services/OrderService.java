package services;

import pojo.Items;
import pojo.Order;

import java.util.List;

public interface OrderService {
    boolean createOrder(Order order);
    boolean setOrderZero(Long idUser);
    List<Items> getCartList(Long idUser);
    Double getSum(Long idUser);
}