package com.navi.springmongo.config;


import com.navi.springmongo.dto.AuthorDTO;
import com.navi.springmongo.entities.Post;
import com.navi.springmongo.entities.User;
import com.navi.springmongo.repositories.PostRepository;
import com.navi.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class DBConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User ivan = new User(null, "Ivan Santos", "ivan.junior2706@gmail.com");
        User carmen = new User(null, "Carmen Gomes", "carmengomes01@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob, ivan, carmen));

        Post post1 = new Post(null, sdf.parse("21/10/2020"), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(bob));
        Post post2 = new Post(null, sdf.parse("22/10/2020"), "Aprimorando minha habilidades programáticas", "Hoje eu comecei a estudar Java para me tornar um excelente programador!", new AuthorDTO(ivan));
        Post post3 = new Post(null, sdf.parse("23/08/2021"), "Meu novo emprego", "Hoje eu comecei a trabalhar na empresa Publicações Online como desenvolver FullStack!", new AuthorDTO(ivan));

        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        bob.getPosts().addAll(List.of(post1));
        ivan.getPosts().addAll(Arrays.asList(post2, post3));
        userRepository.saveAll(Arrays.asList(bob, ivan));

    }
}
