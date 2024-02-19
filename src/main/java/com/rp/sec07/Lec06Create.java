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
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec06Create {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "16");
        List<Object> list = new ArrayList<>();
        Flux.create(fluxSink -> {
                            for (int i = 0; i < 201 && !fluxSink.isCancelled(); i++) {
                                fluxSink.next(i);
                                System.out.println("publish: " + i);
                                Util.sleepMillis(1);
                            }
                            fluxSink.complete();
                        },
                        FluxSink.OverflowStrategy.ERROR)
//                .onBackpressureError() //this operator discards elements that it drops, after having propagated the error.
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(o -> Util.sleepMillis(10))
                .subscribe(Util.subscriber());

        System.out.println(list);
        Util.sleepSeconds(60);
    }
}