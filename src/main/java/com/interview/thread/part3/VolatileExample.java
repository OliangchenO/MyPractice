package com.interview.thread.part3;

import java.util.AbstractQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class VolatileExample {
    private static volatile int counter = 0;
    public static void main(String[] args){
        for (int i=0; i<10; i++){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    for(int i=0; i<10000; i++){
                        counter++;
                    }
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
