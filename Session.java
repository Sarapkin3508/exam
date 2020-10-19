package com.ifmo.exam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Session {
    private String surname;
    private String name;
    private LocalTime timeOfSession;
    private boolean accessToZone;
    private Ticket[] allTickets = new Ticket[100];
    private boolean accessToPool;
    private boolean accessToGym;
    private boolean accessToGroup;


    public Session(String surname, String name, LocalTime timeOfSession, boolean access) {
            if (surname == null || surname.length() < 3)
            throw new IllegalArgumentException("surname == null or surname.length() < 3");
        if (name == null || name.length() < 3)
            throw new IllegalArgumentException("name == null || name.length() < 3");
        this.surname = surname;
        this.name = name;
        this.timeOfSession = timeOfSession;
        this.accessToZone = access;
    }

    public static Ticket createTicket(String type, LocalDate dateOfRegistration, LocalDate dateOfExpiry, String name, String surname, LocalDate yearOfBirth) {
        String strWithDate = "2012-05-14"; // День открытия Фитнес клуба
        LocalDate dayOfOpening = LocalDate.parse(strWithDate);
        if (dateOfRegistration.isBefore(dayOfOpening) || dateOfRegistration == null)
            throw new IllegalArgumentException("Неправильная дата");
        if (dateOfExpiry == null)
            throw new IllegalArgumentException("Неправильная дата");
        if (name.length() < 2 || name == null)
            throw new IllegalArgumentException("name.length() < 2 or name == null");
        if (surname.length() < 2 || surname == null)
            throw new IllegalArgumentException("surname.length() < 2 or surname == null");
        if (dateOfRegistration.isAfter(dateOfExpiry))
            throw new IllegalArgumentException("Дата регистрации должна быть позже даты окончания ");
        String[] types = {"fullTicket", "singleTicket", "dailyTicket"};
        Ticket ticket = null;
        switch (type) {
            case "fullTicket":
                ticket = new FullTicket("fullTicket", dateOfRegistration, dateOfExpiry, name, surname, yearOfBirth);
                ticket.type = "fullTicket";
                break;
            case "singleTicket":
                ticket = new SingleTicket("singleTicket", dateOfRegistration, dateOfExpiry, name, surname, yearOfBirth);
                ticket.type = "singleTicket";
                break;
            case "dailyTicket":
                ticket = new DailyTicket("dailyTicket", dateOfRegistration, dateOfExpiry, name, surname, yearOfBirth);
                ticket.type = "dailyTicket";
            break;


        }
        return ticket;

    }


    public boolean isAccess() {
        return accessToZone;
    }

    public void setAccess(boolean access) {
        this.accessToZone = access;
    }

   // public void timeOfActivity(Ticket ticket) {
   //     if (ticket < Session.)


    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public LocalTime getTimeOfSession() {
        return timeOfSession;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeOfSession(LocalTime timeOfSession) {
        this.timeOfSession = timeOfSession;
    }

    public static boolean access(String type, LocalTime currentTime){
         boolean a = true;


     return a;
    }
}










