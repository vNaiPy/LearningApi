package com.students.knowledge.services;

import com.students.knowledge.domain.User;
import com.students.knowledge.repositories.UserRepository;
import com.students.knowledge.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository _userRepository;

    public List<User> findAll () {
        return _userRepository.findAll();
    }

    public User findById (String id) {
        Optional<User> user = _userRepository.findById(id);
        if(user.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user.get();
    }

    public User insert (User user) {
        return _userRepository.insert(user);
    }

}
