package com.webbackend.webbackend1.dto;

import com.webbackend.webbackend1.entity.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema
public class CustomerWithComments{
    private Long id;
    private String username;
    List<Comment> commentList;
}
