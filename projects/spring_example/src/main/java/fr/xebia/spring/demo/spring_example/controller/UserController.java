package fr.xebia.spring.demo.spring_example.controller;

import fr.xebia.spring.demo.spring_example.entities.User;
import fr.xebia.spring.demo.spring_example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/{name}/{firstName}")
    public void createUser(@PathVariable("name") String name, @PathVariable("firstName") String firstName) {
        System.out.println(name + " ; " + firstName);
        userRepository.save(new User(name,firstName));
    }

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String allUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).map(User::toString).collect(Collectors.joining(" ;  "));
    }

}
