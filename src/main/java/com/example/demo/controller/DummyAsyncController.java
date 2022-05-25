package com.example.demo.controller;

import com.example.demo.service.DummyAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAsync
public class DummyAsyncController {

    @Autowired
    private DummyAsyncService dummyAsyncService;

    @GetMapping("/async")
    public String checkAsync() {

        long startTime = System.nanoTime();
        dummyAsyncService.dummyMethodAsync();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime)/1000000;
        System.out.println("Async Duration " + duration + Thread.currentThread().getName());

        return "Async mapping called" + Thread.currentThread().getName();
    }

    @GetMapping("/sync")
    public String checkSync() {
        long startTime = System.nanoTime();
        dummyAsyncService.dummyMethodSync();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime)/1000000;
        System.out.println("Sync Duration " + duration + Thread.currentThread().getName());

        return "Sync mapping called" + Thread.currentThread().getName();
    }

}