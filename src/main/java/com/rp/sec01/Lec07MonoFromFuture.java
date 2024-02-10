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

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {
    public static void main(String[] args) {
        Mono<String> mono = Mono.fromFuture(getName());
        mono.subscribe(Util.onNext());
        Util.sleepSeconds(2);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}