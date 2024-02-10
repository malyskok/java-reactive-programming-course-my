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

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {
        Mono<Object> mono = Mono.fromRunnable(timeConsumingProcess());
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                () -> {
                    System.out.println("sending emails...");
                }
        );

        Util.sleepSeconds(5);
    }

    private static Runnable timeConsumingProcess() {
        System.out.println("timeConsumingProcess started");
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("timeConsumingProcess ended");
        };
    }
}