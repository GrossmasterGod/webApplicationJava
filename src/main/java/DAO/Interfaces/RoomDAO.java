package DAO.Interfaces;

import model.Room;

import java.util.List;

public interface RoomDAO {
    List<Room> getAll();
    List<Room> getAllSortedBy(String sort);
    Room getById(int id);

}
