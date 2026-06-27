package com.library.library_management;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class LambdaPractice {
    public static void main(String[] args){
        // exercise1- basic
        //using anonymouse class i.e no need to create another class(implementing runnable) than object of it
        // creating instant object of imaginary class and using Runnable interface
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running without lambda");
            }
        };
        // lambda only work for functional interface i.e with only one abstract method
        Runnable r2 = () -> {System.out.println("with lambda");};

        r1.run();
        r2.run();
        //------------------------------
        BiFunction<Integer,Integer,Integer> add = (a,b)-> {
            return (a + b);
        };
        System.out.println(add.apply(43,2));
        //------------------
        List<String> books = Arrays.asList("harry potter", "the battle of five armies", "hobbit");
        // lmbda funcitn to bet eadch book
        books.forEach(booki-> System.out.println(booki));
        books.forEach(booki-> {
            if (booki.length() >= 10) System.out.println(booki);
        });
    }
}
