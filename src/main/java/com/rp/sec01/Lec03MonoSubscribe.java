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

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("ball");
        mono.subscribe(
                item -> System.out.println("item: " + item),
                ex -> System.out.println("error: " + ex.getMessage()),
                () -> System.out.println("Completed"));

        System.out.println("mono2");
        Mono<Integer> mono2 = Mono.just("ball")
                .map(s -> s.length())
                .map(i -> i / 0);
        mono2.subscribe(
                item -> System.out.println("item: " + item),
                ex -> System.out.println("error: " + ex.getMessage()),
                () -> System.out.println("Completed"));

        System.out.println("mono3");
        Mono<Integer> mono3 = Mono.just("ball")
                .map(s -> s.length())
                .map(i -> i / 2);
        mono3.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}