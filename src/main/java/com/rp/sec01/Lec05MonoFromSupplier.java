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

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
//        Mono<String> mono = Mono.just(getName());

        Supplier<String> supplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(supplier);

        mono.subscribe(Util.onNext());

        Callable<String> callable = () -> getName();
        Mono<String> mono2 = Mono.fromCallable(callable);
        mono2.subscribe(Util.onNext());
    }

    private static String getName() {
        System.out.println("Generating name...");
        return Util.faker().name().name();
    }
}