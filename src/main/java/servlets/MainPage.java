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
    private static final String REGISTRATION = "JSP/registration";

    public MainPage(){}

    public void init(){
        roomService = new RoomService(new RoomDAO());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        if (action.equalsIgnoreCase("price")||action.equalsIgnoreCase("quantity")||
                action.equalsIgnoreCase("category")||action.equalsIgnoreCase("status")){
            request.setAttribute("rooms",roomService.getAllSortedBy(action));
        }else{
            request.setAttribute("rooms",roomService.getAll());
        }
        request.getRequestDispatcher(MAIN_PAGE).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
