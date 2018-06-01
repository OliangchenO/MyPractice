package com.interview.thread.part7;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicDemo {
    private static AtomicReference<User> reference = new AtomicReference<>();
    public static void main(String[] args){
        User user1 = new User("a", 1);
        reference.set(user1);
        User user2 = new User("b",2);
        User user = reference.getAndSet(user2);
        System.out.println(user);
        System.out.println(reference.get());
    }
    
    @Data
    @AllArgsConstructor
    static class User {
        private String username;
        private int age;

    }
}
