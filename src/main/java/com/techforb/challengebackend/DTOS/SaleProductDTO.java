package com.techforb.challengebackend.DTOS;

import com.techforb.challengebackend.models.Product;
import com.techforb.challengebackend.models.Sale;
import com.techforb.challengebackend.models.SaleProduct;



public class SaleProductDTO {

    private long id;
    private double quantity;
    private double totalPrice;
    private long sale;
    private long product;

    public SaleProductDTO() {
    }

    public SaleProductDTO(SaleProduct saleProduct) {
        this.id = saleProduct.getId();
        this.quantity = saleProduct.getQuantity();
        this.totalPrice = saleProduct.getTotalPrice();
        this.sale = saleProduct.getSale().getId();
        this.product = saleProduct.getProducts().getId();
    }

    public long getId() {
        return id;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public long getSale() {
        return sale;
    }

    public long getProduct() {
        return product;
    }
}
