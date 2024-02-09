/*
 * Copyright (c) Flooid Limited 2024. All rights reserved.
 * This source code is confidential to and the copyright of Flooid Limited ("Flooid"), and must not be
 * (i) copied, shared, reproduced in whole or in part; or
 * (ii) used for any purpose other than the purpose for which it has expressly been provided by Flooid under the terms of a license agreement; or
 * (iii) given or communicated to any third party without the prior written consent of Flooid.
 * Flooid at all times reserves the right to modify the delivery and capabilities of its products and/or services.
 * "Flooid", "FlooidCore", "FlooidCommerce", "Flooid Hub", "PCMS", "Vision", "VISION Commerce Suite", "VISION OnDemand", "VISION eCommerce",
 * "VISION Engaged", "DATAFIT", "PCMS DATAFIT" and "BeanStore" are registered trademarks of Flooid.
 * All other brands and logos (that are not registered and/or unregistered trademarks of Flooid) are registered and/or
 * unregistered trademarks of their respective holders and should be treated as such.
 */
package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("ball");
        mono.subscribe(
                item -> System.out.println("item: " + item),
                ex -> System.out.println("error: " + ex.getMessage()),
                () -> System.out.println("Completed"));

        System.out.println("mono2");
        Mono<Integer> mono2 = Mono.just("ball")
                .map(s -> s.length())
                .map(i -> i / 0);
        mono2.subscribe(
                item -> System.out.println("item: " + item),
                ex -> System.out.println("error: " + ex.getMessage()),
                () -> System.out.println("Completed"));

        System.out.println("mono3");
        Mono<Integer> mono3 = Mono.just("ball")
                .map(s -> s.length())
                .map(i -> i / 2);
        mono3.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}