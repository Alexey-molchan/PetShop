package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Items;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ItemsDAOImp implements ItemsDAO {
    private Transaction transaction = null;

    @Override
    public List<Items> findAll() {
        List<Items> goodsAll = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("From Items");
            goodsAll = (List) query.getResultList();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return goodsAll;
    }
}