/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec09;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec04Window {
    private static final AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        eventStream()
//                .window(5)
                .window(Duration.ofSeconds(2))
                .flatMap(eventFlux -> saveEvents(eventFlux))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Mono<Integer> saveEvents(Flux<String> eventFlux) {
        return eventFlux
                .doOnNext(string -> System.out.println("saved: " + string))
                .doOnComplete(() -> System.out.println("completed"))
                .then(Mono.just(atomicInteger.getAndIncrement()));

    }

//    private static Mono<Void> saveEvents(Flux<String> eventFlux) {
//        return eventFlux
//                .doOnNext(string -> System.out.println("saved: " + string))
//                .doOnComplete(() -> System.out.println("completed"))
//                .then();
//    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(aLong -> "event" + aLong);
    }
}