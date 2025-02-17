package com.philemmons;

import java.util.Random;

public class DodgeWarrior extends Warrior {
    double dodgePercent;
    Random rand = new Random();

    public DodgeWarrior(String name, int health, int attackMax, int defendMax, double dodgePercent) {
        super(name, health, attackMax, defendMax);
        this.dodgePercent = dodgePercent;

        teleportType = new CanTeleport();
        powerType = new PowerOn();
    }

    @Override
    public int defend() {
        double chance = rand.nextDouble();
        if (chance <= dodgePercent) {
            System.err.printf("%s Dodged the Attack\n\n", this.getName());
            return 10000;
        } else {
            return 1 + (int) (Math.random() * ((defendMax - 1) + 1));
        }
    }

}
