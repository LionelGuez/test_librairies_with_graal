package fr.xebia.spring.demo.spring_example.repositories;

import fr.xebia.spring.demo.spring_example.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
