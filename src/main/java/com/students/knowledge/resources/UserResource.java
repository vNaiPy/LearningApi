package com.students.knowledge.resources;

import com.students.knowledge.domain.User;
import com.students.knowledge.domain.dto.UserDTO;
import com.students.knowledge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
