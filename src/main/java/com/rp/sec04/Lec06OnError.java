/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec04;

import com.rp.courseutil.Util;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .map(i -> 10 / (5-i))
//                .onErrorReturn(-1)
//                .onErrorResume((e) -> callback())
                .onErrorContinue((e, o) -> {

                })
                .subscribe(Util.subscriber());
    }

    private static Publisher<? extends Integer> callback() {
        return Mono.just(-1);
    }
}