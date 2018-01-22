package ua.training.vitascherry.controller.util;

import java.util.Arrays;

public class Tokenizer {

    private static String[] tokenize(String path) {
        return path.split("/");
    }

    public static String extractToken(String path, Token token) {
        String[] tokens = tokenize(path);
        if (tokens.length > token.getPosition()) {
            return tokens[token.getPosition()];
        }
        return path;
    }
}
