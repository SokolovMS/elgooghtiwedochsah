package com.eight.zero.three;

public class MainClass {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("1");
        MainHandler.run("a_example.in");
        System.out.println("2");
        MainHandler.run("b_should_be_easy.in");
        System.out.println("3");
        MainHandler.run("c_no_hurry.in");
        System.out.println("4");
        MainHandler.run("d_metropolis.in");
        System.out.println("5");
        MainHandler.run("e_high_bonus.in");
    }
}
