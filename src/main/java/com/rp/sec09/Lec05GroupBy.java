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

import java.time.Duration;

public class Lec05GroupBy {
    public static void main(String[] args) {
        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(integer -> integer % 2)
                .subscribe(groupedFlux -> subscribeGroupedFlux(groupedFlux, groupedFlux.key()));

        Util.sleepSeconds(60);
    }

    private static void subscribeGroupedFlux(Flux<Integer> flux, Integer key) {
        System.out.println("called");
        flux.subscribe(integer -> System.out.println("handle item and key: " + integer + " " + key));
    }

}