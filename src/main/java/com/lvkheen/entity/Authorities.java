package com.lvkheen.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities {

//    @Id
//    @Column(name = "username")
//    private String username;
    @Id
    @Column(name = "authority")
    private String authority;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User user;

    public Authorities() {
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
