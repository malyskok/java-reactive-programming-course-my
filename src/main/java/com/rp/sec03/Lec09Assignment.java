/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Lec09Assignment {

    private static final Path PATH = Paths.get("src/main/resources/assignment/sec01/file1.txt");

    public static BufferedReader readFile() {
        try {
            return Files.newBufferedReader(PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Callable<BufferedReader> readerCallable = () -> readFile();

        BiFunction<BufferedReader, SynchronousSink<Object>, BufferedReader> readerBiFunction =
                (reader, sink) -> {
                    try {
                        String line = reader.readLine();
                        if (line != null) {
                            sink.next(line);
                            if (line.equals("d")) {
                                sink.error(new RuntimeException("oopps"));
                            }
                        } else {
                            sink.complete();
                        }
                    } catch (IOException e) {
                        sink.error(e);
                    }
                    return reader;
                };

        Consumer<BufferedReader> readerClosed = (reader) -> {
            try {
                reader.close();
                System.out.println("reader closed");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        Flux.generate(
                readerCallable,
                readerBiFunction,
                readerClosed
        ).subscribe(Util.subscriber());
    }
}