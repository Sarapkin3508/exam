package com.ifmo.exam;

import java.time.LocalDate;
import java.time.LocalTime;

public class FullTicket extends Ticket {
    public boolean pool = true;
    private boolean gym = true;
    private boolean groupTraining = true;

   private LocalTime start = LocalTime.of(8, 0, 0);
   private LocalTime end = LocalTime.of(22, 0, 0);


    public FullTicket(String type, LocalDate dateOfRegistration, LocalDate dateOfExpiry, String name, String surname, LocalDate yearOfBirth) {
        super(type, dateOfRegistration, dateOfExpiry, name, surname, yearOfBirth);

    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }
    // public void timeOfActivity(Session timeOfSession){
   // if (start < )


    public boolean isPool() {
        return pool;
    }

    public boolean isGym() {
        return gym;
    }

    public boolean isGroupTraining() {
        return groupTraining;
    }
}

