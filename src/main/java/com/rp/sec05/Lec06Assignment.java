/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec05;

import com.rp.courseutil.Util;
import com.rp.sec05.assignment.InventoryService;
import com.rp.sec05.assignment.OrderService;
import com.rp.sec05.assignment.PurchaseOrder;
import com.rp.sec05.assignment.RevenueService;
import reactor.core.publisher.Flux;

public class Lec06Assignment {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        InventoryService inventoryService = new InventoryService();
        RevenueService revenueService = new RevenueService();

        Flux<PurchaseOrder> orderFlux = orderService.orderStream();
        orderFlux.subscribe(inventoryService.consumePurchaseOrders());
        orderFlux.subscribe(revenueService.consumePurchaseOrders());

        inventoryService.inventoryStream()
                        .subscribe(Util.subscriber("inventory"));

        revenueService.revenueStream()
                .subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(60);
    }
}