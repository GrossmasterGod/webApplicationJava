package DAO.Implementation;

import model.Room;
import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RoomDAO implements DAO.Interfaces.RoomDAO {
    @Override
    public List<Room> getAll() {
        List<Room> rooms = new ArrayList<>();
        String getAll = "SELECT * FROM rooms;";
        Connection connection = ConnectionManager.open();
        try(PreparedStatement preparedStatement = connection.prepareStatement(getAll);
            ResultSet resultSet =preparedStatement.executeQuery()){

            while (resultSet.next()){
                Room room = new Room();
                int id = resultSet.getInt("id");
                int price = resultSet.getInt("price");
                int bedQuantity = resultSet.getInt("bed_quantity");
                int category = resultSet.getInt("category");
                String status = resultSet.getString("status");
                room.setId(id);
                room.setPrice(price);
                room.setQuantity(bedQuantity);
                room.setCategory(category);
                room.setStatus(status);

                rooms.add(room);
            }
            return rooms;
        } catch (SQLException e) {
            System.out.println("error in RoomDao");
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public List<Room> getAllSortedBy(String sort) {
        List<Room> sortedRoom = getAll();
        switch (sort){
            case "price":
                Collections.sort(sortedRoom,new Comparator<Room>() {
                    @Override
                    public int compare(Room o1, Room o2) {
                        return o1.getPrice() - o2.getPrice();
                    }
                });
                break;
            case "quantity":
                Collections.sort(sortedRoom,new Comparator<Room>() {
                    @Override
                    public int compare(Room o1, Room o2) {
                        return o1.getQuantity() - o2.getQuantity();
                    }
                });
                break;
            case "category":
                Collections.sort(sortedRoom,new Comparator<Room>() {
                    @Override
                    public int compare(Room o1, Room o2) {
                        return o1.getCategory() - o2.getCategory();
                    }
                });
                break;
            case "status":
                Collections.sort(sortedRoom,new Comparator<Room>() {
                    @Override
                    public int compare(Room o1, Room o2) {
                        return o1.getStatus().compareTo(o2.getStatus());
                    }
                });
                break;
        }
        return sortedRoom;
    }


    @Override
    public Room getById(int id) {
        String findBySql = "SELECT * FROM rooms WHERE id = ?";
        Room room = new Room();
        System.out.println("This");
        try(Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(findBySql)) {
            System.out.println("Two");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                room.setId(resultSet.getInt("id"));
                room.setPrice(resultSet.getInt("price"));
                room.setQuantity(resultSet.getInt("bed_quantity"));
                room.setCategory(resultSet.getInt("category"));
                room.setStatus(resultSet.getString("status"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }
}
