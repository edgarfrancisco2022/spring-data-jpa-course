package com.edgarfrancisco.springdatajpacourse.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
//    Unidirectional mapping
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
//    private Address billingAddress;
    //Bidirectional mapping
    //Source contains the 'mappedBy' attribute, but does not contain the foreign key
    //The mappedBy value must be the object reference in the target entity
    //Target contains the foreign key (use '@JoinColumn')
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Address billingAddress;

    //One to Many unidirectional mapping
    //order_items table (target?) contains foreign key to orders table
    //foreign key reference al revés? - no se declara nada del otro lado...
    //por qué unos incluyen referencedColumnName y otros no?
    //default fetch type for @OneToMany is lazy


//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "order_id", referencedColumnName = "id")

    //OneToMany bidirectional mapping
    //In a One-to-Many/Many-to-One relationship, the owning side is usually defined on the ‘many' side of the relationship.
    //the value of mappedBy is the name of the association-mapping attribute on the owning side
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();

    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal(0.0);
        for (OrderItem item : this.orderItems) {
            amount = amount.add(item.getPrice());
        }
        return amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
