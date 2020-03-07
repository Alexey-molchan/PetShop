package services;

import dataBase.UserDAO;
import dataBase.UserDAOImp;
import pojo.User;

public class UserServiceImp implements UserService {
    UserDAO userDAO;

    @Override
    public User getUserService(String login, String password) {
        userDAO = new UserDAOImp();
        User userTemp = userDAO.getUser(login);
        if (login.equalsIgnoreCase(userTemp.getLogin()) && password.equals(userTemp.getPassword())) {
            return userDAO.getUser(login);
        } else {
            return null;
        }
    }

    public User getUserByLoginService(String login) {
           if (new UserDAOImp().getUser(login) != null) {
            return new UserDAOImp().getUser(login);
        } else {
            return null;
        }
    }
    @Override
    public User getUserServiceCheckIfUserExists(String login) {
        userDAO = new UserDAOImp();
        User userTemp = userDAO.getUser(login);
        if (login.equalsIgnoreCase(userTemp.getLogin())) {
            return userDAO.getUser(login);
        } else {
            return null;
        }
    }

    @Override
    public User getUserServiceCheckIfUserExistsByEmail(String email) {
        userDAO = new UserDAOImp();
        User userTemp = userDAO.getUserByEmail(email);
        if (email.equalsIgnoreCase(userTemp.getEmail())) {
            return userDAO.getUserByEmail(email);
        } else {
            return null;
        }
    }

    @Override
    public boolean createUser(User user) {
        userDAO = new UserDAOImp();
        return userDAO.createUser(user);
    }
}