package com.techforb.challengebackend.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String firstname;
    private String lastname;
    private int dni;
    private long cellPhone;
    private String address;
    private boolean active = true;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    Set<Sale> sales = new HashSet<>();

    public Client() {
    }

    public Client(String firstname, String lastname, int dni, long cellPhone, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dni = dni;
        this.cellPhone = cellPhone;
        this.address = address;
    }

    public long getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public long getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }


    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
