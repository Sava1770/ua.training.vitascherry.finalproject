package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.GetCommandMap;
import ua.training.vitascherry.model.entity.Answer;
import ua.training.vitascherry.model.entity.Question;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.service.SolutionService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static ua.training.vitascherry.controller.util.RequestMapper.extractSolutionQuizId;
import static ua.training.vitascherry.model.dao.util.AnswerMapper.extractAnswer;
import static ua.training.vitascherry.model.dao.util.QuestionMapper.extractQuestion;
import static ua.training.vitascherry.model.dao.util.UniqueValueMapper.extractUniqueValue;

public class SubmitSolution implements Command {

    private SolutionService service;

    public SubmitSolution(SolutionService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user.getRole().equals(User.Role.ADMIN)) {
            return Response.ADMIN_SIGNED_IN;
        }
        Quiz quiz = Quiz.builder().setId(extractSolutionQuizId(req)).build();
        Map<Integer, Question> uniqueQuestions = new HashMap<>();
        Enumeration<String> en = req.getParameterNames();
        while (en.hasMoreElements()) {
            String[] solutionParameters = en.nextElement().split(" ");
            Question question = extractQuestion(solutionParameters);
            question = extractUniqueValue(uniqueQuestions, question.getId(), question);
            Answer answer = extractAnswer(solutionParameters);
            question.getAnswers().add(answer);
        }
        quiz.getQuestions().addAll(uniqueQuestions.values());
        if (!service.createStudentSolution(user, quiz)) {
            return Response.SERVER_ERROR;
        }
        return GetCommandMap.getInstance().get("result").execute(req);
    }
}
