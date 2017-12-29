package ua.training.vitascherry.model.utils;

public class Tokenizer {

    private static String[] tokenize(String path) {
        return path.split("/");
    }

    public static int extractId(String path) {
        String id = path.replaceAll("\\D+", "");
        return Integer.parseInt(id);
    }

    public static String extractCommand(String path) {
        String[] tokens = tokenize(path);
        return tokens.length > 0 ? tokens[1] : path;
    }
}
