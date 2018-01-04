package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.impl.*;
import ua.training.vitascherry.controller.util.TokenPosition;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;

public class MainServlet extends HttpServlet {

    private final Map<String, Command> commands = new HashMap<>();
    private final Command NOT_FOUND = new NotFound();

    @Override
    public void init() throws ServletException {
        commands.put("/", new Home());
        commands.put("students", new StudentList());
        commands.put("student", new StudentProfile());
        commands.put("progress", new StudentProgressList());
        commands.put("topics", new TopicList());
        commands.put("topic", new QuizCatalogue());
        commands.put("quizzes", new QuizList());
        commands.put("quiz", new PassQuiz());
        commands.put("result", new QuizResult());
        commands.put("signin", new SignIn());
        commands.put("signout", new SignOut());
        commands.put("register", new Register());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("\nProcessing doGET()...");
        String token = extractToken(request.getRequestURI(), TokenPosition.COMMAND);
        System.out.println("Token: " + token);
        Command command = commands.getOrDefault(token, NOT_FOUND);
        String responsePage = command.execute(request);
        System.out.println("Response page: " + responsePage);
        request.getRequestDispatcher(responsePage).forward(request, response);
    }
}
