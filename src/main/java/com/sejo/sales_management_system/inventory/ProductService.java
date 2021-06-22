package com.sejo.sales_management_system.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> addProduct(Product product) {

        Optional<Product> productOptional = productRepository.findProductByProductName(product.getProductName());

        if(productOptional.isPresent()){
            throw new IllegalStateException("Product already exists");
        }else{
            productRepository.save(product);
            return productRepository.findAll();
        }
    }

    @Transactional
    public String updateProductPriority(String productName, String priority) {
        Product product = productRepository.findProductByProductName(productName).orElseThrow(
                () -> new IllegalStateException("Product " + productName + " does not exist")
        );

        if(product.getPriority().equalsIgnoreCase(priority)){
            return "Product Priority Is The Same";
        }else{
            product.setPriority(priority);
            return "Product Priority Updated";
        }

    }

    @Transactional
    public List<Product> reduceProductStock(String productName, int quantity){
        Product product = productRepository.findProductByProductName(productName).orElseThrow(
                () -> new IllegalStateException("Product " + productName + " does not exist")
        );

        product.setStock(product.getStock() - quantity);

        return productRepository.findAll();
    }
}
