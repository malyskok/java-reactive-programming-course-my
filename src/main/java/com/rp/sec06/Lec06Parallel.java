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

public class Lec06Parallel {
    public static void main(String[] args) {

        //watch out on not safe collections like array list

        Flux.range(1, 1000)
                .parallel(10)
                .runOn(Schedulers.parallel())
//                .runOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName("next1: " + i))
                .sequential()
                .subscribe(i -> printThreadName("sub: " + i));

        Util.sleepSeconds(5);

    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}