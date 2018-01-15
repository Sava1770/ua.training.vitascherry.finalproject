package ua.training.vitascherry.controller.util;

class Validator {

    private static final String[] regexps = new String[]{
            "^/$",
            "^/[a-z]+$",
            "^/[a-z]+/$",
            "^/[a-z]+/[0-9]+$",
            "^/[a-z]+/[0-9]+/$",
            "^/[a-z]+/[0-9]+/[0-9]+$",
            "^/[a-z]+/[0-9]+/[0-9]+/$"
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
