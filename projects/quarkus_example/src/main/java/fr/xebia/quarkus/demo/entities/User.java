package fr.xebia.quarkus.demo.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity()
@Table(name="t_user")
public class User extends PanacheEntity {

    public String firstName;
    public String lastName;


    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\n";
    }
}
