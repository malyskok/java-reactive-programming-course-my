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

public class Lec01ThreadDemo {
    public static void main(String[] args) {
//        Flux.create(fluxSink -> {
//                    printThreadName("create");
//                    fluxSink.next(1);
//                })
//                .doOnNext(o -> printThreadName("next " + o))
//                .subscribe(o -> printThreadName("sub " + o));
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                .doOnNext(o -> printThreadName("next " + o));

        Runnable runnable = () -> flux.subscribe(o -> printThreadName("sub " + o));

        for(int i = 0; i < 2; i++){
            new Thread(runnable).start();
        }

        Util.sleepSeconds(10);
    }

    private static void printThreadName(String create) {
        System.out.println(create + ": " + Thread.currentThread().getName());
    }
}