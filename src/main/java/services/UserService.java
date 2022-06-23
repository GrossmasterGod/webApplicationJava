package services;


import DAO.Interfaces.UserDAO;
import model.User;
import validation.Validation;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String save (User user){
        if (!Validation.passwordValidation(user)){
            return "Password must contain: " +
                    "1. Capital letter;" +
                    "2. 8 letters size;" +
                    "3. Digits";
        }else if (!Validation.usernameValidation(user)){
            return "Username must contain:" +
                    "1. 4-20 letters" +
                    "2. no _ or . at the beginning,inside or at the end";
        }else {
            userDAO.create(user);
        }
        return "";
    }
    public User login(String username,String password){
        return userDAO.validateLogin(username,password);
    }
}
