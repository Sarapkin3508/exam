package com.ifmo.exam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DailyTicket extends Ticket{
    public boolean pool = false;
    private boolean gym = true;
    private boolean groupTraining = true;
    private LocalTime start = LocalTime.of(8, 0, 0);
    private LocalTime end = LocalTime.of(16, 0, 0);

    public DailyTicket(String type, LocalDate dateOfRegistration, LocalDate dateOfExpiry, String name, String surname, LocalDate yearOfBirth) {
        super(type, dateOfRegistration, dateOfExpiry, name, surname, yearOfBirth);

    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }
}
