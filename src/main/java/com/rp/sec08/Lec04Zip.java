/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec08;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04Zip {
    public static void main(String[] args) {
        Flux.zip(getTires(), getEngines(), getWindows())
                .doOnNext(tuple -> System.out.println("tuple: " + tuple.getT3())) //windows
                .subscribe(Util.subscriber());
    }

    public static Flux<String> getTires(){
        return Flux.range(1, 6)
                .map(i-> "tires" + i);
    }

    public static Flux<String> getEngines(){
        return Flux.range(1, 2)
                .map(i-> "engine" + i);
    }

    public static Flux<String> getWindows(){
        return Flux.range(1, 4)
                .map(i-> "windows" + i);
    }
}