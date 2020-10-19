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

        LocalDate currentDate = LocalDate.now();
        System.out.println("Сегодняшняя дата: "+currentDate);
        System.out.println("Текущее время: "+currentTime);
        /*
        System.out.println("Введите своё имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите свою фамилию: ");
        String surname = scanner.nextLine();

         */
        Session session = new Session("Ивановв", "Петр", LocalTime.of(20, 30, 10), true);



        LocalTime startOfDay = LocalTime.of(8, 0, 0);
        LocalTime endofDay = LocalTime.of(22, 0, 0);
        // Фамилия = surname
        // Имя = name
        // Зона = zone
        // Session.createTicket("fullTicket", "");
        // if (currentTime.isBefore(endofDay) && currentTime.isAfter(startOfDay)){
        //if (Ticket.)

        allTickets[0] = Session.createTicket("fullTicket", LocalDate.parse("2020-05-14"), LocalDate.parse("2020-10-20"), "Петр",
                "Иванов", LocalDate.parse("1998-08-12"));
        allTickets[1] = Session.createTicket("singleTicket", LocalDate.parse("2020-05-14"), LocalDate.parse("2020-05-15"), "Иван",
                "Петров", LocalDate.parse("1998-08-12"));
        allTickets[2] = Session.createTicket("fullTicket", LocalDate.parse("2020-05-14"), LocalDate.parse("2020-11-20"), "Александра",
                "Григорьева", LocalDate.parse("1998-08-12"));
       /* System.out.println(session.getName().length());
        System.out.println(allTickets[1].getName().length());
        System.out.println(session.getSurname().length());
        System.out.println(allTickets[1].getSurname().length());

        */


        System.out.println(Arrays.toString(allTickets));
        System.out.println(allTickets[0].getName());
        int t = -1;
        for (int i = 0; i < allTickets.length; i++) {
            if (allTickets[i].getName() == session.getName() && allTickets[i].getSurname() == session.getSurname()) {
                t = i;
                i = allTickets.length;
                System.out.println(t);
            }
            else {
                t = 55;
                i = allTickets.length;
            }
        }
        if (t == 55){
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
            for (int g = 0;g < allTickets.length;g++){
                if (allTickets[10] == nul){
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
                                        fitness.returnFromGym();
                                        System.out.println(dummy3);
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
                System.out.println("Фитнесс клуб закрыт, приходите завтра с 8 ура!");
            }




        }





    }
}







