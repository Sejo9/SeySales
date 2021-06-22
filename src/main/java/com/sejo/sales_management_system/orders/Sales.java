package com.sejo.sales_management_system.orders;

import javax.persistence.*;

@Entity(name = "Sales")
@Table(name = "sales")
public class Sales {

    //Variable Declarations
    @Id
    @SequenceGenerator(
            name = "sales_sequence",
            sequenceName = "sales_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sales_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    //Customer Name
    @Column(
            name = "customer_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String customerName;

    //Product Name
    @Column(
            name = "product_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String productName;

    //Quantity
    @Column(
            name = "quantity",
            nullable = false
    )
    private int quantity;

    //Total Price
    @Column(
            name = "total_price",
            nullable = false
    )
    private double totalPrice;

    //Salesperson Name
    @Column(
            name = "salesperson_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String salespersonName;

    //Packed
    @Column(
            name = "packed",
            nullable = false
    )
    private String packed;

    //Constructors
    public Sales() {
    }

    public Sales(String customerName, String productName, int quantity, double totalPrice, String salespersonName, String packed) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.salespersonName = salespersonName;
        this.packed = packed;
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSalespersonName() {
        return salespersonName;
    }

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }

    public String getPacked() {
        return packed;
    }

    public void setPacked(String packed) {
        this.packed = packed;
    }

    //ToString Override
    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", salespersonName='" + salespersonName + '\'' +
                ", packed=" + packed +
                '}';
    }
}
