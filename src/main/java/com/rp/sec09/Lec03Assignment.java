/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec09;

import com.rp.courseutil.Util;
import com.rp.sec09.bookhelper.BookOrder;
import com.rp.sec09.bookhelper.RevenueReport;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lec03Assignment {
    public static void main(String[] args) {

        Set<String> allowedCategories = Set.of(
                "Science fiction",
                "Fantasy",
                "Suspense/Thriller"
        );

        bookOrderFlux()
                .filter(book -> allowedCategories.contains(book.getCategory()))
                .buffer(Duration.ofSeconds(2))
                .map(orders -> mapToRevenue(orders))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);

    }

    private static RevenueReport mapToRevenue(List<BookOrder> orders) {
        Map<String, Double> revenue = orders.stream()
                .collect(Collectors.groupingBy(BookOrder::getCategory,
                        Collectors.summingDouble(BookOrder::getPrice)));
        return new RevenueReport(revenue);
    }

    public static Flux<BookOrder> bookOrderFlux() {
        return Flux.interval(Duration.ofMillis(200))
                .map(aLong -> new BookOrder());
    }
}