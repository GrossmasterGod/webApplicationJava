package servlets;

import DAO.Implementation.ApplicationDAO;
import DAO.Implementation.ApplyDAO;
import model.Application;
import services.ApplicationService;
import services.ApplyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteReviewServlet", value = "/DeleteReviewServlet")
public class DeleteReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationService applicationService = new ApplicationService(new ApplicationDAO());
        applicationService.deleteById(Integer.parseInt(request.getParameter("id")));
        String redirect = request.getContextPath() + "/review";
        response.sendRedirect(redirect);
    }
}
