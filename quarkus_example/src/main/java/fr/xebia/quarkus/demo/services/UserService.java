package fr.xebia.quarkus.demo.services;

import java.util.List;

import fr.xebia.quarkus.demo.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Transactional
    public void createUser(User user){
        user.persist();
    }

    public List<User> allUsers(){
        return User.listAll();
    }

}
