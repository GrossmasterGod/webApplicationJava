package DAO.Interfaces;

import model.Apply;
import model.User;

import java.util.List;

public interface ApplyDAO {
    void addApply(Apply apply);
    Apply getApplyById(User user);
    List<Apply> getAll();
    void deleteById(int id);
}
