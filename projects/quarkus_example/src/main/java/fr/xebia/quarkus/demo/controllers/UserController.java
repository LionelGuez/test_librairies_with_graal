package fr.xebia.quarkus.demo.controllers;

import fr.xebia.quarkus.demo.entities.User;
import fr.xebia.quarkus.demo.services.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;


@Path("user")
public class UserController {

    @Inject
    private UserRepository userService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{name}/{firstName}")
    public void createUser(@PathParam("name") String name, @PathParam("firstName")String firstName){
        System.out.println(name + " ; " + firstName);
        userService.createUser(new User(firstName,name));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String allUsers(){
        return userService.allUsers().stream().map(User::toString).collect(Collectors.joining(" ;  "));
    }
}
