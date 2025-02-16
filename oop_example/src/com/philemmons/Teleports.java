package com.philemmons;

public interface Teleports {
    String teleport();
}

class CanTeleport implements Teleports{
    public String teleport(){
        return "Teleported Away!";
    }

}

class CantTeleport implements Teleports{
    public String teleport(){
        return "No Teleport";
    }
}