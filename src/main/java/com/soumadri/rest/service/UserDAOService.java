package com.soumadri.rest.service;

import com.soumadri.rest.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<User>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "John", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        User tmpUser = new User(user);  //Create a deep clone to make this pure function
        if(tmpUser.getId() == null) {
            tmpUser.setId(++usersCount);
        }

        users.add(tmpUser);
        return tmpUser;
    }

    public User findOne(int id) {
        for(User user : users) {
            if(user.getId() == id) {
                return new User(user);
            }
        }

        return null;
    }
}
