package DAO.Implementation;

import model.Apply;
import model.User;
import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApplyDAO implements DAO.Interfaces.ApplyDAO {
    @Override
    public void addApply(Apply apply) {
        String applySql = "INSERT INTO applyes (client_id,room_id) VALUES (?,?)";
        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(applySql)) {
            statement.setInt(1,apply.getClientId());
            statement.setInt(2,apply.getRoomId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Apply getApplyById(User user) {
        String applySql = "SELECT * FROM applyes WHERE client_id = ?";
        Apply apply = new Apply();
        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(applySql)) {
            statement.setInt(1,user.getId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                apply.setClientId(resultSet.getInt("client_id"));
                apply.setRoomId(resultSet.getInt("room_id"));
            }
            return apply;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Apply> getAll(){
        List<Apply> applies = new ArrayList<>();
        String getAll = "SELECT * FROM applyes;";
        Connection connection = ConnectionManager.open();
        try {
            PreparedStatement statement = connection.prepareStatement(getAll);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Apply apply = new Apply();
                apply.setClientId(resultSet.getInt("client_id"));
                apply.setRoomId(resultSet.getInt("room_id"));
                applies.add(apply);
            }
            return applies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    public void deleteById(int id) {
        String deleteSql = "DELETE FROM applyes WHERE room_id = ?";
        Connection connection = ConnectionManager.open();
        try {
            PreparedStatement statement = connection.prepareStatement(deleteSql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

