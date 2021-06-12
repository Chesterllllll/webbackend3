package com.webbackend.webbackend1.mapper;

import com.webbackend.webbackend1.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper {
    @Select("select * from comment where customer_id = #{custId}")
    List<Comment> findByCustId(@Param(value = "custId") int custId);

    @Insert("insert into comment(text,customer_id) values (#{text}, #{customerId)")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int create(Comment comment);
}
