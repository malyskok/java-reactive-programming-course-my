/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class Lec05Delay {
    public static void main(String[] args) {
//        Queues.XS_BUFFER_SIZE
        System.setProperty("reactor.bufferSize.x", "8");
        Flux.range(1, 1000)
                .log()
                .delayElements(Duration.ofSeconds(5)) //first item will be consumed in 5 sec and next every other 5 sec
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}