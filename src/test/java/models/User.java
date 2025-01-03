package models;

import com.github.javafaker.Faker;

public class User {
    private final String firstName;
    private final String lastName;
    private final String zipCode;


    public User() {
        final var faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        zipCode = faker.address().zipCode();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }
}
