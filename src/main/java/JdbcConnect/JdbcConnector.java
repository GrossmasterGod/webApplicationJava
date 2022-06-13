package JdbcConnect;

import DAO.Implementation.RoomDAO;
import model.Room;
import services.RoomService;
import utils.ConnectionManager;

import java.sql.*;
import java.util.List;

public class JdbcConnector {
    public static void main(String[] args) throws SQLException {
        RoomService roomService = new RoomService(new RoomDAO());
        List<Room> rooms = roomService.getAllSortedBy("status");
        for (Room room : rooms){
//            System.out.println(room.getId());
//            System.out.println(room.getPrice());
//            System.out.println(room.getQuantity());
//            System.out.println(room.getCategory());
            System.out.println(room.getStatus());
        }
//        Connection connection = ConnectionManager.open();
//        UserDAO UserDAO = new UserDAO(connection);
//        User user1 = new User();
//        user1.setName("Masha");
//        user1.setRole("Client");
//        user1.setLogin("root");
//        user1.setPassword("password");
//        System.out.println(UserDAO.create(user1));

//        String sql = "INSERT INTO users (name,role,login,password) VALUES ('Nazar','Client','root','password')";
//        Connection connection = ConnectionManager.open();
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.executeUpdate();
//        statement.setString(1,"Masha");
//        statement.setString(2,"Client");
//        statement.setString(3,"root");
//        statement.setString(4,"password");

//        final ResultSet resultSet = statement.executeQuery();
//        if (resultSet.next()) {
//            System.out.println(resultSet.getString("name"));
//            System.out.println(resultSet.getString("role"));
//        }
    }
}
