package ua.training.vitascherry.controller.util;

public enum QuizParameterPosition {
    ID_QUESTION(0),
    ID_ANSWER(1);

    private int index;

    QuizParameterPosition(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
