package com.students.knowledge.configs;

import com.students.knowledge.domain.Post;
import com.students.knowledge.domain.User;
import com.students.knowledge.domain.dto.AuthorDTO;
import com.students.knowledge.domain.dto.CommentDTO;
import com.students.knowledge.repositories.PostRepository;
import com.students.knowledge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private PostRepository _postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        _userRepository.deleteAll();
        _postRepository.deleteAll();


        User maria = new User(null, "Maria Brown", "maria@gmail.com", "1234");
        User alex = new User(null, "Alex Green", "alex@gmail.com", "1234");
        User bob = new User(null, "Bob Grey", "bob@gmail.com", "1234");
        _userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"),  "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
        _postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        _userRepository.save(maria);

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);
        _postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
