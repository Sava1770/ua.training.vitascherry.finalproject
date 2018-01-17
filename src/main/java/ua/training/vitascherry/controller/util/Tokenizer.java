package ua.training.vitascherry.controller.util;

public class Tokenizer {

    private static String[] tokenize(String path) {
        return path.split("/");
    }

    public static String extractToken(String path, Token token) {
        String[] tokens;
        if ((tokens = tokenize(path)).length > token.getPosition()) {
            return tokens[token.getPosition()];
        }
        return path;
    }
}
