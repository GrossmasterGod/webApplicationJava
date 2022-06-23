package servlets;

import DAO.Implementation.*;
import model.*;
import services.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {


    private static final String REGISTRATION = "JSP/registration.jsp";
    private static final String LOGIN = "JSP/login.jsp";
    private static final String USER_PAGE = "JSP/userpage.jsp";
    private static final String APPLICATION = "JSP/application.jsp";
    private static final String REVIEW = "JSP/review.jsp";
    private static final String CONFIRM = "JSP/confirm.jsp";
    private static final String MAIN_PAGE = "JSP/mainPage.jsp";
    private UserService userService;
    private RoomService roomService;
    private ApplicationService applicationService;
    private ApplyService applyService;
    private PaymentService paymentService;
    private HttpSession session;
    private String forward;


    public UserServlet() {
    }

    public void init() {
        userService = new UserService(new UserDAO());
        applicationService = new ApplicationService(new ApplicationDAO());
        roomService = new RoomService(new RoomDAO());
        applyService = new ApplyService(new ApplyDAO());
        paymentService = new PaymentService(new PaymentDAO());
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("registration")) {
            forward = REGISTRATION;
        } else if (action.equalsIgnoreCase("login")) {
            forward = LOGIN;
        } else if (action.equalsIgnoreCase("userpage")) {
            showUserPage(request);
        } else if (action.equalsIgnoreCase("application")) {
            forward = APPLICATION;
        } else if (action.equalsIgnoreCase("confirm")) {
            showConfirmPage(request);
        } else if (action.equalsIgnoreCase("exit")){
            exitFromAccount(request);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        requestDispatcher.forward(request, response);
    }
    private void exitFromAccount(HttpServletRequest request) {
        session = request.getSession();
        session.setAttribute("user", null);
        forward = MAIN_PAGE;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("registration")) {
            registration(request, response);
        } else if (action.equalsIgnoreCase("login")) {
            login(request, response);
        } else if (action.equalsIgnoreCase("application")) {
            makeApplication(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);
        if (user == null) {
            request.setAttribute("errorMessage", "Login or password are incorrect");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(LOGIN);
            requestDispatcher.forward(request, response);
        } else {
            session = request.getSession();
            session.setAttribute("user", user);
            String redirect = request.getContextPath() + "/user?action=userpage";
            response.sendRedirect(redirect);
        }
    }

    private void registration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        user.setName(request.getParameter("name"));
        user.setRole(request.getParameter("role"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        String registerValidation = userService.save(user);
        if (!registerValidation.isEmpty()) {
            request.setAttribute("registerValidation", registerValidation);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(REGISTRATION);
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(LOGIN);
            requestDispatcher.forward(request, response);
        }


    }

    private void makeApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user.getLogin());
        Application application = new Application();
        application.setClientId(user.getId());
        application.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        application.setCategory(Integer.parseInt(request.getParameter("category")));
        application.setStaying(Integer.parseInt(request.getParameter("staying")));
        applicationService.addRequest(application);
        String redirect = request.getContextPath() + "/user?action=userpage";
        response.sendRedirect(redirect);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher(USER_PAGE);
//        requestDispatcher.forward(request, response);

    }

    private void showUserPage(HttpServletRequest request) {
        forward = USER_PAGE;
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        boolean check = applyService.checkIfApply(user.getId());
        request.setAttribute("applyCheck",check);
//        if (check){
//            Room room = roomService.getById(applyService.getApplyById(user).getRoomId());
//            request.setAttribute("room",room);
//        }
    }



    private void showConfirmPage(HttpServletRequest request) {
        forward = CONFIRM;
        User user = (User) session.getAttribute("user");
        Room room = roomService.getById(applyService.getApplyById(user).getRoomId());
        request.setAttribute("room",room);
        request.setAttribute("user",user);
    }

    private void sentConfirm(HttpServletRequest request) {
        Payment payment = new Payment();
        User user = new User();
    }

}
