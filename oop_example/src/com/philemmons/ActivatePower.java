package com.philemmons;

public interface ActivatePower {
    String activate();
}

class PowerOn implements ActivatePower{
    @Override
    public String activate(){
        return "Power Surge!";
    }
}

class PowerOff implements ActivatePower{
    @Override
    public String activate(){
        return "Power Fizzle...";
    }
}
