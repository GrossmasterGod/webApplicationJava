package servlets;

import DAO.Implementation.ApplyDAO;
import DAO.Implementation.PaymentDAO;
import DAO.Implementation.RoomDAO;
import model.Payment;
import services.ApplyService;
import services.PaymentService;
import services.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AddPaymentServlet", value = "/addPayment")
public class AddPaymentServlet extends HttpServlet {

    private PaymentService paymentService;
    private ApplyService applyService;
    public void init(){
        paymentService = new PaymentService(new PaymentDAO());
        applyService = new ApplyService(new ApplyDAO());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Payment payment = new Payment();
        int roomId = Integer.parseInt(request.getParameter("room_id"));
        int price = Integer.parseInt(request.getParameter("price"));
        int clientId = Integer.parseInt(request.getParameter("client_id"));
        payment.setClientId(clientId);
        payment.setRoomId(roomId);
        payment.setPrice(price);
        payment.setDate(new Date());
        paymentService.addPayment(payment);
        applyService.deleteById(roomId);
        String redirect = request.getContextPath() + "/user?action=userpage";
        response.sendRedirect(redirect);
    }
}
