package com.polariodvoid.one_eighty;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem extends IdBasedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
@ManyToOne
@JoinColumn (name = "product_id")
    private Product product;
    private int quantity;

    public CartItem() {;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "CartItem [id=" + id + ", user=" + user.getFirstName() + ", product=" + product.getShortName() + ", quantity=" + quantity
                + "]";
    }

    @Transient
    public float getSubtotal() {
        return product.getDiscountPrice() * quantity;
    }

}
