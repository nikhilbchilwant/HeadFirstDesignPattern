package com.headfirst.appendix.chainofresponsibility;

public class ClientTest {
    public static void main(String[] args) {
        System.out.println("--- Chain of Responsibility Pattern ---");

        // 1. Setup the chain
        Handler spamHandler = new SpamHandler();
        Handler fanHandler = new FanHandler();
        Handler complaintHandler = new ComplaintHandler();

        // Chain order: Spam -> Fan -> Complaint
        spamHandler.setSuccessor(fanHandler);
        fanHandler.setSuccessor(complaintHandler);

        // 2. Create requests
        Email spam = new Email(EmailType.SPAM, "Buy cheap meds!", "me@example.com", "spammer@bad.com");
        Email fan = new Email(EmailType.FAN, "I love your design patterns!", "me@example.com", "fan@good.com");
        Email complaint = new Email(EmailType.COMPLAINT, "I want a refund!", "service@example.com", "angry@mad.com");
        Email general = new Email(EmailType.GENERAL, "Hello friend", "me@example.com", "friend@nice.com");

        // 3. Pass requests to the head of the chain
        System.out.println("\nProcessing Spam Email:");
        spamHandler.handleRequest(spam);

        System.out.println("\nProcessing Fan Email:");
        spamHandler.handleRequest(fan);

        System.out.println("\nProcessing Complaint Email:");
        spamHandler.handleRequest(complaint);

        System.out.println("\nProcessing General Email:");
        // This will fall through the chain unhandled (which is a valid scenario)
        spamHandler.handleRequest(general);
    }
}
