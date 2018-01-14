package ua.training.vitascherry.controller.util;

import static ua.training.vitascherry.controller.util.Validator.validate;

public class Tokenizer {

    private static String[] tokenize(String path) {
        return path.split("/");
    }

    public static String extractToken(String path, TokenPosition pos) {
        if (validate(path)) {
            String[] tokens = tokenize(path);
            return tokens.length > pos.getIndex() ? tokens[pos.getIndex()] : path;
        }
        return "never/gonna/give/you/up";
    }
}
