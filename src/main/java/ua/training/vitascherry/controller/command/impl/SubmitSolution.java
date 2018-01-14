package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.entity.Answer;
import ua.training.vitascherry.model.entity.Question;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.model.service.SolutionService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
        Quiz quiz = null;
        Map<Integer, Question> uniqueQuestions = new HashMap<>();
        Enumeration<String> en = req.getParameterNames();
        if (en.hasMoreElements()) {
            String[] quizQuestionAnswerIds = en.nextElement().split(",");
            quiz = Quiz.builder().setId(Integer.parseInt(quizQuestionAnswerIds[0])).build();
            while (en.hasMoreElements()) {
                quizQuestionAnswerIds = en.nextElement().split(",");
                Question question = Question.builder().setId(Integer.parseInt(quizQuestionAnswerIds[1])).build();
                question = uniqueQuestions.putIfAbsent(question.getId(), question);
                Answer answer = Answer.builder().setId(Integer.parseInt(quizQuestionAnswerIds[2])).build();
                question.getAnswers().add(answer);
            }
            quiz.getQuestions().addAll(uniqueQuestions.values());
        }
        service.createStudentSolution(user, quiz);
        if (!service.getResponse().equals(Response.QUIZ_RESULT)) {
            return Response.ERROR_500;
        }
        return new Solution(new QuizService(DaoFactory.getInstance()))
                .execute(req);
    }
}
