package ua.training.vitascherry.controller.util;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.UNICODE_CHARACTER_CLASS;

public interface Regexp {

    Pattern NAME_PATTERN = Pattern.compile(
            "^.{2,}$",
            UNICODE_CHARACTER_CLASS
    );

    Pattern PASSWORD_PATTERN = Pattern.compile(
            ".{8,}$",
            UNICODE_CHARACTER_CLASS
    );

    Pattern EMAIL_PATTERN = Pattern.compile(
            "^[-a-z0-9!#$%&'*+/=?^_`{|}~]+" +
            "(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*" +
            "@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*" +
            "(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil" +
            "|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$"
    );

    Pattern URI_PATTERN = Pattern.compile(
            "^/|" +
            "(/[a-z]+)|" +
            "(/[a-z]+/)|" +
            "(/[a-z]+/[0-9]+)|" +
            "(/[a-z]+/[0-9]+/)|" +
            "(/[a-z]+/[0-9]+/[0-9]+)|" +
            "(/[a-z]+/[0-9]+/[0-9]+/)|" +
            "(/.*\\.css)|" +
            "(/.*\\.ico)|" +
            "(/.*\\.js)$"
    );
}
