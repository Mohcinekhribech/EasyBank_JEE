package  com.example.easybank_jee.DTO;

import java.time.LocalDate;

import lombok.Data;
@Data
public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected LocalDate dateOfBirth;
    protected String phoneNumber;
    protected String email;
}
