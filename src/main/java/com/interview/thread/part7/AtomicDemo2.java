package com.interview.thread.part7;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicDemo2 {
    private static AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public static void main(String[] args){
        User user = new User("a", 1);
        int oldValue = updater.getAndAdd(user, 5);
        System.out.println(oldValue);
        System.out.println(updater.get(user));
    }

    @Data
    @AllArgsConstructor
    static class User {
        private String username;
        public volatile int age;

    }
}
