package com.navi.springmongo.resources;

import com.navi.springmongo.dto.UserDTO;
import com.navi.springmongo.entities.Post;
import com.navi.springmongo.entities.User;
import com.navi.springmongo.resources.util.URL;
import com.navi.springmongo.services.PostService;
import com.navi.springmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "texto", defaultValue = "") String texto){
        texto = URL.decodeParam(texto);
        List<Post> obj = service.findByTitle(texto);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "texto", defaultValue = "") String texto,
            @RequestParam(value = "minData", defaultValue = "") String minData,
            @RequestParam(value = "maxData", defaultValue = "") String maxData){
        texto = URL.decodeParam(texto);
        Date min = URL.convertDate(minData, new Date(0L));
        Date max = URL.convertDate(maxData, new Date());
        List<Post> obj = service.fullSearch(texto, min, max);
        return ResponseEntity.ok().body(obj);
    }

}
