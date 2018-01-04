package ua.training.vitascherry.controller.util;

class Validator {
    private static final String[] regexps = new String[]{
            "",
            "^/$",
            "^/\\w+$",
            "^/\\w+/$",
            "^/\\w+/\\d+$",
            "^/\\w+/\\d+/$",
            "^/\\w+/\\d+/\\d+$",
            "^/\\w+/\\d+/\\d+/$"
    };

    static boolean validate(String path) {
        for (String regexp : regexps) {
            if (path.matches(regexp)) {
                return true;
            }
        }
        return false;
    }
}
