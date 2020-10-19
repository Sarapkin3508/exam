package com.ifmo.exam;

import com.ifmo.exam.Ticket;

public class Fitness {
    private int[] poolStatus = new int[21];
    private int[] gymStatus = new int[21];
    private int[] groupStatus = new int[21];
    private boolean accessToPool;
    private boolean accessToGym;
    private boolean accessToGroup;
    private int poolCount = 0;
    private int gymCount = 0;
    private int groupCount = 0;

    public String output(){
        String out;
        out = "В тренажерном зале: "+ gymArray() + "\nВ бассейне: " + poolArray() + "\nНа групповых занятиях: " + groupCount;
        return out;
    }

    public Fitness(boolean accessToPool, boolean accessToGym, boolean accessToGroup) {
        this.accessToPool = accessToPool;
        this.accessToGym = accessToGym;
        this.accessToGroup = accessToGroup;
    }
    private int gymArray() {
        for (int i = 1; i < gymStatus.length; i++) {
            gymCount = gymCount + gymStatus[i];
        }
        return gymCount;
    }

    private int poolArray() {
        for (int i = 1; i < poolStatus.length; i++) {
            poolCount = poolCount + poolStatus[i];
        }
        return poolCount;
    }

    private int groupArray() {
        for (int i = 1; i < groupStatus.length; i++) {
            groupCount = groupCount + groupStatus[i];
        }
        return groupCount;
    }
    public void ticketAccess(String type){
    switch (type) {
        case "fullTicket":
           accessToPool = true;
           accessToGym = true;
           accessToGroup = true;
            break;
        case "singleTicket":
            accessToPool = true;
            accessToGym = true;
            accessToGroup = false;
            break;
        case "dailyTicket":
            accessToPool = false;
            accessToGym = true;
            accessToGroup = true;
            break;
    }

    }

    public void goToPool(){
        if (freeSpacePool() == 0 ){
            accessToPool = false;
        }
        else
        poolStatus[freeSpacePool()] = 1;
        accessToPool = true;
    }
    public void returnFromPool(){
            poolStatus[notFreeSpacePool()] = 0;
    }
    private int freeSpacePool(){
        int t = 0;
        for (int i = 1;i < poolStatus.length;i++){
            if (poolStatus[i] == 0){
                t = i;
                i = poolStatus.length;
            }

        }
        return t;
    }

    private int notFreeSpacePool(){
        int t = 0;
        for (int i = 1;i < poolStatus.length;i++){
            if (poolStatus[i] == 1){
                t = i;
                i = poolStatus.length;
            }
        }
        return t;
    }

    public void goToGym(){
        if (freeSpaceGym() == 0 ){
            System.out.println("В данной зоне нету свободных мест");
        }
        else
            gymStatus[freeSpaceGym()] = 1;
    }
    public void returnFromGym(Ticket ticket){
        gymStatus[notFreeSpaceGym()] = 0;
    }
    private int freeSpaceGym(){
        int t = 0;
        for (int i = 1;i < gymStatus.length;i++){
            if (gymStatus[i] == 0){
                t = i;
                i = gymStatus.length;
            }

        }
        return t;
    }

    private int notFreeSpaceGym(){
        int t = 0;
        for (int i = 1;i < gymStatus.length;i++){
            if (gymStatus[i] == 1){
                t = i;
                i = gymStatus.length;
            }
        }
        return t;
    }

    public void goToGroup(){
        if (freeSpaceGroup() == 0 ){
            System.out.println("В данной зоне нету свободных мест");
        }
        else
            groupStatus[freeSpaceGroup()] = 1;
    }
    public void returnFromGroup(){
        groupStatus[notFreeSpaceGroup()] = 0;
    }
    private int freeSpaceGroup(){
        int t = 0;
        for (int i = 1;i < groupStatus.length;i++){
            if (groupStatus[i] == 0){
                t = i;
                i = groupStatus.length;
            }

        }
        return t;
    }

    private int notFreeSpaceGroup(){
        int t = 0;
        for (int i = 1;i < groupStatus.length;i++){
            if (groupStatus[i] == 1){
                t = i;
                i = groupStatus.length;
            }
        }
        return t;
    }

    public boolean isAccessToPool() {
        return accessToPool;
    }

    public boolean isAccessToGym() {
        return accessToGym;
    }

    public boolean isAccessToGroup() {
        return accessToGroup;
    }
}
