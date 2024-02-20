/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec08.helper;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    private static List<String> cacheNames = new ArrayList<>();

    public static Flux<String> generateNames() {
        return Flux.generate(synchronousSink -> {
                    System.out.println("generate fresh");
                    Util.sleepSeconds(1);
                    String name = Util.faker().name().firstName();
                    cacheNames.add(name);
                    synchronousSink.next(name);
                })
                .cast(String.class)
                .startWith(getCacheNames());
    }

    private static Flux<String> getCacheNames() {
        return Flux.fromIterable(cacheNames);
    }
}