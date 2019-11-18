package fr.xebia.micronaut.demo.controllers;


import fr.xebia.micronaut.demo.entities.User;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import fr.xebia.micronaut.demo.repositories.UserRepository;
import javax.inject.Inject;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller("/users")
public class UserController {

    private UserRepository userRepository;

    @Inject // L'annotation est optionnelle
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Post(value = "{name}/{firstName}", produces = MediaType.TEXT_PLAIN)
    public void createUser(@PathVariable String name, @PathVariable  String firstName){
        System.out.println(name + " ; " + firstName);
        userRepository.save(new User(firstName,name));
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String allUsers(){
        //return "everyone";
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).map(User::toString).collect(Collectors.joining(" ;  "));
    }

    @Get(value="{firstName}", produces = MediaType.TEXT_PLAIN)
    public String userByName(@PathVariable String firstName){
        return userRepository.findByFirstName(firstName).getLastName();
    }
}
