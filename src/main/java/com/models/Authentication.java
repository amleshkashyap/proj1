package com.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Authentication {
    @Id
    private String id;

    @Indexed(unique = true)
    private String emailId;
    private String password;

    public Authentication(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }
}
