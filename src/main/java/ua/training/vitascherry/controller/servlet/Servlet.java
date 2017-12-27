package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.impl.StudentListCommand;
import ua.training.vitascherry.model.entity.Student;
import ua.training.vitascherry.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Servlet extends HttpServlet {

    private static String index = "/WEB-INF/view/index.jsp";

    private StudentService studentService = new StudentService();
    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        commands.put("students", new StudentListCommand(studentService));
        System.out.println("Servlet was initialized!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String path = req.getRequestURI();
        String pathFull = req.getRequestURL().toString();
        System.out.println("\nIncoming GET request!");
        System.out.println("----- Request URI: " + path);
        System.out.println("----- Request URL: " + pathFull);
        System.out.println("Processing request...");

        path = path.replaceAll("/" , "");
        Command command = commands.getOrDefault(path , (r) -> index);
        String page = command.execute(req);
        System.out.println("Response page: " + page);

        req.getRequestDispatcher(page).forward(req, resp);
        System.out.println("GET was executed!\n");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String path = req.getRequestURI();
        String pathFull = req.getRequestURL().toString();
        System.out.println("\nIncoming POST request!");
        System.out.println("----- Request URI: " + path);
        System.out.println("----- Request URL: " + pathFull);
        System.out.println("Processing request...");

        List<Student> students = studentService.getAllStudents();
        req.setAttribute("students" , students);

        req.getRequestDispatcher("/WEB-INF/view/student_list.jsp").forward(req, resp);
        System.out.println("POST was executed!\n");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet was destroyed!");
    }
}
