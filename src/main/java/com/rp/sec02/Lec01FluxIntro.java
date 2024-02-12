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

public class Lec01FluxIntro {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.just(1, 2, 3, "a", "b", "c");
        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Flux<Object> flux2 = Flux.empty();
        flux2.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Flux<Object> flux3 = Flux.error(() -> new RuntimeException("run time ex"));
        flux3.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}