package com.sejo.sales_management_system.inventory;

import javax.persistence.*;

@Entity(name="Product")
@Table(
        name="product",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "product_name_unique",
                        columnNames = "product_name"
                )
        })

public class Product {

    //Variable Declarations
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    //Product Name
    @Column(
            name = "product_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String productName;

    //Stock
    @Column(
            name = "stock",
            nullable = false
    )
    private int stock;

    //Item Price
    @Column(
            name = "item_price",
            nullable = false
    )
    private double itemPrice;

    //Warehouse Location
    @Column(
            name = "warehouse_location",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String warehouseLocation;

    //Priority
    @Column(
            name = "priority",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String priority;

    //Technical Details
    @Column(
            name = "technical_details",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String technicalDetails;


    //Constructors

    public Product() {
    }

    public Product(String productName, int stock, double itemPrice, String warehouseLocation, String priority, String technicalDetails) {
        this.productName = productName;
        this.stock = stock;
        this.itemPrice = itemPrice;
        this.warehouseLocation = warehouseLocation;
        this.priority = priority;
        this.technicalDetails = technicalDetails;
    }


    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTechnicalDetails() {
        return technicalDetails;
    }

    public void setTechnicalDetails(String technicalDetails) {
        this.technicalDetails = technicalDetails;
    }

    //ToString Override

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", stock=" + stock +
                ", itemPrice=" + itemPrice +
                ", warehouseLocation='" + warehouseLocation + '\'' +
                ", priority='" + priority + '\'' +
                ", technicalDetails='" + technicalDetails + '\'' +
                '}';
    }
}
