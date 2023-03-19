package com.students.knowledge.resources;

import com.students.knowledge.domain.User;
import com.students.knowledge.domain.dto.UserDTO;
import com.students.knowledge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService _userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll () {
        List<User> list = _userService.findAll();
        List<UserDTO> userDTOList = list.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById (@PathVariable String id) {
        User user = _userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert (@RequestBody User user) {
        User userSaved = _userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userSaved.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
