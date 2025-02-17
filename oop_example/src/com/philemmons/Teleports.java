package com.philemmons;

public interface Teleports {
    boolean teleport();
}

class CanTeleport implements Teleports{
    @Override
    public boolean teleport(){
        return true;
    }

}

class CantTeleport implements Teleports{
    @Override
    public boolean teleport(){
        return false;
    }
}