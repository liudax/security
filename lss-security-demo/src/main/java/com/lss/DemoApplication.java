package com.lss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Magic on 2017/10/14.
 */

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) throws IOException {

        /*Properties properties = new Properties();
        properties.setProperty("spring.datasource.driver-class-name","com.mysql.jdbc.Driver");
        properties.setProperty("spring.datasource.url","jdbc:mysql://127.0.0.1:3306/security-demo?useUnicode=yes&characterEncoding=UTF-8&useSSL=false");
        properties.setProperty("spring.datasource.username","root");
        properties.setProperty("spring.datasource.password","myroot");
        properties.setProperty("spring.session.store-type","none");
        properties.setProperty("security.basic.enabled","false");
        properties.setProperty("server.port","8888");
        /*InputStream in = DemoApplication.class.getClassLoader().getResourceAsStream("application.properties");
        properties.load(in);
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setDefaultProperties(properties);
        app.run(args);*/
        SpringApplication.run(DemoApplication.class,args);
    }

    @GetMapping("/hello")
    public String hello(){
        System.out.println();
        return "hello security";
    }
}
