package com.ncs.recruit.context.system;

import org.springframework.stereotype.Component;

import com.ncs.recruit.context.system.model.User;
import com.ncs.recruit.interfaces.command.CreateUserCommand;

@Component
public class UserFactory {

    public User create(CreateUserCommand createUser) {
        User user = new User(createUser.getWorkNum(),
            createUser.getUserName(),
            createUser.getName(),
            createUser.getPhoneNum(),
            createUser.getEmail(),
            createUser.getDepartment(),
            createUser.getPosition(),
            createUser.getBusiLiner()
        );
        user.rserUserPwd();
        return user;
    }

}
