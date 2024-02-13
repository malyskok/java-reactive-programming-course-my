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

public class Lec04FluxCreateCancel {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            int counter = 0;
            String country;
            String name;
            do {
                country = Util.faker().country().name();
                name = Util.faker().name().fullName();
                System.out.println("Emmit: " + country);
                fluxSink.next(country);
                System.out.println("Emmit: " + name);
                fluxSink.next(name);
                counter++;
            } while (!country.toLowerCase().equals("poland") && !fluxSink.isCancelled() && counter < 10);
            fluxSink.complete();
        });
        flux
                .take(3)
                .subscribe(Util.subscriber());
    }
}