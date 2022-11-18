package sk.uniza.fri.customerjpa;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Customer {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Transient
    private String fullName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dateOfBirth;

    public Customer() {}

    public Customer(String firstName, String lastName, Gender gender, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format(
                "[id=%d, firstName=%s, lastName=%s, fullName = %s, gender=%s, dateOfBirth = %s]",
                id, firstName, lastName, fullName, gender, dateOfBirth.toString()
        );
    }
}

enum Gender {
    MALE, FEMALE
}
