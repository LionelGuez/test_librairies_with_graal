package fr.xebia.micronaut.demo;

import io.micronaut.core.annotation.TypeHint;
import io.micronaut.runtime.Micronaut;

@TypeHint({
        org.postgresql.Driver.class,
        org.hibernate.dialect.PostgreSQL10Dialect.class
})
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}