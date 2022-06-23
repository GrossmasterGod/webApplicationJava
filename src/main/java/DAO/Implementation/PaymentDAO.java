package DAO.Implementation;

import model.Payment;
import utils.ConnectionManager;

import java.sql.*;

public class PaymentDAO implements DAO.Interfaces.PaymentDAO {
    @Override
    public void addPayment(Payment payment) {
        String addSql = "INSERT INTO payment (id,client_id, room_id, price,date) VALUES (DEFAULT, ?, ?, ?, ?)";
        try(Connection connection = ConnectionManager.open();
            PreparedStatement statement = connection.prepareStatement(addSql)) {
            statement.setInt(1, payment.getClientId());
            statement.setInt(2,payment.getRoomId());
            statement.setInt(3,payment.getPrice());
            statement.setDate(4, convertToSql(payment.getDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Payment getById(int id) {
        String sql = "SELECT * FROM payment WHERE id = ?";
        Payment payment = new Payment();
        try(Connection connection = ConnectionManager.open();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                payment.setId(resultSet.getInt("id"));
                payment.setClientId(resultSet.getInt("client_id"));
                payment.setRoomId(resultSet.getInt("room_id"));
                payment.setPrice(resultSet.getInt("price"));
                payment.setDate(convertToUtil(resultSet.getDate("date")));
                return payment;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void deleteById(int id) {
        String deleteSql = "DELETE FROM payment WHERE id = ?";
        Connection connection = ConnectionManager.open();
        try {
            PreparedStatement statement = connection.prepareStatement(deleteSql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private java.sql.Date convertToSql(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }
    private java.util.Date convertToUtil(java.sql.Date date){
        return new java.util.Date(date.getTime());
    }
}
