package com.sejo.sales_management_system.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orders")
@CrossOrigin("*")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping
    public List<Sales> getAllOrders(){
        return salesService.getAllOrders();
    }

    @PostMapping
    public List<Sales> placeOrder(@RequestBody Sales sales){
        return salesService.placeOrder(sales);
    }

    @PutMapping(path = "updatePacked")
    public List<Sales> updateOrderPacked(@RequestParam String productName, @RequestParam String customerName, @RequestParam String packed){
        return salesService.updateOrderPacked(productName,customerName,packed);
    }
}
