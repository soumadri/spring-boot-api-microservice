package com.soumadri.rest.controller;

import com.soumadri.rest.exceptions.UserNotFoundException;
import com.soumadri.rest.model.User;
import com.soumadri.rest.service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDAOService userDAOService;

    @GetMapping(
            path = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<User> retrieveAllUsers() {
        return userDAOService.findAll();
    }

    @GetMapping(
            path = "/users/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public User retrieveUserById(@PathVariable int id) {
        User user = userDAOService.findOne(id);

        if(user == null)
            throw new UserNotFoundException("id=" + id);

        return user;
    }

    @PostMapping(
            path = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
        User savedUser = userDAOService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand((savedUser.getId())).toUri();

        return ResponseEntity.created(location).build();
    }
}
