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

public class Lec02FluxHandleUntil {
    public static void main(String[] args) {
        Flux.generate((synchronousSink) -> synchronousSink.next(
                        Util.faker().country().name()))
                .map((Object::toString))
                .handle((string, synchronousSink) -> {
                    synchronousSink.next(string);
                    if (string.toLowerCase().equals("poland")) {
                        synchronousSink.complete();
                    }
                }).subscribe(Util.subscriber());
    }
}