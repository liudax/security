package com.lss.web.dto;

import com.fasterxml.jackson.annotation.JsonView;
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
    private String userName;
    @NotBlank
    private String password;
    @Past
    private Date birthday;

    public User(){

    }
    public User(String userName,String password){
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
