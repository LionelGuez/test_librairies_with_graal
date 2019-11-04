package fr.xebia.quarkus.demo.services;

import java.util.List;

import fr.xebia.quarkus.demo.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Inject
    EntityManager em;

    @Transactional
    public void createUser(User user){
        em.persist(user);
    }

    public List<User> allUsers(){
        return em.createQuery("select u FROM User as u").getResultList();
    }

}
