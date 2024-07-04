package com.artha.handler;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.artha.entity.Users;
import com.artha.service.UserService;

public class FindAllUsersFunction implements RequestHandler<Object, List<Users>> {

    private UserService userService;

    public FindAllUsersFunction() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.userService = context.getBean(UserService.class);
    }

    // Constructor for testing
    public FindAllUsersFunction(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<Users> handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        
        List<Users> users = userService.findAll();
        context.getLogger().log("Users found: " + users);
        
        return users;
    }
}
