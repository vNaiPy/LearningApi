package com.students.knowledge.services;

import com.students.knowledge.domain.User;
import com.students.knowledge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository _userRepository;

    public List<User> findAll () {
        return _userRepository.findAll();
    }

}
