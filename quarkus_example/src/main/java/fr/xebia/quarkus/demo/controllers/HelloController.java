package fr.xebia.quarkus.demo.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "hellooo hella\n";
    }
}
