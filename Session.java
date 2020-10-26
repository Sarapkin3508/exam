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
        public void Check(String name, String surname, Ticket allTickets[]) {


        int t = -1;
        for (int i = 0; i < allTickets.length; i++) {
            if (allTickets[i].getName() == name && allTickets[i].getSurname() == surname) {
                t = i;
                i = allTickets.length;
                System.out.println(t);
            } else {
                t = 55;
                i = allTickets.length;
            }
        }
        if (t == 55) {
            System.out.println("Имя и фамилия отсутсвуют в базе");
            System.out.println("Пожалуйста, пройдите процедуру регистрации ");
            System.out.println("Ваше имя: ");
            String name1 = scanner.nextLine();
            System.out.println("Ваша фамилия: ");
            String surname1 = scanner.nextLine();

            System.out.println("До какой даты хотите получить абонемент? (Формат даты: ГГГГ-ММ-ДД)");
            String dateReg = scanner.nextLine();
            System.out.println("Укажите дату рождения: (Формат даты: ГГГГ-ММ-ДД)");
            String birthDate = scanner.nextLine();
            int j = 0;
            for (int g = 0; g < allTickets.length; g++) {
                if (allTickets[10] == nul) {
                    t = g;
                    g = allTickets.length;
                }

            }
            System.out.println("Укажите тип абонемента: 1 - Полный, 2 - Дневной, 3 - Разовый");
            String type1;
            int answer1 = scanner.nextInt();
            switch (answer1){
                case 1:
                    type1 = "fullTicket";
                    allTickets[t] = Session.createTicket(type1,currentDate, LocalDate.parse(dateReg), name1, surname1, LocalDate.parse(birthDate));
                    break;
                case 2:
                    type1 = "dailyTicket";
                    allTickets[t] = Session.createTicket(type1,currentDate, LocalDate.parse(dateReg), name1, surname1, LocalDate.parse(birthDate));
                    break;
                case 3:
                    type1 = "singleTicket";
                    allTickets[t] = Session.createTicket(type1,currentDate, LocalDate.parse(dateReg), name1, surname1, LocalDate.parse(birthDate));
                    break;
            }
        }
        if (t >= 0) {
            System.out.println("Пользователь найден, тариф - " + allTickets[t].type);
            if (currentTime.isBefore(endofDay) && currentTime.isAfter(startOfDay)){
                if (currentDate.isBefore(allTickets[t].dateOfExpiry)){
                    System.out.println("Фитнесс клуб открыт");
                    if (allTickets[t].type == "dailyTicket" && currentTime.isAfter(LocalTime.of(16, 0, 0))
                            || allTickets[t].type == "fullTicket" || allTickets[t].type == "singleTicket") {
                        boolean dowhile = false;
                        do {
                            Fitness fitness = new Fitness(false, false, false);
                            fitness.ticketAccess(allTickets[t].type);
                            System.out.println("Какую зону вы хотите посетить? 1 - бассейн, 2 - групповые занятия, 3 - тренажерный зал, " +
                                    "\n4 - узнать информацию о посещаемости зон, 5 - выход");
                            int answer = scanner.nextInt();
                            switch (answer) {
                                case 1:
                                    if (fitness.isAccessToPool()){
                                        fitness.goToPool();
                                        System.out.println("Приятного времяпровождения (нажмите любую кнопку чтобы выйти из бассейна)");
                                        String dummy1 = scanner.nextLine();
                                        System.out.println(dummy1);
                                        fitness.returnFromPool();}
                                    else {
                                        System.out.println("Ваш тариф " + allTickets[t].type + " не имеет доступа к бассейну");
                                    }
                                    break;
                                case 2:
                                    if (fitness.isAccessToGroup()) {
                                        fitness.goToGroup();
                                        System.out.println("Приятного времяпровождения (нажмите любую кнопку чтобы выйти из групповых занятий)");
                                        String dummy2 = scanner.nextLine();
                                        System.out.println(dummy2);
                                        fitness.returnFromGroup();
                                    }
                                    else {
                                        System.out.println("Ваш тариф " + allTickets[t].type + " не имеет доступа к групповым занятиям");
                                    }
                                    break;
                                case 3:
                                    if (fitness.isAccessToGym()) {
                                        fitness.goToGym();
                                        System.out.println("Приятного времяпровождения (нажмите любую кнопку чтобы выйти из тренажерного зала)");
                                        String dummy3 = scanner.nextLine();
                                        System.out.println(dummy3);
                                        fitness.returnFromGym();
                                    }
                                    else {
                                        System.out.println("Ваш тариф " + allTickets[t].type + " не имеет доступа к тренажерному залу");
                                    }
                                    break;
                                case 4:
                                    System.out.println(fitness.output());
                                    break;
                                case 5:
                                    dowhile = true;
                                    break;
                                default:
                                    System.out.println("Ошибка, поробуйте ещё раз");
                                    break;

                            }

                        }while (dowhile == false);
                        if (currentTime.isAfter(endofDay)){
                            Fitness fitness1 = new Fitness(false, false, false);
                            for (int p = 0;p < 20;p++) {
                                fitness1.returnFromGroup();
                                fitness1.returnFromGym();
                                fitness1.returnFromPool();

                            }
                        }
                        System.out.println("Благодарим за посещение, приходите к нам ещё!");
                    }
                    else{
                        System.out.println("По вашему тарифу вы можете заниматься до 16-00. Текущее время: " + currentTime);
                    }

                }
                else {
                    System.out.println("Ваш абонемент просрочен");
                }
            }
            else {
                System.out.println("Фитнесс клуб закрыт, приходите завтра с 8 утра!");
            }




        }

    }
}










