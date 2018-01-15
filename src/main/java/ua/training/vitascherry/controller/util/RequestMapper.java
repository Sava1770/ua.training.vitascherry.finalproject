package ua.training.vitascherry.controller.util;

import ua.training.vitascherry.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;

public class RequestMapper {

    public static Command extractCommand(HttpServletRequest req, Map<String, Command> commands) {
        String token = extractToken(req.getRequestURI(), TokenPosition.COMMAND);
        return commands.getOrDefault(token, (request) -> Response.ERROR_404);
    }

    public static int extractId(HttpServletRequest req) {
        String token = extractToken(req.getRequestURI(), TokenPosition.ID);
        return Integer.parseInt(token);
    }

    public static int extractSolutionQuizId(HttpServletRequest req) {
        String token = extractToken(req.getRequestURI(), TokenPosition.SOLUTION_QUIZ_ID);
        return Integer.parseInt(token);
    }
}
