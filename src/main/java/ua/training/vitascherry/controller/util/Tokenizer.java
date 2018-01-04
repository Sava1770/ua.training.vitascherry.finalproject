package ua.training.vitascherry.controller.util;

import java.util.HashMap;
import java.util.Map;

public class Tokenizer {

    private static String[] tokenize(String path) {
        return path.split("/");
    }

    private static Map<Integer, String> bind(String[] tokens) {
        Map<Integer, String> tokensPosition = new HashMap<>();
        for (int i = 0; i < tokens.length; ++i) {
            tokensPosition.put(i, tokens[i]);
        }
        return tokensPosition;
    }

    public static String extractToken(String path, TokenPosition pos) {
        Map<Integer, String> tokens = bind(tokenize(path));
        return tokens.getOrDefault(pos.getIndex(), path);
    }
}
