package fr.xebia.micronaut.demo.repositories;


import fr.xebia.micronaut.demo.entities.User;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByFirstName(String firstName);
}
