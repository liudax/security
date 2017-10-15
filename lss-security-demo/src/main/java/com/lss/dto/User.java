package com.lss.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.lss.validator.MyValid;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Magic on 2017/10/14.
 */
public class User {

    public interface SimpleView{}
    public interface DetailView extends SimpleView{}

    private String id;
    @MyValid(message = "这只是校验注解的测试")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;
    @Past(message = "生日必须为过去的时间")
    private Date birthday;

    public User(){

    }
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    @JsonView(SimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonView(SimpleView.class)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonView(DetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonView(SimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
