package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products") // we need this annotation because the name in the database is different to the class name
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product") // we need this annotation because the name in the database is different to the var name
    private Integer productId;

    private String name;

    @Column(name = "id_category") // we need this annotation because the name in the database is different to the var name
    private Integer categoryId;

    private String barcode;

    private Double price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_category", insertable = false, updatable = false) // we are not going to insert or update a category through the relationship Product-Category
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductPurchases> products;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductPurchases> getProducts() {
        return products;
    }

    public void setProducts(List<ProductPurchases> products) {
        this.products = products;
    }
}
