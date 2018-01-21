package ua.training.vitascherry.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private int id;
    private String name;

    private List<Question> questions = new ArrayList<>();

    private Topic topic;

    private Quiz() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quiz quiz = (Quiz) o;

        return id == quiz.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Quiz().new Builder();
    }

    public class Builder {

        public Builder setId(int id) {
            Quiz.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Quiz.this.name = name;
            return this;
        }

        public Builder setQuestions(List<Question> questions) {
            Quiz.this.questions = questions;
            return this;
        }

        public Quiz build() {
            return Quiz.this;
        }
    }
}
