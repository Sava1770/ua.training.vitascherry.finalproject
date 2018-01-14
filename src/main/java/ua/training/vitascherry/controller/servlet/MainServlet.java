package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.impl.*;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ua.training.vitascherry.controller.util.RequestMapper.extractCommand;

public class MainServlet extends HttpServlet {

    private Map<String, Command> doGetCommands = new HashMap<>();
    private Map<String, Command> doPostCommands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        initDoGetCommands();
        initDoPostCommands();
    }

    private void initDoGetCommands() {
        StudentProgressService studProService =
                new StudentProgressService(DaoFactory.getInstance());
        StudentService studentService =
                new StudentService(DaoFactory.getInstance());
        TopicService topicService =
                new TopicService(DaoFactory.getInstance());
        QuizService quizService =
                new QuizService(DaoFactory.getInstance());
        doGetCommands.put("progresses", new StudentProgressList(studProService));
        doGetCommands.put("available", new AvailableQuizzes(quizService));
        doGetCommands.put("student", new StudentProfile(studentService));
        doGetCommands.put("students", new StudentList(studentService));
        doGetCommands.put("progress", new MyProgress(studProService));
        doGetCommands.put("topic", new QuizCatalogue(topicService));
        doGetCommands.put("topics", new TopicList(topicService));
        doGetCommands.put("result", new Solution(quizService));
        doGetCommands.put("quizzes", new QuizList(quizService));
        doGetCommands.put("quiz", new PassQuiz(quizService));
        doGetCommands.put("signout", new SignOut());
        doGetCommands.put("register", (request) -> Response.REGISTER);
        doGetCommands.put("signin", (request) -> Response.SIGN_IN);
        doGetCommands.put("/", (request) -> Response.HOME);
    }

    private void initDoPostCommands() {
        SolutionService solutionService =
                new SolutionService(DaoFactory.getInstance());
        SignInService signInService =
                new SignInService(DaoFactory.getInstance());
        RegisterService registerService =
                new RegisterService(DaoFactory.getInstance());
        doPostCommands.put("signin", new SignIn(signInService));
        doPostCommands.put("register", new Register(registerService));
        doPostCommands.put("quiz", new SubmitSolution(solutionService));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Command command = extractCommand(req, doGetCommands);
        req.getRequestDispatcher(command.execute(req).getPage()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Command command = extractCommand(req, doPostCommands);
        req.getRequestDispatcher(command.execute(req).getPage()).forward(req, resp);
    }
}
