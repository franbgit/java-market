package com.platzi.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_purchases")
public class ProductPurchases {

    @EmbeddedId
    private ProductPurchasesPK id;

    private Integer quantity;
    private Double total;
    private Boolean state;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(name = "id_purchase", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    public ProductPurchasesPK getId() {
        return id;
    }

    public void setId(ProductPurchasesPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
