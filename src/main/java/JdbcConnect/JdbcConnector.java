package JdbcConnect;

import DAO.Implementation.ApplicationDAO;
import DAO.Implementation.PaymentDAO;
import DAO.Implementation.RoomDAO;
import DAO.Implementation.UserDAO;
import model.Application;
import model.Payment;
import model.Room;
import model.User;
import services.ApplicationService;
import services.PaymentService;
import services.RoomService;
import utils.ConnectionManager;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class JdbcConnector {
    public static void main(String[] args) throws SQLException {
        PaymentService paymentService = new PaymentService(new PaymentDAO());
        Payment payment = new Payment();
        payment.setClientId(2);
        payment.setRoomId(3);
        payment.setDate(new Date());
        payment.setPrice(200);
        paymentService.addPayment(payment);
    }
}
