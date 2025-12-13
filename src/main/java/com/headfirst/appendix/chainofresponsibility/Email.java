package com.headfirst.appendix.chainofresponsibility;

public class Email {
    private EmailType type;
    private String content;
    private String recipient;
    private String sender;
    
    public Email(EmailType type, String content, String recipient, String sender) {
        this.type = type;
        this.content = content;
        this.recipient = recipient;
        this.sender = sender;
    }

    public EmailType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setType(EmailType type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
