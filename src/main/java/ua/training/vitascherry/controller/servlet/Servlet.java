package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.impl.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ua.training.vitascherry.controller.util.CommandMapper.extractCommand;

public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        commands.put("home", new Home());
        commands.put("students", new StudentList());
        commands.put("student", new StudentInfo());
        commands.put("progress", new StudentProgressList());
        commands.put("topics", new TopicList());
        commands.put("topic", new QuizListByTopic());
        commands.put("quizzes", new QuizList());
        commands.put("quiz", new PassQuiz());
        commands.put("result", new QuizResult());
        commands.put("login", new Login());
        commands.put("authorized", new Authorized());
        commands.put("register", new Register());
        commands.put("registered", new Registered());
        System.out.println("Servlet was initialized!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getRequestURI();
        String pathFull = req.getRequestURL().toString();
        String params = req.getQueryString();
        System.out.println("\nIncoming GET request!");
        System.out.println("----- Request URI: " + path);
        System.out.println("----- Request URL: " + pathFull);
        System.out.println("----- Request Params: " + params);
        System.out.println("Processing request...");

        Command command = extractCommand(path, commands);
        String responsePage = command.execute(req);
        System.out.println("Response page: " + responsePage);

        req.getRequestDispatcher(responsePage).forward(req, resp);
        System.out.println("GET was executed!\n");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String path = req.getRequestURI();
        String pathFull = req.getRequestURL().toString();
        String params = req.getQueryString();
        System.out.println("\nIncoming GET request!");
        System.out.println("----- Request URI: " + path);
        System.out.println("----- Request URL: " + pathFull);
        System.out.println("----- Request Params: " + params);
        System.out.println("Processing request...");

        Command command = extractCommand(path, commands);
        String responsePage = command.execute(req);
        System.out.println("Response page: " + responsePage);

        req.getRequestDispatcher(responsePage).forward(req, resp);
        System.out.println("POST was executed!\n");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet was destroyed!");
    }
}
