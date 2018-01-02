package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.TokenPosition;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.Router.ERROR_PAGE;
import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;

public class QuizResult implements Command {

    private final QuizService quizService = new QuizService();

    @Override
    public String execute(HttpServletRequest req) {
        String path = req.getRequestURI();
        int studentId = Integer.parseInt(extractToken(path, TokenPosition.ID));
        int quizId = Integer.parseInt(extractToken(path, TokenPosition.QUIZ_RESULT_ID));
        Quiz quiz = quizService.getQuizById(quizId);
        if (quiz == null) {
            return ERROR_PAGE;
        }
        Quiz result = quizService.getResultByStudentIdQuizId(studentId, quizId);
        if (result == null) {
            return ERROR_PAGE;
        }
        req.setAttribute("quiz", quiz);
        req.setAttribute("result" , result);
        return "/WEB-INF/view/quiz_result.jsp";
    }
}
