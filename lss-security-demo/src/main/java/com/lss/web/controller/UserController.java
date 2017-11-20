package com.lss.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lss.dto.User;
import com.lss.exception.UserNotExistException;
import org.apache.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liushisheng
 * Created by Magic on 2017/10/14.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    final static String FOLDER =  "D:\\workspace\\idea\\security\\lss-security-demo\\src\\main\\java\\com\\lss\\web\\controller";

    private Logger logger = Logger.getLogger(UserController.class);
    //RequestBody注解，将请求的json字符串组装到user对象中
    @PostMapping()
    public User createUser(@Valid @RequestBody User user, BindingResult errors, MultipartFile file) throws IOException {
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(e-> {
                FieldError fieldError = (FieldError)e;
                System.out.println(fieldError.getField()+" "+fieldError.getDefaultMessage());
            });
        }
        System.out.println(file.getName());
        File localFile = new File(FOLDER,System.currentTimeMillis()+".txt");
        file.transferTo(localFile);
        System.out.println("用户名："+user.getUserName());
        System.out.println("密码："+user.getPassword());
        System.out.println("ID："+user.getId());
        System.out.println("生日："+user.getBirthday());
        return user;
    }

    @JsonView(User.SimpleView.class)
    @GetMapping()
    public List<User> query(){
        List<User> users = new ArrayList<>();
        logger.info("正在查询所有用户信息");
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

    @GetMapping("/me")
    public UserDetails me(@AuthenticationPrincipal UserDetails user){
        return user;
    }

}
