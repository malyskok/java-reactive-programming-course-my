/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec08.helper.airline;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Qatar {
    public static Flux<String> getFlights() {
        return Flux.range(1, 1000)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Qatar" + Util.faker().random().nextInt(1, 100))
                .filter(s -> Util.faker().random().nextBoolean());
    }
}