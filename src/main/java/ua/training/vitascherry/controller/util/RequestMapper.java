package ua.training.vitascherry.controller.util;

import ua.training.vitascherry.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static ua.training.vitascherry.controller.util.Constants.DEFAULT_PAGE_NUMBER;
import static ua.training.vitascherry.controller.util.Constants.DEFAULT_PAGE_COUNT;
import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;
import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;

public class RequestMapper {

    public static Command extractCommand(HttpServletRequest req, Map<String, Command> commands) {
        String token = extractToken(req.getRequestURI(), Token.COMMAND);
        return commands.getOrDefault(token, request -> Response.NOT_FOUND);
    }

    public static int extractId(HttpServletRequest req) throws MissingTokenException {
        try {
            String token = extractToken(req.getRequestURI(), Token.ID);
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new MissingTokenException();
        }
    }

    public static int extractSolutionQuizId(HttpServletRequest req) throws MissingTokenException {
        try {
            String token = extractToken(req.getRequestURI(), Token.SOLUTION_QUIZ_ID);
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new MissingTokenException();
        }
    }

    public static int extractPageNumber(HttpServletRequest req) {
        String pageParam = req.getParameter("page");
        if(pageParam == null ||  RequestParameter.PAGE.isInvalid(pageParam)) {
            return DEFAULT_PAGE_NUMBER;
        }
        return Integer.parseInt(pageParam);
    }

    public static int calculatePagesCount(int recordsCount) {
        return recordsCount == 0 ? DEFAULT_PAGE_COUNT : (int)Math.ceil(((double)recordsCount) / RECORDS_PER_PAGE);
    }
}
