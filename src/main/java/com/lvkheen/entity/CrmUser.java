package com.lvkheen.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CrmUser {

    private String username;
    private String password;

    public CrmUser() {
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
}
