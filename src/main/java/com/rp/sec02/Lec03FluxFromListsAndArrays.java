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

import java.util.Arrays;

public class Lec03FluxFromListsAndArrays {
    public static void main(String[] args) {
        Flux<String> flux = Flux.fromIterable(Arrays.asList("a", "b", "c"));
        flux.subscribe(Util.onNext());

        Flux<Object> flux2 = Flux.fromArray(Arrays.asList(1, 2, 3).toArray());
        flux2.subscribe(Util.onNext());
    }
}