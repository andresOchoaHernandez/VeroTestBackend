package com.andresochoahernandez.verotest.model.agents;

import jakarta.persistence.*;

@Entity
@Table(name = "user", schema = "public", catalog = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar")
    private String username;
    @Column(columnDefinition = "varchar")
    private String password;
    @Column(columnDefinition = "varchar")
    private String roles;

    public User(){}

    public User(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
