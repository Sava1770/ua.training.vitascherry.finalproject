package ua.training.vitascherry.model.entity;

public class User {

    private int id;
    private String email;
    private String passwordHash;
    private Role role;

    private User() {}

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Role getRole() {
        return role;
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
                ", passwordHash='" + passwordHash + '\'' +
                ", role=" + role +
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

        public User build() {
            return User.this;
        }
    }
}
