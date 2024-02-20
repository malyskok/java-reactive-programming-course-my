/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec08;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec06Assignment {
    public static void main(String[] args) {
        AtomicInteger carPrice = new AtomicInteger(10_000);
        Flux.combineLatest(getMonthlyDevaluation(), getQuarterDevaluation(),
                        (m, q) -> (carPrice.get() - (m * 100)) * q)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(30);
    }

    private static Flux<Double> getQuarterDevaluation() {
        return Flux.interval(Duration.ofSeconds(3))
                .map(d -> Util.faker().random().nextInt(80, 120) / 100d)
                .startWith(1d);
    }

    private static Flux<Long> getMonthlyDevaluation() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }
}