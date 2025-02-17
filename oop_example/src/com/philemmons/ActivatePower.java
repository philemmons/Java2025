package com.philemmons;

public interface ActivatePower {
    boolean activate();
}

class PowerOn implements ActivatePower{
    @Override
    public boolean activate(){
        return true;
    }
}

class PowerOff implements ActivatePower{
    @Override
    public boolean activate(){
        return false;
    }
}
