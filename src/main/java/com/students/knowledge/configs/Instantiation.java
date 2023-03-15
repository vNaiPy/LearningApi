package com.students.knowledge.configs;

import com.students.knowledge.domain.User;
import com.students.knowledge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository _userRepository;

    @Override
    public void run(String... args) throws Exception {

        _userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com", "1234");
        User alex = new User(null, "Alex Green", "alex@gmail.com", "1234");
        User bob = new User(null, "Bob Grey", "bob@gmail.com", "1234");

        _userRepository.saveAll(Arrays.asList(maria, alex, bob));

    }
}
