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

import static ua.training.vitascherry.controller.util.RequestMapper.extractCommand;

public class MainServlet extends HttpServlet {

    private final Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        commands.put("/", new Home());
        commands.put("students", new StudentList());
        commands.put("student", new StudentProfile());
        commands.put("progresses", new StudentProgressList());
        commands.put("progress", new MyProgress());
        commands.put("topics", new TopicList());
        commands.put("topic", new QuizCatalogue());
        commands.put("quizzes", new QuizList());
        commands.put("available", new AvailableQuizzes());
        commands.put("quiz", new PassQuiz());
        commands.put("result", new QuizResult());
        commands.put("signin", new SignIn());
        commands.put("signout", new SignOut());
        commands.put("register", new Register());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Command command = extractCommand(req, commands);
        req.getRequestDispatcher(command.execute(req)).forward(req, resp);
    }
}
