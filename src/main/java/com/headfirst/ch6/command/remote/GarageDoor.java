package com.headfirst.ch6.command.remote;

public class GarageDoor {
    private String location;

    public GarageDoor(String location) {
        this.location = location;
    }

    public void up() {
        System.out.println(location + " garage door is open");
    }

    public void down() {
        System.out.println(location + " garage door is closed");
    }

    public void stop() {
        System.out.println(location + " garage door is stopped");
    }

    public void lightOn() {
        System.out.println(location + " garage light is on");
    }

    public void lightOff() {
        System.out.println(location + " garage light is off");
    }
}
