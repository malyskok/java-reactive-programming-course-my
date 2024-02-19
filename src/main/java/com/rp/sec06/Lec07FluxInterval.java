/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class Lec07FluxInterval {
    public static void main(String[] args) {
        Flux
                .interval(Duration.ofSeconds(1)) //interval(period, Schedulers.parallel());
                .delayElements(Duration.ofSeconds(1)) //delayElements(delay, Schedulers.parallel());
                .subscribeOn(Schedulers.boundedElastic()) //does not take effect!
                .subscribe(aLong -> printThreadName("sub: " + aLong));

        Util.sleepSeconds(10);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}