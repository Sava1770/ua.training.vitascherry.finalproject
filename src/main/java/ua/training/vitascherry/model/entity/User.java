package ua.training.vitascherry.model.entity;

import ua.training.vitascherry.model.util.Response;

public class User {

    private int id;
    private String email;
    private Role role;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private String patronymic;

    private User() {}

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getPasswordHash() {
        return passwordHash;
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

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", passwordHash='" + passwordHash + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }

    public static Builder builder() {
        return new User().new Builder();
    }

    public class Builder {

        public Builder setId(int id) {
            User.this.id = id;
            return this;
        }

        public Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public Builder setPasswordHash(String passwordHash) {
            User.this.passwordHash = passwordHash;
            return this;
        }

        public Builder setRole(Role role) {
            User.this.role = role;
            return this;
        }

        public Builder setFirstName(String firstName) {
            User.this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            User.this.lastName = lastName;
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            User.this.patronymic = patronymic;
            return this;
        }

        public User build() {
            return User.this;
        }
    }

    public enum Role {
        STUDENT(Response.STUDENT_SIGNED_IN),
        ADMIN(Response.ADMIN_SIGNED_IN);

        private Response response;

        Role(Response response) {
            this.response = response;
        }

        public Response getSignInResponse() {
            return response;
        }
    }
}
