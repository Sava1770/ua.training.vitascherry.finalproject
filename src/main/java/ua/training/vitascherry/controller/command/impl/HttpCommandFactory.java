package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.CommandFactory;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.service.*;
import ua.training.vitascherry.model.service.impl.*;

import java.util.HashMap;
import java.util.Map;

public class HttpCommandFactory extends CommandFactory {

    @Override
    public Map<String, Command> createGetCommands() {
        StudentProgressService studProService =
                new StudentProgressServiceImpl(DaoFactory.getInstance());
        UserServiceImpl userService =
                new UserServiceImpl(DaoFactory.getInstance());
        TopicService topicService =
                new TopicServiceImpl(DaoFactory.getInstance());
        QuizService quizService =
                new QuizServiceImpl(DaoFactory.getInstance());
        Map<String, Command> commands = new HashMap<>();
        commands.put("progresses", new StudentProgressList(studProService));
        commands.put("available", new AvailableQuizzes(quizService));
        commands.put("student", new StudentProfile(userService));
        commands.put("students", new StudentList(userService));
        commands.put("progress", new MyProgress(studProService));
        commands.put("topic", new QuizCatalogue(topicService));
        commands.put("topics", new TopicList(topicService));
        commands.put("result", new QuizSolution(quizService));
        commands.put("quizzes", new QuizList(quizService));
        commands.put("quiz", new PassQuiz(quizService));
        commands.put("signout", new SignOut());
        commands.put("register", (request) -> Response.REGISTER);
        commands.put("signin", (request) -> Response.SIGN_IN);
        commands.put("/", (request) -> Response.HOME);
        return commands;
    }

    @Override
    public Map<String, Command> createPostCommands() {
        SolutionService solutionService =
                new SolutionServiceImpl(DaoFactory.getInstance());
        UserService userService =
                new UserServiceImpl(DaoFactory.getInstance());
        Map<String, Command> commands = new HashMap<>();
        commands.put("result", new SubmitSolution(solutionService));
        commands.put("register", new Register(userService));
        commands.put("signin", new SignIn(userService));
        commands.put("/", new ChangeLocale());
        return commands;
    }
}
