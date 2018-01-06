package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.impl.*;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.model.service.StudentProgressService;
import ua.training.vitascherry.model.service.TopicService;
import ua.training.vitascherry.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ua.training.vitascherry.controller.util.RequestMapper.extractCommand;

public class MainServlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        TopicService topicService = new TopicService(DaoFactory.getInstance());
        StudentProgressService studProService = new StudentProgressService(DaoFactory.getInstance());
        UserService userService = new UserService(DaoFactory.getInstance());
        QuizService quizService = new QuizService(DaoFactory.getInstance());
        commands.put("/", new Home());
        commands.put("students", new StudentList(userService));
        commands.put("student", new StudentProfile(userService));
        commands.put("progresses", new StudentProgressList(studProService));
        commands.put("progress", new MyProgress(studProService));
        commands.put("topics", new TopicList(topicService));
        commands.put("topic", new QuizCatalogue(topicService));
        commands.put("quizzes", new QuizList(quizService));
        commands.put("available", new AvailableQuizzes(quizService));
        commands.put("quiz", new PassQuiz(quizService));
        commands.put("result", new QuizResult(quizService));
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
