package model;

import com.github.javafaker.Faker;
import lombok.*;


@Getter
@AllArgsConstructor
public class RegisterUser {
    private String firstName;
    private String lastName;
    private String address;
    private String postCode;
    private String city;
    private String state;
    private String phone;
    private String email;
    private String password;
    ;

    public RegisterUser() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        address = faker.address().fullAddress();
        postCode = faker.address().zipCode();
        city = faker.address().city();
        state = faker.address().state();
        phone = faker.number().digits(8);
        email = faker.internet().emailAddress();
        password = faker.internet().password();
    }

}
