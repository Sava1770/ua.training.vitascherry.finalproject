package ua.training.vitascherry.controller.util;

public enum TokenPosition {
    COMMAND(1), ID(2), QUIZ_RESULT_ID(3);

    private int index;

    TokenPosition(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
