package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.impl.*;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.model.service.StudentProgressService;
import ua.training.vitascherry.model.service.TopicService;
import ua.training.vitascherry.model.service.StudentService;

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
        StudentService studentService = new StudentService(DaoFactory.getInstance());
        QuizService quizService = new QuizService(DaoFactory.getInstance());
        commands.put("/", new Home());
        commands.put("students", new StudentList(studentService));
        commands.put("student", new StudentProfile(studentService));
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
        req.getRequestDispatcher(command.execute(req).getPage()).forward(req, resp);
    }
}
