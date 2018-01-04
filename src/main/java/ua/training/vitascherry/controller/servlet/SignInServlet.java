package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.model.entity.Role;
import ua.training.vitascherry.model.entity.Student;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.StudentService;
import ua.training.vitascherry.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.vitascherry.controller.util.Message.INVALID_CREDENTIALS;
import static ua.training.vitascherry.controller.util.View.ADMIN_SIGNED_PAGE;
import static ua.training.vitascherry.controller.util.View.SIGN_IN_PAGE;
import static ua.training.vitascherry.controller.util.View.STUDENT_SIGNED_PAGE;

public class SignInServlet extends HttpServlet {

    private final UserService userService = new UserService();
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getNamedDispatcher("MainServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\nProcessing Sign in doPOST()...");
        User user = userService.getUserByEmail(req.getParameter("email"));
        System.out.println("User: " + user);
        String responsePage = SIGN_IN_PAGE;
        if (user != null && userService.isValidCredentials(user, req.getParameter("password"))) {
            req.getSession().setAttribute("user", user);
            if (user.getRole().equals(Role.STUDENT)) {
                Student student = studentService.getStudentById(user.getId());
                System.out.println("Student: " + student);
                req.getSession().setAttribute("student", student);
                responsePage = STUDENT_SIGNED_PAGE;
            } else {
                responsePage = ADMIN_SIGNED_PAGE;
            }
        } else {
            req.setAttribute("invalidCredentials", INVALID_CREDENTIALS);
        }
        System.out.println("Response page: " + responsePage);
        req.getRequestDispatcher(responsePage).forward(req, resp);
    }
}
