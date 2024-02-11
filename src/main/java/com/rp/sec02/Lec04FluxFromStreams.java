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
package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStreams {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.fromStream(List.of(1,2,3).stream());
        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        List<Integer> integers = List.of(1, 2, 3);
        Flux<Integer> flux2 = Flux.fromStream(() -> integers.stream());
        flux2.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        flux2.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}