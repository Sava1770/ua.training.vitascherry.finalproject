package ua.training.vitascherry.model.utils;

public class PathUtils {
    public static int extractId(String path) {
        String id = path.replaceAll("\\D+", "");
        return Integer.parseInt(id);
    }
}
