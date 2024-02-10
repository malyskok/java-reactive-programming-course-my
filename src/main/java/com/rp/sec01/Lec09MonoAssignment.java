/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec01;

import com.rp.courseutil.Util;
import com.rp.sec01.assingment.FileService;

public class Lec09MonoAssignment {
    public static void main(String[] args) {
        FileService.readMono("file1.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        FileService.readMono("file2.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        FileService.writeMono("file3.txt", "file3").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        FileService.readMono("file3.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        FileService.deleteMono("file3.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        FileService.readMono("file3.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}