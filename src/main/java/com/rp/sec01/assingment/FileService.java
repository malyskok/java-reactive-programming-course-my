/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.rp.sec01.assingment;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileService {

    private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");

    public static Mono<String> readMono(String fileName){
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<Void> writeMono(String fileName, String content){
        return Mono.fromRunnable(() -> writeFile(fileName, content));
    }

    public static Mono<Void> deleteMono(String fileName){
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    private static String readFile(String fileName){
        try{
            return Files.readString(PATH.resolve(fileName));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(String fileName, String content){
        try{
            Files.writeString(PATH.resolve(fileName), content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void deleteFile(String fileName){
        try{
            Files.delete(PATH.resolve(fileName));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}