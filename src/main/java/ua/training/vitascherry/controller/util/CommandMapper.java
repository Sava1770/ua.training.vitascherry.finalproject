package ua.training.vitascherry.controller.util;

import ua.training.vitascherry.controller.command.Command;

import java.util.Map;

import static ua.training.vitascherry.controller.util.Router.INDEX_PAGE;
import static ua.training.vitascherry.controller.util.Tokenizer.getToken;

public class CommandMapper {
    public static Command extractCommand(String path, Map<String, Command> commands) {
        String token = getToken(path, TokenPosition.COMMAND);
        System.out.println("Command token: " + token);
        return commands.getOrDefault(token, responsePage -> INDEX_PAGE);
    }
}
