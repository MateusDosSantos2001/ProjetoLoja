package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(optional = false)
    private Product product;
    @OneToOne(optional = false)
    private User user;

    protected Cart() {}

    public Cart(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    @Override
    public String toString() {
      return String.format(
          "[id=%d, product='%s', user='%s']",
          id, product, user);
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}