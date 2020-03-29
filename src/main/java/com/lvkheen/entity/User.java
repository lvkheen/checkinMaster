package com.lvkheen.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private int enabled;

    @OneToMany(mappedBy = "user")
    private List<Authorities> authorities;

    public User() {
    }

    public User(String username, String password, int enabled, List<Authorities> authorities) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
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

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void add(Authorities newAuthority){
        if (authorities == null){
            authorities = new ArrayList<>();
        }
        authorities.add(newAuthority);
        newAuthority.setUser(this);
    }

}
