package com.headfirst.appendix.builder;

import java.util.ArrayList;
import java.util.List;

// Product
public class Vacation {
    // Add fields for vacation parts (List<String> events, String hotel, etc.)
    private List<String> events;
    private String hotel;   

    public Vacation() {
        events = new ArrayList<>();
    }
    
    public void addEvent(String event) {
        // add event to list
        events.add(event);
    }
    
    public void setHotel(String hotel) {
        // set hotel
        this.hotel = hotel;
    }
    
    public String toString() {
        // return description of vacation
        return "Vacation Details: " + events.toString() + ", " + hotel;
    }
}
