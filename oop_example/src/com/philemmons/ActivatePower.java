package com.philemmons;

public interface ActivatePower {
    String activate();
}

class PowerOn implements ActivatePower{
    public String activate(){
        return "Power Surge!";
    }
}

class PowerOff implements ActivatePower{
    public String activate(){
        return "Power Fizzle...";
    }
}
