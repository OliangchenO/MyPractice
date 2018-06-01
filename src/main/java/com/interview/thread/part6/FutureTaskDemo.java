package com.interview.thread.part6;

import java.util.concurrent.*;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i=0; i<100; i++){
            Future<String> result = es.submit(new Callback());
            System.out.println(result.get());
        }
    }

    static class Callback implements Callable<String> {

        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName();
        }
    }
}
