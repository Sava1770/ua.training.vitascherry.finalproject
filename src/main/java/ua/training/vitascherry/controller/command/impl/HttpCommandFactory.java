package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.CommandFactory;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.service.*;

import java.util.HashMap;
import java.util.Map;

public class HttpCommandFactory extends CommandFactory {

    @Override
    public Map<String, Command> createGetCommands() {
        StudentProgressService studProService =
                new StudentProgressService(DaoFactory.getInstance());
        StudentService studentService =
                new StudentService(DaoFactory.getInstance());
        TopicService topicService =
                new TopicService(DaoFactory.getInstance());
        QuizService quizService =
                new QuizService(DaoFactory.getInstance());
        Map<String, Command> commands = new HashMap<>();
        commands.put("progresses", new StudentProgressList(studProService));
        commands.put("available", new AvailableQuizzes(quizService));
        commands.put("student", new StudentProfile(studentService));
        commands.put("students", new StudentList(studentService));
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
                new SolutionService(DaoFactory.getInstance());
        SignInService signInService =
                new SignInService(DaoFactory.getInstance());
        RegisterService registerService =
                new RegisterService(DaoFactory.getInstance());
        Map<String, Command> commands = new HashMap<>();
        commands.put("signin", new SignIn(signInService));
        commands.put("register", new Register(registerService));
        commands.put("result", new SubmitSolution(solutionService));
        return commands;
    }
}
