/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {
    public static void main(String[] args) {
        getName();
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block() //just for test
//                .subscribe(Util.onNext())
                ;
        System.out.println(name);
        getName();

        Util.sleepSeconds(5);
    }

    private static Mono<String> getName() {
        System.out.println("Entered getName()");
        return Mono.fromSupplier(() -> {
            System.out.println("Executed Supplier");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}