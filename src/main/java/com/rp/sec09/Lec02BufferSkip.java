/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec09;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02BufferSkip {
    public static void main(String[] args) {

        getEventStream()
//                .buffer(3)
//                .buffer(3, 3)//.buffer(3)
//                .buffer(3, 1)//always receives 3 latest
                .buffer(3, 5)//sampling
                .subscribe(Util.subscriber());

        Util.sleepSeconds(30);
    }

    private static Flux<String> getEventStream() {
        return Flux.interval(
                        Duration.ofMillis(300)
                )
                .map(i -> "event" + i);
    }
}