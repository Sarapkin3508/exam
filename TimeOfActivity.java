package com.ifmo.exam;

public interface TimeOfActivity {
    // метод без реализации
    void timeOfActivity(Ticket ticket);


    default void run(){
        System.out.println("run TimeOfActivity");
    }
}
