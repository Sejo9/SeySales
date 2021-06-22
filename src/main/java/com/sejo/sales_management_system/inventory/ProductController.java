package com.sejo.sales_management_system.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public List<Product> addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping(path = "updatePolicy")
    public String updateProductPriority(@RequestParam String priority, @RequestParam String productName){
        return productService.updateProductPriority(productName,priority);
    }

    @PutMapping(path = "reduceStock")
    public List<Product> reduceProductStock(@RequestParam int quantity, @RequestParam String productName){
        return productService.reduceProductStock(productName,quantity);
    }
}
