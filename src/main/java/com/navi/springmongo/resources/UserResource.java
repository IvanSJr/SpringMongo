package com.navi.springmongo.resources;

import com.navi.springmongo.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User user = new User("1", "Maria Brown", "maria.brown@gmail.com");
        User user2 = new User("2", "Alex Green", "alex_green@gmail.com");
        User user3 = new User("3", "Ivan Júnior", "ivanjrjesus01@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user, user2, user3));
        return ResponseEntity.ok().body(list);
    }
}
