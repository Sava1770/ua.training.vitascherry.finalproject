package ua.training.vitascherry.controller.util;

import static ua.training.vitascherry.controller.util.Validator.validate;

public class Tokenizer {

    private static String[] tokenize(String path) {
        return path.split("/");
    }

    public static String extractToken(String path, TokenPosition pos) {
        String[] tokens;
        if (validate(path) && (tokens = tokenize(path)).length > pos.getIndex()) {
            return tokens[pos.getIndex()];
        }
        return path;
    }
}
