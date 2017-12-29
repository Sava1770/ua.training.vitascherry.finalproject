package ua.training.vitascherry.model.entity;

public class Student {

    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String patronymic;

    private Student() {}

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Student().new Builder();
    }

    public class Builder {

        public Builder setId(int id) {
            Student.this.id = id;
            return this;
        }

        public Builder setEmail(String email) {
            Student.this.email = email;
            return this;
        }

        public Builder setFirstName(String firstName) {
            Student.this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            Student.this.lastName = lastName;
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            Student.this.patronymic = patronymic;
            return this;
        }

        public Student build() {
            return Student.this;
        }
    }
}
