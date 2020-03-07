package services;

import dataBase.OrderDAO;
import dataBase.OrderDAOImp;
import pojo.Items;
import pojo.Order;
import java.util.List;

public class OrderServiceImp implements OrderService {
    OrderDAO orderDAO;

    @Override
    public boolean createOrder(Order order) {
        orderDAO = new OrderDAOImp();
        return orderDAO.createOrder(order);
    }

    @Override
    public boolean setOrderZero(Long idUser) {
        orderDAO = new OrderDAOImp();
        return orderDAO.setOrderZero(idUser);
    }

    @Override
    public List<Items> getCartList (Long idUser) {
        orderDAO = new OrderDAOImp();
        return  orderDAO.getCartList(idUser);
    }

    @Override
    public Double getSum (Long idUser) {
        orderDAO = new OrderDAOImp();
        Object s = orderDAO.getSum(idUser);
        Double d = null;
        if (s == null) {
            d = 0.0;
        } else {
             d = (int) Math.round(orderDAO.getSum(idUser) * 100) / 100d;
        }
        return  d;
    }
}