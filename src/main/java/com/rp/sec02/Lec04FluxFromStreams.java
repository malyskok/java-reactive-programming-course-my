/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStreams {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.fromStream(List.of(1,2,3).stream());
        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        List<Integer> integers = List.of(1, 2, 3);
        Flux<Integer> flux2 = Flux.fromStream(() -> integers.stream());
        flux2.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        flux2.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}