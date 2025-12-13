package com.headfirst.appendix.chainofresponsibility;

public class ComplaintHandler extends Handler {
    public void handleRequest(Email email) {
        if (email.getType().equals(EmailType.COMPLAINT)) {
            System.out.println("Complaint received!");
        } else if (successor != null) {
            successor.handleRequest(email);
        }
    }
}
