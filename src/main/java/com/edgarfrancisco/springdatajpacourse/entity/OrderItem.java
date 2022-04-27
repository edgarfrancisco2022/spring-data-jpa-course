package com.edgarfrancisco.springdatajpacourse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imageUrl;
    private BigDecimal price;
    private int quantity;
    //OneToOne unidirectional mapping, source contains the foreign key?
    //order_items table contains column "product_id" with a foreign key to Product
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //ManyToOne bidirectional mapping
    //In a One-to-Many/Many-to-One relationship, the owning side is usually defined
    //on the ‘many' side of the relationship. It's usually the side which owns the foreign key.
    //The @JoinColumn annotation defines that actual physical mapping on the owning side:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id") //foreign-key
    private Order order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
