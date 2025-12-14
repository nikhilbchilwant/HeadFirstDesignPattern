package com.headfirst.appendix.chainofresponsibility;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Modern Functional Implementation of Chain of Responsibility
 * 
 * Instead of creating a class hierarchy (Handler -> SpamHandler, etc.),
 * we can use a Stream of Functions or Consumers.
 */
public class FunctionalHandlerTest {
    public static void main(String[] args) {
        System.out.println("--- Functional Chain of Responsibility ---");

        // 1. Define the behaviors as simple Lambdas (Function<Email, Boolean>)
        // Return true if handled, false if passed to next.
        Function<Email, Boolean> spamHandler = (email) -> {
            if (email.getType() == EmailType.SPAM) {
                System.out.println("FUNCTIONAL: Spam detected! Deleting.");
                return true; // Handled
            }
            return false;
        };

        Function<Email, Boolean> fanHandler = (email) -> {
            if (email.getType() == EmailType.FAN) {
                System.out.println("FUNCTIONAL: Fan mail! Sending autograph.");
                return true;
            }
            return false;
        };

        Function<Email, Boolean> complaintHandler = (email) -> {
            if (email.getType() == EmailType.COMPLAINT) {
                System.out.println("FUNCTIONAL: Complaint. Forwarding to legal.");
                return true;
            }
            return false;
        };

        // 2. Create the "Chain" as a Stream of handlers
        var handlers = Stream.of(spamHandler, fanHandler, complaintHandler);

        // 3. Process an email
        Email email = new Email(EmailType.FAN, "Love the code", "dev", "fan");
        
        System.out.println("Processing email: " + email.getType());

        // Find the first handler that returns true (Short-circuiting)
        // This effectively mimics "pass to successor" but without the boilerplate
        handlers.filter(handler -> handler.apply(email))
                .findFirst()
                .ifPresentOrElse(
                    (h) -> System.out.println("Email was handled."), 
                    () -> System.out.println("Email fell off the chain (unhandled).")
                );
    }
}
