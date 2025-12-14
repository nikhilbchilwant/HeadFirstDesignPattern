package com.headfirst.appendix.interpreter;

public class Context {
    // Current input string being interpreted
    private String data;
    
    // Output/Result of interpretation (simulated execution)
    private StringBuilder output = new StringBuilder();

    public Context(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
    
    // Helper to check next token
    public boolean startsWith(String prefix) {
        return data.startsWith(prefix);
    }
    
    // Consume matched token
    public void skip(String token) {
        if (data.startsWith(token)) {
            data = data.substring(token.length()).trim();
        }
    }

    // Prepend text to the data stream (used for macro expansion)
    public void prepend(String text) {
        if (this.data == null || this.data.isEmpty()) {
            this.data = text;
        } else {
            this.data = text + " " + this.data;
        }
    }
    
    // Peek at the next word without consuming
    public String peek() {
        int spaceIndex = data.indexOf(' ');
        if (spaceIndex == -1) return data;
        return data.substring(0, spaceIndex);
    }
    
    public void addOutput(String msg) {
        output.append(msg).append("\n");
    }
    
    public String getOutput() {
        return output.toString();
    }
    
    // Modern Java: We can use regex here for parsing numbers if needed
}
