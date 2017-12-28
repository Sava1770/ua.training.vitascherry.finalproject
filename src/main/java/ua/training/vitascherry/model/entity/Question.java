package ua.training.vitascherry.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private int id;
    private String text;

    private List<Answer> answers = new ArrayList<>();

    private Question() {}

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return id == question.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", answers=" + answers +
                '}';
    }

    public static Builder builder() {
        return new Question().new Builder();
    }

    public class Builder {

        public Builder setId(int id) {
            Question.this.id = id;
            return this;
        }

        public Builder setText(String text) {
            Question.this.text = text;
            return this;
        }

        public Question build() {
            return Question.this;
        }
    }
}
