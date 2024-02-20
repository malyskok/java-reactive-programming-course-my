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
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Quiz {
    public static void main(String[] args) {
//        Flux<String> flux = Flux.just("a", "b", "c");
//        flux.startWith(flux)
//                .subscribe(Util.subscriber());

        Mono<Integer> mono1 = Mono.just(1).delayElement(Duration.ofSeconds(1));
        Flux<Integer> flux1 = Flux.just(2);
        Flux<Integer> flux2 = flux1.map(i -> i + 1).delayElements(Duration.ofMillis(500));

        Flux.merge(mono1, flux1, flux2)
                .subscribe(Util.subscriber());
    }
}