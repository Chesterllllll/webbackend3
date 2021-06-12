package com.webbackend.webbackend1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class Comment {
    private Long id;
    private String text;
    @JsonIgnore
    private Long CustomerId;
}
