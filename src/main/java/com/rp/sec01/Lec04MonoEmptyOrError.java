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

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        System.out.println(1);
        userRepository(1).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());

        System.out.println(2);
        userRepository(2).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());

        System.out.println(3);
        userRepository(3).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }

    private static Mono<String> userRepository(int id) {
        if (id == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (id == 2) {
            return Mono.empty(); //null
        } else {
            return Mono.error(() -> new RuntimeException("user id range not allowed"));
        }
    }
}