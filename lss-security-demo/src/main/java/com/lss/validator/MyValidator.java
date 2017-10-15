package com.lss.validator;

import com.lss.web.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Magic on 2017/10/15.
 *
 * MyValid 注解的校验器
 */
public class MyValidator implements ConstraintValidator<MyValid,Object> {

    //该类不需要显示注入到spring容器中，实现了ConstraintValidator接口的类，会被spring自动注入

    //这里可以引入任何spring容器管理 的类，来实现校验逻辑
    @Autowired
    UserController userController;

    @Override
    public void initialize(MyValid constraintAnnotation) {
        System.out.println("校验注解初始化");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("校验逻辑执行，返回false");
        return false;
    }
}
