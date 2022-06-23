package DAO.Implementation;

import com.mysql.cj.protocol.Resultset;
import model.User;
import utils.ConnectionManager;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements DAO.Interfaces.UserDAO {

    public boolean create(User model) {
        try(Connection connection = ConnectionManager.open();
            PreparedStatement statement = connection.prepareStatement(SQLUser.INSERT.QUERY)) {
            statement.setString(1, model.getName());
            statement.setString(2, model.getRole());
            statement.setString(3,model.getLogin());
            statement.setString(4,model.getPassword());

            return statement.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User validateLogin(String username, String password) {
        String validateLoginSql = "SELECT * FROM users WHERE login = ? AND password = ?";
        try(Connection connection = ConnectionManager.open();
        PreparedStatement statement = connection.prepareStatement(validateLoginSql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()){
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setRole(resultSet.getString("role"));
                    user.setLogin(resultSet.getString("login"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }



    enum SQLUser {
        INSERT("INSERT INTO users (id, name, role, login,password) VALUES (DEFAULT, ?, ?, ?, ?)");

        String QUERY;
        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
