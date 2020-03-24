package com.lvkheen.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Column(name = "username")
    @Id
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private int enabled;

    public User() {
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

}
