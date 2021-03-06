package com.webbackend.webbackend1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.beans.IntrospectionException;
import java.util.Date;

@Data
public class SecondCustomer {
    private Integer id;

    @JsonProperty("person-name")
    private String name;

    @JsonIgnore
    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @JsonView(Views.Public.class)
    private Integer follower;

    @JsonView(Views.Internal.class)
    private String password;

    @JsonView(Views.Internal.class)
    private String email;

    public SecondCustomer(String email, String password, Integer follower) {
        this.follower = follower;
        this.email = email;
        this.password = password;
    }

}
