package com.gustavosantospro.softgu.model.user;

import lombok.Data;
import lombok.Getter;


public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
