package DAO.Implementation;

import model.Application;
import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApplicationDAO implements DAO.Interfaces.ApplicationDAO {
    @Override
    public List<Application> getAll() {
        List<Application> applications = new ArrayList<>();
        String getAll = "SELECT * FROM requests;";
        Connection connection = ConnectionManager.open();
        try(PreparedStatement preparedStatement = connection.prepareStatement(getAll);
            ResultSet resultSet =preparedStatement.executeQuery()){

            while (resultSet.next()){
                Application application = new Application();
                int id = resultSet.getInt("id");
                int clientId = resultSet.getInt("client_id");
                int bedQuantity = resultSet.getInt("bed_quantity");
                int category = resultSet.getInt("room_category");
                int staying = resultSet.getInt("stay_time");
                application.setId(id);
                application.setClientId(clientId);
                application.setQuantity(bedQuantity);
                application.setCategory(category);
                application.setStaying(staying);

                applications.add(application);
            }
            return applications;
        } catch (SQLException e) {
            System.out.println("error in RoomDao");
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public void addRequest(Application application) {
        String addSql = "INSERT INTO requests (id, client_id,bed_quantity,room_category,stay_time) VALUES (DEFAULT,?,?,?,?)";
        try(Connection connection = ConnectionManager.open();
            PreparedStatement statement = connection.prepareStatement(addSql)){
            statement.setInt(1, application.getClientId());
            statement.setInt(2, application.getQuantity());
            statement.setInt(3,application.getQuantity());
            statement.setInt(4,application.getStaying());

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String deleteSql = "DELETE FROM requests WHERE id = ?";
        Connection connection = ConnectionManager.open();
        try {
            PreparedStatement statement = connection.prepareStatement(deleteSql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Application getById(int id) {
        String findBySql = "SELECT * FROM requests WHERE id = ?";
        Application application = new Application();
        try(Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(findBySql)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                application.setId(resultSet.getInt("id"));
                application.setClientId(resultSet.getInt("client_id"));
                application.setQuantity(resultSet.getInt("bed_quantity"));
                application.setCategory(resultSet.getInt("room_category"));
                application.setStaying(resultSet.getInt("stay_time"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return application;
    }
}

