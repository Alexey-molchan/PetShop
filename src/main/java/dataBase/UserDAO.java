package dataBase;

import pojo.User;

public interface UserDAO {
    User getUser(String login);
    boolean createUser(User user);
    User getUserByEmail (String email);
}