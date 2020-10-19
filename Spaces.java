package com.ifmo.exam;

public interface Spaces {
    default void noFreeSpace(){
        System.out.println("В данной зоне нету свободных мест");
    }
}
