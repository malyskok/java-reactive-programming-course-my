/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.courseutil;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNames(int count){
        List<String> names = new ArrayList<>();
        for(int i = 0; i < count; i++){
            names.add(getName());
        }
        return names;
    }

    private static String getName(){
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }

    public static Flux<String> getNamesFlux(int count) {
        return Flux.range(0, count)
                .map(i -> getName());
    }
}