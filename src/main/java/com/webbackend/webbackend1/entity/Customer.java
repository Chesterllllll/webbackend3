package com.webbackend.webbackend1.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Singular;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

//@Data
//@Entity
//public class Customer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    private Long id;
//
//    @Size(min = 3, max = 30)
//    @Pattern(regexp = "^[a-z]+$", message = "用户名必须是a-z小字母")
//    private String username;
//
//    @Size(min = 6, max = 6)
//    @Pattern(regexp = "^[0-9]+$", message = "密码必须是6位数字")
//    private String password;
//
//    @Range(min = 1, max = 9999, message = "范围只能1到9999")
//    private Integer follower;
//
//    @NotNull(message = "邮箱不能为Null")
//    @Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
//            message = "邮箱格式有误")
//    private String email;
//}

@Data
@Schema
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-z]+$", message = "用户名必须是a-z小字母")
    private String username;

    @Size(min = 6, max = 6)
    @Pattern(regexp = "^[0-9]+$", message = "密码必须是6位数字")
    private String password;

    @Range(min = 1, max = 9999, message = "范围只能1到9999")
    private Integer follower;

    @NotNull(message = "邮箱不能为Null")
    @Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
            message = "邮箱格式有误")
    private String email;
}
