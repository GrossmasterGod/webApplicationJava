package DAO.Interfaces;

import model.Payment;

public interface PaymentDAO {
    void addPayment(Payment payment);
    Payment getById(int id);
    void deleteById(int id);
}
