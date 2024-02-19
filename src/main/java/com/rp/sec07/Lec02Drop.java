/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec07;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec02Drop {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "16");
        //75% z 16 to 12 wiec zapelniamy bufor do 16 i wszystko co pushnieto przed otrzyamniem 12 dropimy i od nowa
        List<Object> list = new ArrayList<>();
        Flux.create(fluxSink -> {
                    for (int i = 0; i < 501; i++) {
                        fluxSink.next(i);
                        System.out.println("publish: " + i);
                        Util.sleepMillis(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureDrop(e -> list.add(e)) //Returns: a backpressured Flux that drops overflowing elements
                //keeps 16 and other are dropped until queue is open again
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(o -> Util.sleepMillis(10))
                .subscribe(Util.subscriber());

        System.out.println(list);
        Util.sleepSeconds(60);
    }
}