package ua.training.vitascherry.controller.util;

import java.util.regex.Pattern;

import static ua.training.vitascherry.controller.util.Regexp.*;

public enum RequestParameter {
    URI(URI_PATTERN),
    PAGE(PAGE_PATTERN),
    NAME(NAME_PATTERN),
    EMAIL(EMAIL_PATTERN),
    PASSWORD(PASSWORD_PATTERN);

    private final Pattern pattern;

    RequestParameter(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean isInvalid(String parameter) {
        return !pattern.matcher(parameter).matches();
    }
}
