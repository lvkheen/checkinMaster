package com.lvkheen.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @Column(name = "authority")
    private String authority;
    @ManyToOne()
    @JoinColumn(name = "username")
    private User user;

    public Authorities() {
    }

    public Authorities(String authority){
        this.authority = authority;
    }


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
