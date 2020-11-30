package com.sobuj.models;

import javax.persistence.*;

@Entity
public class ProductToCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "add_to_cart_id")
    private AddToCart addToCart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public AddToCart getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(AddToCart addToCart) {
        this.addToCart = addToCart;
    }
}
