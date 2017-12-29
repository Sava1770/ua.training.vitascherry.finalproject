package ua.training.vitascherry.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private int id;
    private String name;

    private List<Quiz> quizzes = new ArrayList<>();

    private Topic() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        return id == topic.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Topic().new Builder();
    }

    public class Builder {

        public Builder setId(int id) {
            Topic.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Topic.this.name = name;
            return this;
        }

        public Topic build() {
            return Topic.this;
        }
    }
}
