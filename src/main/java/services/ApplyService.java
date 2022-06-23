package services;


import DAO.Interfaces.ApplyDAO;
import model.Apply;
import model.User;

import java.util.List;

public class ApplyService {
    private final ApplyDAO applyDAO;

    public ApplyService(ApplyDAO applyDAO) {
        this.applyDAO = applyDAO;
    }

    public void addApply(Apply apply){
        applyDAO.addApply(apply);
    }
    public Apply getApplyById(User user){
        return applyDAO.getApplyById(user);
    }
    public List<Apply> getAll(){
        return applyDAO.getAll();
    }
    public void deleteById(int id){
        applyDAO.deleteById(id);
    }
    public boolean checkIfApply(int id){
        boolean flag = false;
        for (Apply apply:getAll()){
            if (apply.getClientId() == id){
                flag = true;
            }
        }
        return flag;
    }


}
