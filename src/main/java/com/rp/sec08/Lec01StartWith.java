/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec08;

import com.rp.courseutil.Util;
import com.rp.sec08.helper.NameGenerator;

public class Lec01StartWith {
    public static void main(String[] args) {
        NameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("1"));

        NameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("2"));

        NameGenerator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("3"));

        NameGenerator.generateNames()
                .filter(string -> string.startsWith("A"))
                .take(4)
                .subscribe(Util.subscriber("3"));
    }
}