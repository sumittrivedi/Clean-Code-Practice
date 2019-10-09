package com.epam.engx.cleancode.naming.task1;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.*;

import java.util.List;

public class DeliveryOrderService implements OrderService {

    private DeliveryService DeliveryService;

    private OrderFulfilmentService OrderFulfilmentService;

    public void submitOrder(Order Order) {
        if (DeliveryService.isDeliverable()) {
            List<Product> products = Order.getProducts();
            OrderFulfilmentService.fulfilProducts(products);
        } else {
            throw new NotDeliverableOrderException();
        }
    }

    public void setDeliveryService(DeliveryService DeliveryService) {
        this.DeliveryService = DeliveryService;
    }

    public void setOrderFulfilmentService(OrderFulfilmentService OrderFulfilmentService) {
        this.OrderFulfilmentService = OrderFulfilmentService;
    }
}
