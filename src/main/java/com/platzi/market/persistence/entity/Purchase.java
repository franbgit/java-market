package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase")
    private Integer purchaseId;

    @Column(name = "id_customer")
    private String customerId;

    private LocalDateTime date;

    @Column(name = "half_pay")
    private String halfPay;

    private String commentary;
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.ALL})
    private List<ProductPurchases> products;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getHalfPay() {
        return halfPay;
    }

    public void setHalfPay(String halfPay) {
        this.halfPay = halfPay;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ProductPurchases> getProducts() {
        return products;
    }

    public void setProducts(List<ProductPurchases> products) {
        this.products = products;
    }
}
