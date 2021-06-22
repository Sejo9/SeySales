package com.sejo.sales_management_system.staff;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Staff")
@Table(name = "staff")
public class Staff {

    //Variable Declarations
    @Id
    @SequenceGenerator(
            name = "staff_sequence",
            sequenceName = "staff_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "staff_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "dob",
            nullable = false
    )
    private LocalDate dob;

    @Column(
            name = "access",
            nullable = false
    )
    private int access;

    @Column(
            name = "position",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String position;


    //Constructors
    public Staff() {
    }

    public Staff(String firstName, String lastName, LocalDate dob, int access, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.access = access;
        this.position = position;
    }


    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    //ToString Override
    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", access=" + access +
                ", position='" + position + '\'' +
                '}';
    }
}
