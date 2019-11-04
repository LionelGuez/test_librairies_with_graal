package fr.xebia.quarkus.demo.entities;

import javax.persistence.*;

@Entity()
@Table(name="t_user")
public class User {

    @Id @GeneratedValue
    private int id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;


    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
