package com.ifmo.exam;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
    protected LocalDate dateOfRegistration;
    protected LocalDate dateOfExpiry;
    protected String name;
    protected String surname;
    protected LocalDate yearOfBirth;
    protected String type;
    protected LocalTime start = LocalTime.of(8, 0, 0);
    protected LocalTime end = LocalTime.of(22, 0, 0);


    String strWithDate = "2012-05-14"; // День открытия Фитнес клуба
    LocalDate dayOfOpening = LocalDate.parse(strWithDate);

    public Ticket(String type, LocalDate dateOfRegistration, LocalDate dateOfExpiry, String name, String surname, LocalDate yearOfBirth) {
     // if (type != "fullTicket" || type != "singleTicket" || type != "dailyTicket")
      //     throw new IllegalArgumentException("Неправильный тип абонемента");
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
        this.dateOfRegistration = dateOfRegistration;
        this.dateOfExpiry = dateOfExpiry;
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void createTicket(){

    }
    public static String ticketName(){

        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //Fitness


    }

