package servlets;

import DAO.Implementation.ApplicationDAO;
import DAO.Implementation.ApplyDAO;
import DAO.Implementation.RoomDAO;
import model.Apply;
import services.ApplicationService;
import services.ApplyService;
import services.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReviewServlet", value = "/ReviewServlet")
public class ReviewServlet extends HttpServlet {
    private static final String REVIEW = "JSP/review.jsp";
    private String forward;

    private RoomService roomService;
    private ApplicationService applicationService;
    private ApplyService applyService;

    public ReviewServlet(){}

    public void init(){
        roomService = new RoomService(new RoomDAO());
        applicationService = new ApplicationService(new ApplicationDAO());
        applyService = new ApplyService(new ApplyDAO());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reviewPage(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendApply(request,response);
    }

    private void reviewPage(HttpServletRequest request) {
        forward = REVIEW;
        request.setAttribute("rooms", roomService.getAll());
        request.setAttribute("apps", applicationService.getAll());
    }
    private void sendApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        int appId = Integer.parseInt(request.getParameter("appId"));
        int clientId = applicationService.getById(appId).getClientId();
        if (roomService.getById(roomId).getStatus().equals("taken") ||
                roomService.getById(roomId).getStatus().equals("booked")) {
            request.setAttribute("applyValid", "Room is taken or booked");
        }else if(!applicationService.applicationValid(appId)){
            request.setAttribute("applyValid","There is no such application");
        }
        else {
            roomService.updateStatusById(roomId, "booked");
            applicationService.deleteById(appId);
            Apply apply = new Apply();
            apply.setClientId(clientId);
            apply.setRoomId(roomId);
            applyService.addApply(apply);
        }
        doGet(request, response);
    }
}
