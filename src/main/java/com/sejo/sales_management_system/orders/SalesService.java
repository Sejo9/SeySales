package com.sejo.sales_management_system.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SalesService {

    private final SalesRepository salesRepository;

    @Autowired
    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<Sales> getAllOrders() {
        return salesRepository.findAll();
    }

    public List<Sales> placeOrder(Sales sales) {
        try{
            updateOrder(sales);
        }catch(IllegalStateException e){
            salesRepository.save(sales);
        }

        return salesRepository.findAll();
    }

    @Transactional
    public void updateOrder(Sales order){
        Sales sales = salesRepository.findSalesByCustomerNameAndProductName(order.getCustomerName(), order.getProductName())
                .orElseThrow(() -> new IllegalStateException("This order does not exist"));

        if(sales.getPacked().equalsIgnoreCase("Yes")){
            throw new IllegalStateException("Order has already been packed");
        }

        sales.setQuantity(sales.getQuantity()+order.getQuantity());
        sales.setTotalPrice(sales.getTotalPrice()+order.getTotalPrice());


    }

    @Transactional
    public List<Sales> updateOrderPacked(String productName, String customerName, String packed) {
        Sales sales = salesRepository.findSalesByCustomerNameAndProductName(customerName, productName)
                .orElseThrow(() -> new IllegalStateException("This order does not exist"));

        sales.setPacked(packed);

        return salesRepository.findAll();
    }
}
