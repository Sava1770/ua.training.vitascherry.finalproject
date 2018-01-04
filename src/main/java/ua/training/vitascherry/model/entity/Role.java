package ua.training.vitascherry.model.entity;

import static ua.training.vitascherry.controller.util.View.ADMIN_SIGNED_PAGE;
import static ua.training.vitascherry.controller.util.View.STUDENT_SIGNED_PAGE;

public enum Role {
    STUDENT(STUDENT_SIGNED_PAGE),
    ADMIN(ADMIN_SIGNED_PAGE);

    private String welcomePage;

    Role(String welcomePage) {
        this.welcomePage = welcomePage;
    }

    public String getWelcomePage() {
        return welcomePage;
    }
}
