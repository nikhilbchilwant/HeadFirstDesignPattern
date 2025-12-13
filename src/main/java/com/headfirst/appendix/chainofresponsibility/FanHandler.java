package com.headfirst.appendix.chainofresponsibility;

public class FanHandler extends Handler {
    public void handleRequest(Email email) {
        if (email.getType().equals(EmailType.FAN)) {
            System.out.println("Fan mail received!");
        } else if (successor != null) {
            successor.handleRequest(email);
        }
    }
}
