package DAO.Interfaces;

import model.Application;

import java.util.List;

public interface ApplicationDAO {
    List<Application> getAll();
    void addRequest(Application application);
    void deleteById(int id);
    Application getById(int id);
}
