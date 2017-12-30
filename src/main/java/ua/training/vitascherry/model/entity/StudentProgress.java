package ua.training.vitascherry.model.entity;

public class StudentProgress {

    private Student student;
    private Quiz quiz;
    private int correctCount;
    private int questionCount;

    private StudentProgress() {}

    public Student getStudent() {
        return student;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    @Override
    public String toString() {
        return "StudentProgress{" +
                "student=" + student +
                ", quiz=" + quiz +
                ", correctCount=" + correctCount +
                ", questionCount=" + questionCount +
                '}';
    }

    public static Builder builder() {
        return new StudentProgress().new Builder();
    }

    public class Builder {

        public Builder setStudent(Student student) {
            StudentProgress.this.student = student;
            return this;
        }

        public Builder setQuiz(Quiz quiz) {
            StudentProgress.this.quiz = quiz;
            return this;
        }

        public Builder setCorrectCount(int correct) {
            StudentProgress.this.correctCount = correct;
            return this;
        }

        public Builder setQuestionCount(int questionCount) {
            StudentProgress.this.questionCount = questionCount;
            return this;
        }

        public StudentProgress build() {
            return StudentProgress.this;
        }
    }
}
