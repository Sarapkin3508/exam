package com.ifmo.exam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class SingleTicket extends Ticket {
    private boolean pool = true;
    private boolean gym = true;
    private boolean groupTraining = false;
    private LocalTime start = LocalTime.of(8, 0, 0);
    private LocalTime end = LocalTime.of(22, 0, 0);

    public SingleTicket(String type, LocalDate dateOfRegistration, LocalDate dateOfExpiry, String name, String surname, LocalDate yearOfBirth) {
        super(type, dateOfRegistration, dateOfExpiry, name, surname, yearOfBirth);
        if (ChronoUnit.DAYS.between(dateOfRegistration,
                dateOfExpiry) > 1){
            throw new IllegalArgumentException("В суточном абонементе количество дней ограничевается одним днём");
        }
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

}
