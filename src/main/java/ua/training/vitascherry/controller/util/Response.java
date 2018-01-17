package ua.training.vitascherry.controller.util;

import static ua.training.vitascherry.controller.util.Url.*;

public enum Response {
    HOME(HOME_PAGE),
    REGISTER_SUCCESS(REGISTER_SUCCESS_PAGE),
    REGISTER(REGISTER_PAGE),
    STUDENT_SIGNED_IN(STUDENT_SIGNED_PAGE),
    ADMIN_SIGNED_IN(ADMIN_SIGNED_PAGE),
    SIGN_IN(SIGN_IN_PAGE),
    SIGN_OUT(SIGN_OUT_PAGE),
    FORBIDDEN(FORBIDDEN_PAGE),
    NOT_FOUND(NOT_FOUND_PAGE),
    WAS_PASSED(WAS_PASSED_PAGE),
    SERVER_ERROR(SERVER_ERROR_PAGE),
    QUIZ_BODY(QUIZ_PAGE),
    QUIZ_RESULT(QUIZ_RESULT_PAGE),
    QUIZ_LIST(QUIZ_LIST_PAGE),
    TOPIC_LIST(TOPIC_LIST_PAGE),
    STUDENT_LIST(STUDENT_LIST_PAGE),
    STUDENT_PROFILE(STUDENT_PAGE),
    STUD_PROS(STUD_PROS_PAGE),
    STUD_PROS_LIST(STUD_PROS_LIST_PAGE);

    private String page;

    Response(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }
}
