package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.model.entity.Role;
import ua.training.vitascherry.model.entity.Student;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.StudentService;
import ua.training.vitascherry.model.service.UserService;
import ua.training.vitascherry.model.util.Encryptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.vitascherry.controller.util.Message.NOT_UNIQUE_EMAIL;
import static ua.training.vitascherry.controller.util.View.REGISTERED_PAGE;
import static ua.training.vitascherry.controller.util.View.REGISTER_PAGE;

public class RegisterServlet extends HttpServlet {

    private final UserService userService = new UserService();
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getNamedDispatcher("MainServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String responsePage = REGISTER_PAGE;
        if (userService.isUniqueEmail(req.getParameter("email"))) {
            User user = User.builder()
                    .setEmail(req.getParameter("email"))
                    .setRole(Role.STUDENT)
                    .setPasswordHash(Encryptor.encrypt(req.getParameter("password")))
                    .build();
            System.out.println("User: " + user);

            int userId = userService.createUser(user);
            if (userId != 0) {
                Student student = Student.builder()
                        .setId(userId)
                        .setFirstName(req.getParameter("firstName"))
                        .setLastName(req.getParameter("lastName"))
                        .setPatronymic(req.getParameter("patronymic"))
                        .setUser(user)
                        .build();
                System.out.println("Student: " + student);
                studentService.createStudent(student);
                responsePage = REGISTERED_PAGE;
            }
        } else {
            req.setAttribute("notUniqueEmail", req.getParameter("email") + NOT_UNIQUE_EMAIL);
        }
        req.getRequestDispatcher(responsePage).forward(req, resp);
    }
}
