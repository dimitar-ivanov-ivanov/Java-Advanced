package com.company.RawData.Models;

public class Engine {
    private int speed;
    private int power;

    public Engine(Integer speed, Integer power) {
        this.speed = speed;
        this.power = power;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
