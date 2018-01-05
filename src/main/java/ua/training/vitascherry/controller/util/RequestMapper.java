package ua.training.vitascherry.controller.util;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.impl.NotFound;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;

public class RequestMapper {

    private static final Command NOT_FOUND = new NotFound();

    public static Command extractCommand(HttpServletRequest req, Map<String, Command> commands) {
        String token = extractToken(req.getRequestURI(), TokenPosition.COMMAND);
        return commands.getOrDefault(token, NOT_FOUND);
    }

    public static int extractPrimaryId(HttpServletRequest req) {
        int id = 0;
        String token = extractToken(req.getRequestURI(), TokenPosition.PRIMARY_ID);
        try {
            id = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int extractSecondaryId(HttpServletRequest req) {
        int id = 0;
        String token = extractToken(req.getRequestURI(), TokenPosition.SECONDARY_ID);
        try {
            id = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return id;
    }
}
