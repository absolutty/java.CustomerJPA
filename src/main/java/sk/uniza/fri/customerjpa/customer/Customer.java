package sk.uniza.fri.customerjpa.customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Basic(optional = false) @Column(length = 50)
    private String firstName;
    @Basic(optional = false) @Column(length = 50)
    private String lastName;
    @Transient
    private String fullName;
    @Enumerated(EnumType.STRING) @Basic(optional = false)
    private Gender gender;
    private LocalDate dateOfBirth;
    @Embedded
    private PlaceOfResidence placeOfResidence;

    public Customer() {}

    public Customer(String firstName, String lastName, Gender gender, LocalDate dateOfBirth, PlaceOfResidence placeOfResidence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.placeOfResidence = placeOfResidence;
    }

    @Override
    public String toString() {
        return String.format(
                "[id=%d, firstName=%s, lastName=%s, fullName = %s, gender=%s, dateOfBirth = %s, placeOfResidence = %s]",
                id, firstName, lastName, fullName, gender, dateOfBirth.toString(), placeOfResidence.toString()
        );
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) obj;

        return Objects.equals(id, customer.id) &&
                firstName.equals(customer.firstName) &&
                lastName.equals(customer.lastName) &&
                gender == customer.gender &&
                dateOfBirth.equals(customer.dateOfBirth);
    }

}