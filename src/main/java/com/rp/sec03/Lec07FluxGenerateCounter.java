/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {
        Flux.generate(
                () -> 1,
                (counter, sink) -> {
                    String country = Util.faker().country().name();
                    sink.next(country);
                    if (country.toLowerCase().equals("poland") || counter++ == 5) {
                        sink.complete();
                    }
                    System.out.println(counter);
                    return counter;
                }
        ).subscribe(Util.subscriber());
    }
}