package ua.training.vitascherry.model.entity;

public class Topic {

    private int id;
    private String name;

    private Topic() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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
