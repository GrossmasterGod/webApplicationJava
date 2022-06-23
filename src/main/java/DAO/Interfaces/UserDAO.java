package DAO.Interfaces;

import model.User;

public interface UserDAO {
    boolean create(User user);
    User validateLogin(String username,String password);
}
