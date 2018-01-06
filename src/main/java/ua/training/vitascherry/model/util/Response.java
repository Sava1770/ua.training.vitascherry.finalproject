package ua.training.vitascherry.model.util;

import static ua.training.vitascherry.controller.util.View.*;

public enum Response {
    HOME(HOME_PAGE),
    REGISTER_SUCCESS(REGISTER_SUCCESS_PAGE),
    REGISTER(REGISTER_PAGE),
    STUDENT_SIGNED_IN(STUDENT_SIGNED_PAGE),
    ADMIN_SIGNED_IN(ADMIN_SIGNED_PAGE),
    SIGN_IN(SIGN_IN_PAGE),
    SIGN_OUT(SIGN_OUT_PAGE),
    ERROR_403(ERROR_403_PAGE),
    ERROR_404(ERROR_404_PAGE),
    ERROR_405(ERROR_405_PAGE),
    ERROR_500(ERROR_500_PAGE),
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
