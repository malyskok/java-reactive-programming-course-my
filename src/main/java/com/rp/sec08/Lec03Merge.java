/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec08;

import com.rp.courseutil.Util;
import com.rp.sec08.helper.airline.Qatar;
import com.rp.sec08.helper.airline.LotAir;
import reactor.core.publisher.Flux;

public class Lec03Merge {
    public static void main(String[] args) {
        Flux.merge(Qatar.getFlights(), LotAir.getFlights())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}