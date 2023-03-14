package com.students.knowledge.resources;

import com.students.knowledge.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll () {
        User handrei = new User(1L, "handrei", "handrei@gmail.com");
        User carlos = new User(2L, "carlos", "carlos@gmail.com");

        List<User> list = new ArrayList<>(Arrays.asList(handrei, carlos));
        return ResponseEntity.ok().body(list);
    }

}
