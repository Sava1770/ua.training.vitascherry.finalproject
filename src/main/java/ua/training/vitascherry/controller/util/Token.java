package ua.training.vitascherry.controller.util;

public enum Token {
    COMMAND(1),
    ID(2),
    SOLUTION_QUIZ_ID(3);

    private final int position;

    Token(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
