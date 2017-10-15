package com.lss.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lss.dto.User;
import com.lss.exception.UserNotExistException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magic on 2017/10/14.
 */
@RestController
public class UserController {


    //RequestBody注解，将请求的json字符串组装到user对象中
    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(e-> {
                FieldError fieldError = (FieldError)e;
                System.out.println(fieldError.getField()+" "+fieldError.getDefaultMessage());
               // System.out.println("错误："+e.getDefaultMessage());
            });
        }
        System.out.println("用户名："+user.getUserName());
        System.out.println("密码："+user.getPassword());
        System.out.println("ID："+user.getId());
        System.out.println("生日："+user.getBirthday());
        return user;
    }

    @JsonView(User.SimpleView.class)
    @GetMapping("/user")
    public List<User> query(){
        List<User> users = new ArrayList<>();
        users.add(new User("张三","123456"));
        users.add(new User("王五","123456"));
        users.add(new User("李思","123456"));
        return users;
    }
    @JsonView(User.DetailView.class)
    @GetMapping("/user/{id}")
    public User getUserInfo(@PathVariable("id")String userId){

        throw new UserNotExistException(userId);
        /*User user = new User("jack","123123");
        user.setId("001");
        return user;*/
    }


    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable("id") String id ){

        return  "id为"+id+"的用户修改成功";
    }

}
