package com.webbackend.webbackend1.config;


import com.webbackend.webbackend1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Date;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 不拦截静态资源
        web.ignoring().antMatchers("/js/**", "/css/**", "/img/**", "/pic/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers()
                .frameOptions().disable()
                //针对h2-console关闭csrf验证
                .and().csrf()
                .ignoringAntMatchers("/h2-console/**", "/**")
                .and().formLogin()
                .loginPage("/login")//自定义登录页面
                .loginProcessingUrl("/login")
                .permitAll()
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    System.out.println("登陆成功处理==============");
                    //跳转到微博列表首页
//                    System.out.println(sysUserRepository.findAll());
                    System.out.println(httpServletRequest.getParameter("username"));
                })
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    System.out.println("登陆失败处理=============");
                    //返回到登陆页面
                    System.out.println(httpServletRequest.getParameter("username"));
                })
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(((httpServletRequest, httpServletResponse, authentication) -> {
                    System.out.println("登出成功处理=============");
                    httpServletResponse.sendRedirect("/login");
                }))
                .and().authorizeRequests()
                //.antMatchers permitALL 放行不需要认证
                .antMatchers("/**").permitAll()//这些链接全部不用授权访问
                .anyRequest().authenticated();//其他的需要
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    }
}
