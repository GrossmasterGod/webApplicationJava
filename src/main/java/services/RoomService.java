package services;

import DAO.Interfaces.RoomDAO;
import model.Room;

import java.util.List;

public class RoomService {

    private final RoomDAO roomDAO;

    public RoomService(RoomDAO roomDAO){
        this.roomDAO = roomDAO;
    }

    public List<Room> getAll(){
        return roomDAO.getAll();
    }
    public List<Room> getAllSortedBy(String sort){
        return roomDAO.getAllSortedBy(sort);
    }

    public Room getById(int id){
        return roomDAO.getById(id);
    }
}
