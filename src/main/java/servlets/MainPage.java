package servlets;

import DAO.Implementation.RoomDAO;
import model.Room;
import services.RoomService;
import utils.ConnectionManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(name = "MainPage", value = "/MainPage")
public class MainPage extends HttpServlet {
    private RoomService roomService;
    private String action;


    private static final String MAIN_PAGE = "JSP/mainPage.jsp";

    public MainPage(){}

    public void init(){
        roomService = new RoomService(new RoomDAO());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        request.setAttribute("rooms",roomService.getAllSortedBy(action));
        request.getRequestDispatcher(MAIN_PAGE).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
//    private void sortedByPrice(HttpServletRequest request){
//        request.setAttribute("rooms",roomService.getAll());
//    }
//    private void sortedByQuantity(HttpServletRequest request){
//
//    }
//    private void sortedByCategory(HttpServletRequest request){
//
//    }
//    private void sortedByStatus(HttpServletRequest request){
//
//    }
}
