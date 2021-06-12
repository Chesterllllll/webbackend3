package com.webbackend.webbackend1.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.webbackend.webbackend1.Service.CustomerService;
import com.webbackend.webbackend1.common.Result;
import com.webbackend.webbackend1.entity.Comment;
import com.webbackend.webbackend1.entity.Customer;
import com.webbackend.webbackend1.entity.Views;
import com.webbackend.webbackend1.mapper.CommentMapper;
import com.webbackend.webbackend1.mapper.CustomerMapper;
import com.webbackend.webbackend1.repository.CustomerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "MyController v3", description = "WebBackend1 Controller")
//@RequestMapping("/api/v1/webbackend1")
@RequestMapping("/webbackend1v2")
public class MyController {
//    final
//    CustomerRepository customerRepository;

    @Resource
    CustomerMapper customerMapper;
    @Resource
    CommentMapper commentMapper;


//    @Autowired
//    public MyController(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }


    @Operation(summary = "登录", description = "登录界面，登陆成功返回该用户首页，登录失败，返回登录界面")
    @GetMapping(path = "/login")
    public String Login(
            @Parameter(description = "用户") @Valid @RequestBody Customer customer
    ) {
//        String username = customer.getUsername();
//        String password = customer.getPassword();
        Customer tempCus = customerMapper.findByUsername(customer.getUsername());
        if (customer.getUsername().equals(tempCus.getUsername()) && customer.getPassword().equals(tempCus.getPassword())) {
            return "登陆成功";
        }
        return "登陆失败 用户名或密码错误";
    }

    @Operation(summary = "注册", description = "注册界面")
    @PostMapping(path = "/register")
    public String Register(
            @Parameter(description = "用户") @Valid @RequestBody Customer customer) throws Exception {
        if(customerMapper.findByUsername(customer.getUsername()) == null)
        {
            customerMapper.create(customer);
            return "注册成功";
        }
        return "注册失败 用户名已存在";
    }

    @Operation(summary = "用户信息显示", description = "用户信息显示")
    @GetMapping(path = "/user")
    @JsonView(Views.Internal.class)
    public Result<?> ShowCustomerInfo(@Parameter(description = "用户授权码") String access_token) throws Exception {
        List<Customer> customers = customerMapper.findAll();
        return Result.ok(customers);
    }

    @Operation(summary = "用户信息编辑", description = "用户信息编辑")
    @PatchMapping(path = "/user/{id}")
    public String UpdateCustomerInfo(@PathVariable Long id, @Parameter(description = "用户授权码") String access_token,
                                     @Parameter(description = "用户名") String username) throws Exception {
        customerMapper.findById(id).setUsername(username);
        return "编辑完毕";
    }

//    @Operation(summary = "获取好友动态列表", description = "获取好友动态列表")
//    @PatchMapping(path = "/user/{id}/friends")
//    public String GetFriendsList(@PathVariable Long id, @Parameter(description = "用户授权码") String access_token,
//                                 @Parameter(description = "当前的页码") int page,
//                                 @Parameter(description = "每页的数量") int per_page) throws Exception {
//        return "好友动态列表";
//    }

//    @Operation(summary = "好友动态列表(可删除)", description = "好友动态列表(可删除)")
//    @DeleteMapping(path = "/user/{id}/friends")
//    public String DeleteFriendsList(@PathVariable Long id, @Parameter(description = "用户授权码") String access_token,
//                                    @Parameter(description = "当前的页码") int page,
//                                    @Parameter(description = "每页的数量") int per_page,
//                                    @Parameter(description = "被删除者的用户名") String username) throws Exception {
//        return "好友动态列表(可删除)";
//    }

//    @Operation(summary = "添加好友", description = "搜寻并添加好友")
//    @PostMapping(path = "/user/{id}/friends")
//    public String AddFriendsList(@PathVariable Long id, @Parameter(description = "用户授权码") String access_token,
//                                 @Parameter(description = "需添加好友的用户名", required = true) String username) throws Exception {
//        return "添加好友";
//    }

    @Operation(summary = "发表评论信息", description = "发表评论信息")
    @PostMapping(path = "/user/{id}/blogs")
    public Result<?> reportBlogs(@PathVariable Long id, @RequestBody Comment comment) throws Exception {
        Customer customer = customerMapper.findById(id);
        if(customer!=null)
        {
            comment.setCustomerId(id);
            commentMapper.create(comment);
            return Result.ok(comment);
        }
        return Result.error(204,"评论不存在");
    }


    @RequestMapping(value = "/sleepdata")
    @ResponseBody
    public String switcher(HttpServletRequest request
            , HttpServletResponse response)
            throws Exception {
        String sleep = request.getParameter("sleep");
        if (sleep.equals("on")) {
            System.out.println("123123123");
            Thread.currentThread().sleep(100000);
            return "sleep on";
        } else {
            return sleep;
        }
    }
}
