package ua.training.vitascherry.controller.util;

import ua.training.vitascherry.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static ua.training.vitascherry.controller.util.Constants.DEFAULT_OFFSET;
import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;
import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;

public class RequestMapper {

    public static Command extractCommand(HttpServletRequest req, Map<String, Command> commands) {
        String token = extractToken(req.getRequestURI(), Token.COMMAND);
        return commands.getOrDefault(token, (request) -> Response.NOT_FOUND);
    }

    public static int extractId(HttpServletRequest req) {
        String token = extractToken(req.getRequestURI(), Token.ID);
        return Integer.parseInt(token);
    }

    public static int extractSolutionQuizId(HttpServletRequest req) {
        String token = extractToken(req.getRequestURI(), Token.SOLUTION_QUIZ_ID);
        return Integer.parseInt(token);
    }

    public static int extractPageNumber(HttpServletRequest req) {
        int pageNumber = DEFAULT_OFFSET;
        if(req.getParameter("page") != null) {
            pageNumber = Integer.parseInt(req.getParameter("page"));
        }
        return pageNumber;
    }

    public static int calculatePagesCount(int recordsCount) {
        return (int)Math.ceil(((double)recordsCount) / RECORDS_PER_PAGE);
    }
}
