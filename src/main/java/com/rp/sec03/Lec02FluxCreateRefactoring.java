/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec03;

import com.rp.courseutil.Util;
import com.rp.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactoring {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux<String> flux = Flux.create(nameProducer);
        flux.subscribe(Util.subscriber("sub1"));
        flux.subscribe(Util.subscriber("sub2")); // invoke accept in NameProducer, why only sub2?

        Runnable runnable = nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}