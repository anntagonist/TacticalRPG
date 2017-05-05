package com.gdt;

public class BaseTest {

    public static void main(String... args){
        MyLogger log = MyLogger.getInstance();

        log.info("Testing Information Template: The {} ate the {}.  It was {}!", "dog", "cat", "Funny");
        log.warn("Testing Warning Template: Danger {}! Danger, there are {} {} at the {}!", "Andrew", 13, "monkeys", "zoo");
        log.error("Testing Error Template: I have {} brackets, but only {} arguments. {}", 3, 2);
    }
}
