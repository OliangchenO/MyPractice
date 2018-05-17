package com.interview.thread.part1;

import java.util.concurrent.*;

public class CreateThreadDemo {

    public static void main(String[] args){
        //1.继承Thread
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                System.out.println("继承Thread");
                super.run();
            }
        };
        thread1.start();

        //2.实现runable接口
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("实现runable接口");
            }
        });
        thread2.run();

        //3.实现callable接口
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(new Callable<String>() {
            public String call() throws Exception {
                return "通过实现Callable接口";
            }
        });
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //4.futureTask
        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
            public String call() throws Exception {
                return "通过实现FutureTask";
            }
        });

        String result="";
        Callable<String> results = Executors.callable(task, result);

    }
}
