package com.philemmons;

public class Warrior {

    protected String name = "Warrior";
    public int health = 0;
    public int attackMax = 0;
    public int defendMax = 0;

    public Teleports teleportType = new CantTeleport();

    public Warrior(){
    };

    public Warrior(String name, int health, int attackMax, int defendMax){
        this.setName(name);
        this.health = health;
        this.attackMax = attackMax;
        this.defendMax = defendMax;
    }

    public int attack(){
        return 1 + (int) (Math.random() * ((attackMax - 1) + 1));
    }
    
    public int defend(){
        return 1 + (int) (Math.random() * ((defendMax - 1) + 1));
    } 

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String teleports(){
        return teleportType.teleport();
    }

    public void setTeleport(Teleports newTeleportType){
         teleportType = newTeleportType;
    }

}
