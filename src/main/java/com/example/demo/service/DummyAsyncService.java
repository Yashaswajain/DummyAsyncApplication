package com.example.demo.service;

import java.util.concurrent.TimeUnit;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DummyAsyncService {

    @Async
    public void dummyMethodAsync() {

        sleep(5);
        System.out.println("Async method" + Thread.currentThread().getName());
    }

    public void dummyMethodSync() {

        sleep(5);
        System.out.println("Sync method" + Thread.currentThread().getName());
    }

    private void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}