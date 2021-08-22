package com.navi.springmongo.config;


import com.navi.springmongo.entities.User;
import com.navi.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DBConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User ivan = new User(null, "Ivan Santos", "ivan.junior2706@gmail.com");
        User carmen = new User(null, "Carmen Gomes", "carmengomes01@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob, ivan, carmen));

    }
}
