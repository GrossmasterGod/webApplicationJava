package services;


import DAO.Interfaces.ApplicationDAO;
import model.Application;

import java.util.List;

public class ApplicationService {
    private final ApplicationDAO applicationDAO;

    public ApplicationService(ApplicationDAO applicationDAO) {
        this.applicationDAO = applicationDAO;
    }

    public void addRequest(Application application){
        applicationDAO.addRequest(application);
    }

    public List<Application> getAll(){
        return applicationDAO.getAll();
    }

    public void deleteById(int id){
        applicationDAO.deleteById(id);
    }

    public Application getById(int id){
        return applicationDAO.getById(id);
    }
    public boolean applicationValid(int id){
        boolean flag = false;
        for (Application application : applicationDAO.getAll()){
            if (application.getId() == id){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
