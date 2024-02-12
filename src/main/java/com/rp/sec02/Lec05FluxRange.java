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

public class Lec05FluxRange {
    public static void main(String[] args) {
//        Flux.range(10,3)
//                .log()
//                .map((i) -> Util.faker().name().fullName())
//                .log()
//                .subscribe(Util.onNext());

        //fail on 2nd ERROR: / by zero
        Flux.range(3, 5)
                .log()
                .map(i -> i / (i - 4))
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}