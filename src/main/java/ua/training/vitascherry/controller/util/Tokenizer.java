package ua.training.vitascherry.controller.util;

public class Tokenizer {

    private static String[] tokenize(String path) {
        return path.split("/");
    }

    public static String getToken(String path, TokenPosition pos) {
        String[] tokens = tokenize(path);
        return tokens.length > 0 ? tokens[pos.getIndex()] : path;
    }
}
