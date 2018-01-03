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
        getServletContext().getNamedDispatcher("MainServlet")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String responsePage = SIGN_IN_PAGE;
        User user = userService.getUserByEmail(req.getParameter("email"));
        if (userService.isValidCredentials(user, req.getParameter("password"))) {
            if (user.getRole() == Role.STUDENT) {
                Student student = studentService.getStudentById(user.getId());
                student.setUser(user);
                req.setAttribute("student", student);
                responsePage = STUDENT_SIGNED_PAGE;
            } else if (user.getRole() == Role.ADMIN) {
                req.setAttribute("user", user);
                responsePage = ADMIN_SIGNED_PAGE;
            }
        } else {
            req.setAttribute("invalidCredentials", INVALID_CREDENTIALS);
        }
        req.getRequestDispatcher(responsePage).forward(req, resp);
    }
}
