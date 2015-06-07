package com.htds.spring.samples.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Hasan
 * on 4.6.2015.
 */
@Entity
@Table(name = "T_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp = "^[a-z0-9]*$")
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @NotNull
    @Size(min = 5, max = 100)
    @Column(name = "password_hash", length = 100)
    private String passwordHash;

    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Email
    @Size(max = 100)
    @Column(length = 100, unique = true)
    private String email;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Transient
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    // We provide login as the hashcode since id is given by hibernate
    @Override
    public int hashCode() {
        return login.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        // If objects are the same then they are equal
        if (this == o) {
            return true;
        }
        // If object is null or of a different class, then they are not equal
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // All that's left is checking logins - which are unique -
        // If logins are same then objects are equal.
        User user = (User) o;
        return login.equals(user.getLogin());
    }

    @Override
    public String toString() {
        return String.format(
                "User{id: %d, name: '%s', login: '%s', email: '%s'}",
                getId(), getFullName(), getLogin(), getEmail()
        );
    }
}
