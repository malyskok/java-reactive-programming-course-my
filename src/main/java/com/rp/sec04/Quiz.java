/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec04;

import reactor.core.publisher.Flux;

public class Quiz {
    public static void main(String[] args) {
//        Flux<Integer> range = Flux.range(1, 10);
//        range.map(i -> i * 10);
//        range.subscribe(System.out::println);

        Flux.range(1, 10)
                .filter(i -> i > 5)
                .take(2)
                .next()
                .subscribe(System.out::println);
    }
}