package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;
import pojo.Items;
import pojo.Order;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderDAOImp implements OrderDAO {
    private Transaction transaction = null;
    Order order;

    @Override
    public boolean createOrder(Order order) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateOrder(Order order) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Order getOrder(Long idUser) {
        order = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            order = session.get(Order.class, idUser);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Items> getCartList(Long idUser) {
        List<Items> cartList = new ArrayList<>();
        List<Object[]> orderedList1;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createSQLQuery("SELECT g.items_name, g.items_price from items g left join order i ON g.id_items = i.id_items where i.id_user = '" + idUser + "' AND i.order_status = 1")
                    .addScalar("items_name", new StringType())
                    .addScalar("items_price", new DoubleType());
            orderedList1 = query.list();
            for (Object[] row : orderedList1) {
                Items items = new Items();
                items.setItemsName(row[0].toString());
                items.setItemsPrice(Double.parseDouble(row[1].toString()));
                cartList.add(items);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return cartList;
    }

    @Override
    public Double getSum(Long idUser) {
        Double sum = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createSQLQuery("SELECT SUM(g.items_price) from items g left join order i ON g.id_items = i.id_items where i.id_user = '" + idUser + "' AND i.order_status = 1");
            sum = (Double) query.getSingleResult();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public boolean setOrderZero(Long idUser) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("update order set order_status = 0 where id_user = '"+idUser+"'");
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }
}