package com.epam.engx.cleancode.naming.task1;


import com.epam.engx.cleancode.naming.task1.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Message;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.NotificationManager;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Order;

public class CollectOrderService implements OrderService {

    private CollectionService collService;
    private NotificationManager notiManager;

    public void submitOrder(Order Order) {
        if (collService.isEligibleForCollection(pOrder))
        	notiManager.notifyCustomer(Message.READY_FOR_COLLECT, 4); // 4 - info notification level
        else
        	notiManager.notifyCustomer(Message.IMPOSSIBLE_TO_COLLECT, 1); // 1 - critical notification level
    }

    public void setCollService(CollectionService collService) {
        this.collService = collService;
    }

    public void setNotiManager(NotificationManager notiManager) {
        this.notiManager = notiManager;
    }
}
