/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        //endless loop
        Flux.generate(synchronousSink -> {
                    synchronousSink.next(Util.faker().country().name());
//                    synchronousSink.next(Util.faker().country().name());// ERROR : More than one call to onNext
//                    synchronousSink.complete(); //only one
//                    synchronousSink.error(new RuntimeException("oops"));//only one and error then
                })
                .take(2)
                .subscribe(Util.subscriber());
    }
}