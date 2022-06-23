package services;

import DAO.Interfaces.PaymentDAO;
import model.Payment;

public class PaymentService {
    private final PaymentDAO paymentDAO;

    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public void addPayment(Payment payment){
        paymentDAO.addPayment(payment);
    }
    public Payment getById(int id){
        return paymentDAO.getById(id);
    }
}
