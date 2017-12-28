package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.impl.QuizCommand;
import ua.training.vitascherry.controller.command.impl.QuizListCommand;
import ua.training.vitascherry.controller.command.impl.StudentListCommand;
import ua.training.vitascherry.controller.command.impl.TopicsListCommand;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.model.service.StudentService;
import ua.training.vitascherry.model.service.TopicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {

    private static final String index = "/WEB-INF/view/index.jsp";

    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        commands.put("students", new StudentListCommand(StudentService.getInstance()));
        commands.put("topics", new TopicsListCommand(TopicService.getInstance()));
        commands.put("quizzes", new QuizListCommand(QuizService.getInstance()));
        commands.put("quiz", new QuizCommand(QuizService.getInstance()));
        System.out.println("Servlet was initialized!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String path = req.getRequestURI();
        String pathFull = req.getRequestURL().toString();
        System.out.println("\nIncoming GET request!");
        System.out.println("----- Request URI: " + path);
        System.out.println("----- Request URL: " + pathFull);
        System.out.println("Processing request...");

        String[] tokens = path.split("/");
        String token;
        if(tokens.length != 0) {
            token = tokens[1];
            System.out.println("----- Tokens: " + Arrays.toString(tokens));
        } else {
            token = path;
        }

        Command command = commands.getOrDefault(token, (r) -> index);
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

        // TODO

        System.out.println("POST was executed!\n");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet was destroyed!");
    }
}
