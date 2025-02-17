package com.philemmons;

//Utility Class - all static
public class Battle {

    public static void startFight(Warrior w1, Warrior w2) throws InterruptedException {

        while (true) {
            if (getBattleResult(w1, w2)) {
                System.err.println("Game Over!");
                break;
            }

            if (getBattleResult(w2, w1)) {
                System.err.println("Game Over!");
                break;
            }
        }
    }

    public static boolean getBattleResult(Warrior wOne, Warrior wTwo) throws InterruptedException {
        int wOneAttackNum = wOne.attack();
        int wTwoDefendNum = wTwo.defend();

        int dmgWarrTwo = wOneAttackNum - wTwoDefendNum;

        if (dmgWarrTwo >= 0){
            wTwo.health -= dmgWarrTwo;
        }else{
            dmgWarrTwo = 0;
        }

        System.out.printf("%s attacks %s and deals %d Damage\n", wOne.getName(), wTwo.getName(), dmgWarrTwo);

        int powerUp = (int) (wTwo.getOriginalHealth() * 0.30);

        //if (wTwo.health <= powerUp) {
        //    wTwo.powerType = new PowerOn();
        //    
        //}

        if ((wTwo.health <= powerUp) && (wTwo.teleportType.teleport())) {
            System.out.printf("%s has Teleported Away!\n", wTwo.getName());
            return true;
        }

        Thread.sleep(250);

        if (wTwo.health > 0) {
            System.out.printf("%s has %d health\n\n", wTwo.getName(), wTwo.health);
            return false;
        } else {
            System.out.printf("%s has Died and %s is Victorious!\n", wTwo.getName(), wOne.getName());
            return true;
        }
    }
}