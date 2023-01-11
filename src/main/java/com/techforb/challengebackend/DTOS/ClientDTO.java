package com.techforb.challengebackend.DTOS;

import com.techforb.challengebackend.models.Client;
import com.techforb.challengebackend.models.Sale;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {

    private long id;
    private String firstname;
    private String lastname;
    private int dni;
    private long cellPhone;
    private String address;

    private Boolean active;

    Set<SaleDTO> sales = new HashSet<>();

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstname = client.getFirstname();
        this.lastname = client.getLastname();
        this.dni = client.getDni();
        this.cellPhone = client.getCellPhone();
        this.address = client.getAddress();
        this.sales = client.getSales().stream().map(sale -> new SaleDTO(sale)).collect(Collectors.toSet());
        this.active = client.getActive();
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getDni() {
        return dni;
    }

    public long getCellPhone() {
        return cellPhone;
    }

    public String getAddress() {
        return address;
    }

    public Set<SaleDTO> getSales() {
        return sales;
    }

    public Boolean getActive() {
        return active;
    }
}
