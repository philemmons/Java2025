package com.philemmons;

//Utility Class - all static
public class Battle {

    public static void startFight(Warrior w1, Warrior w2) throws InterruptedException {
        while (true) {
            if (getBattleResult(w1, w2).equals("Game Over")) {
                System.err.println("Game Over!");
                break;
            }

            if (getBattleResult(w2, w1).equals("Game Over")) {
                System.err.println("Game Over!");
                break;
            }
        }
    }

    public static String getBattleResult(Warrior wOne, Warrior wTwo) throws InterruptedException {
        int wOneAttackNum = wOne.attack();
        int wTwoDefendNum = wTwo.defend();

        int dmgWarrTwo = wOneAttackNum - wTwoDefendNum;

        if (dmgWarrTwo >= 0) {
            wTwo.health -= dmgWarrTwo;
        } else {
            dmgWarrTwo = 0;
        }

        System.out.printf("%s attacks %s and deals " + "%d Damage\n", wOne.getName(), wTwo.getName(), dmgWarrTwo);

        if (wTwo.health <= 0 && (wTwo.teleportType.teleport().equals("Teleports Away!"))) {
            System.out.printf("%s has Teleports Away!\n", wTwo.getName());
            return "Game Over";
        } else {
            System.out.printf("%s has %d health\n\n", wTwo.getName(), wTwo.health);
        }

        Thread.sleep(250);

        if (wTwo.health > 0)
            return "Battle Continues";
        else {
            System.out.printf("%s has Died and %s is Victorious!\n", wTwo.getName(), wOne.getName());
            return "Game Over";
        }
    }
}