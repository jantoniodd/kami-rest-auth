package com.jadd.kamirestauth.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jadd.kamirestauth.enums.RoleEnum;

@Document(collation = "users")
public class UserEntity {

    @Id
    private String id;

    private String username;

    private String password;

    private List<RoleEnum> roles;

    public UserEntity() {
    }

    public UserEntity(String id, String username, String password, List<RoleEnum> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

}
