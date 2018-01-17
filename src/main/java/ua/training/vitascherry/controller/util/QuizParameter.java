package ua.training.vitascherry.controller.util;

public enum QuizParameter {
    ID_QUESTION(0),
    ID_ANSWER(1);

    private int position;

    QuizParameter(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
