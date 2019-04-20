package com.models;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.Id;
/*import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;*/
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/*@CompoundIndexes({
        @CompoundIndex(name = "email-id", def = "{'firstName' : 1, 'lastName': 1}", unique=true)
})*/
@Document
public class Customer {
    @Id
    public String id;
    @Indexed(unique=true)
    private String authenticationId;
    private String city;
    private String name;
    private LocalDate dob;

    public Customer(String authenticationId, String city, String name, LocalDate dob) {
        this.authenticationId = authenticationId;
        this.city = city;
        this.name = name;
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }
    public String getAuthenticationId() {
        return authenticationId;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
    public void setAuthenticationId(String authenticationId){
        this.authenticationId = authenticationId;
    }
}
