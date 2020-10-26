package com.ifmo.exam;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
         Ticket[] allTickets = new Ticket[100];
        Ticket nul = null;
        Scanner scanner = new Scanner(System.in);
        LocalTime currentTime = LocalTime.now();
        allTickets[0] = Session.createTicket("fullTicket", LocalDate.parse("2020-05-14"), LocalDate.parse("2020-10-20"), "Петр",
                "Иванов", LocalDate.parse("1998-08-12"));
        allTickets[1] = Session.createTicket("singleTicket", LocalDate.parse("2020-05-14"), LocalDate.parse("2020-05-15"), "Иван",
                "Петров", LocalDate.parse("1998-08-12"));
        allTickets[2] = Session.createTicket("fullTicket", LocalDate.parse("2020-05-14"), LocalDate.parse("2020-11-20"), "Александра",
                "Григорьева", LocalDate.parse("1998-08-12"));

        LocalDate currentDate = LocalDate.now();
        System.out.println("Сегодняшняя дата: "+currentDate);
        System.out.println("Текущее время: "+currentTime);


        System.out.println("Введите своё имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите свою фамилию: ");
        String surname = scanner.nextLine();

        Session session = new Session(surname, name, LocalTime.of(20, 30, 10), true);

        LocalTime startOfDay = LocalTime.of(8, 0, 0);
        LocalTime endofDay = LocalTime.of(22, 0, 0);

        session.Check(name, surname, allTickets);


    }
}







