package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.User;
import util.HibernateUtil;

public class UserDAOImp implements UserDAO {
    private Transaction transaction = null;

    User user;

    public User getUser(String login) {
        user = new User();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User where login = '" + login + "'");
            user = (User) query.getSingleResult();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByEmail(String email) {
        user = new User();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User where email = '" + email + "'");
            user = (User) query.getSingleResult();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    public boolean createUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
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