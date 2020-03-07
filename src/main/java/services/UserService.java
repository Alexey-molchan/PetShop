package services;

import pojo.User;

public interface UserService {
    User getUserService(String login, String password);
    boolean createUser(User user);
    User getUserServiceCheckIfUserExists (String login);
    User getUserServiceCheckIfUserExistsByEmail (String email);
}