/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec04;

import com.rp.courseutil.Util;
import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.UserService;

public class Lec11FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user ->
                        OrderService.getOrders(user.getUserId()))
                .filter(purchaseOrder -> Double.parseDouble(purchaseOrder.getPrice()) > 1.0)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}