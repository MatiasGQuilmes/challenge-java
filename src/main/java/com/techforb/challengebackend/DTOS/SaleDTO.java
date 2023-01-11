package com.techforb.challengebackend.DTOS;

import com.techforb.challengebackend.models.Sale;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SaleDTO {
    private long id;
    private LocalDate date;

    private double totalPrice;

    public SaleDTO() {
    }

    public SaleDTO(Sale sale) {
        this.id = sale.getId();
        this.date = sale.getDate();
        this.totalPrice = sale.getTotalPrice();
    }

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }


    public double getTotalPrice() {
        return totalPrice;
    }
}
