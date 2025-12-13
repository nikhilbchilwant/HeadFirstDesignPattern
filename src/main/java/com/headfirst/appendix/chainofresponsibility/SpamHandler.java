package com.headfirst.appendix.chainofresponsibility;

public class SpamHandler extends Handler {
    public void handleRequest(Email email) {
        if (email.getType().equals(EmailType.SPAM)) {
            System.out.println("Spam detected!");
        } else if (successor != null) {
            successor.handleRequest(email);
        }
    }
}
