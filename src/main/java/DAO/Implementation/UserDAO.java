package DAO.Implementation;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO implements DAO.Interfaces.UserDAO {
    private final Connection connection;
    public UserDAO(final Connection connection){
        this.connection = connection;
    }


    public boolean create(User model) {
        try(PreparedStatement statement = connection.prepareStatement(SQLUser.INSERT.QUERY)) {
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



    enum SQLUser {
        INSERT("INSERT INTO users (id, name, role, login,password) VALUES (DEFAULT, ?, ?, ?, ?)");

        String QUERY;
        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
