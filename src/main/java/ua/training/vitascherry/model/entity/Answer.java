package ua.training.vitascherry.model.entity;

public class Answer {

    private int id;
    private String text;
    private Boolean isCorrect;

    private Question question;

    private Answer() {}

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        return id == answer.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Answer().new Builder();
    }

    public class Builder {

        public Builder setId(int id) {
            Answer.this.id = id;
            return this;
        }

        public Builder setText(String text) {
            Answer.this.text = text;
            return this;
        }

        public Builder setIsCorrect(boolean isCorrect) {
            Answer.this.isCorrect = isCorrect;
            return this;
        }

        public Builder setQuestion(Question question) {
            Answer.this.question = question;
            return this;
        }

        public Answer build() {
            return Answer.this;
        }
    }
}
