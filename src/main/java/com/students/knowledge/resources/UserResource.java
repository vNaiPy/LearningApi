package com.students.knowledge.resources;

import com.students.knowledge.domain.User;
import com.students.knowledge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService _userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll () {
        List<User> list = _userService.findAll();
        return ResponseEntity.ok().body(list);
    }

}
