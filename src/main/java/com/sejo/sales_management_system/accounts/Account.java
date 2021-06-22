package com.sejo.sales_management_system.accounts;

import javax.persistence.*;

@Entity(name = "Account")
@Table(
        name = "account",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "staff_email_unique",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "staff_username_unique",
                        columnNames = "username"
                )
        })
public class Account {

    //Variable Declarations
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    //Email
    @Column(
            name = "email",
            nullable = false
    )
    private String email;

    //Username
    @Column(
            name = "username",
            nullable = false
    )
    private String username;

    //Password
    @Column(
            name = "password",
            nullable = false
    )
    private String password;

    //UserID
    @Column(
            name = "user_id",
            nullable = false
    )
    private Long userId;


    //Constructors
    public Account() {
    }

    public Account(String email, String username, String password, Long userId) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    //ToString Override
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                '}';
    }
}
