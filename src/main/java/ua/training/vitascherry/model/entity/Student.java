package ua.training.vitascherry.model.entity;

public class Student {
    private int id;
    private String email;
    private String firstName;
    private String lastName;

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
            Student.this.lastName = firstName;
            return this;
        }

        public Student build() {
            return Student.this;
        }
    }
}
