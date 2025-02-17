package com.philemmons;

public class WarriorGame {

    public static void main(String[] args) throws InterruptedException {
        Warrior thor = new Warrior("THOR", 40, 13, 5);
        Warrior loki = new DodgeWarrior("LOKI", 400, 8, 4, .35);

        Battle.startFight(thor, loki);
    }
}