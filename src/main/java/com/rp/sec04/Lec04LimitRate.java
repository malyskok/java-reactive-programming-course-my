/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
//                .limitRate(100) //consume 75% and as for next 75 items
//                .limitRate(100, 100) //consume 75% and as for next 75 items
//                .limitRate(100, 0) //consume 100% and as for next 100 items
                .limitRate(100, 99) //consume 99% and as for next 99 items
                .subscribe(Util.subscriber());
    }
}