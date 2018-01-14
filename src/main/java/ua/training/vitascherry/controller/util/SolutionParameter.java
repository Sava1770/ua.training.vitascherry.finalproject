package ua.training.vitascherry.controller.util;

public enum SolutionParameter {
    ID_QUESTION(0),
    ID_ANSWER(1);

    private int index;

    SolutionParameter(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
