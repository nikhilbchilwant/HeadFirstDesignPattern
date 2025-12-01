package com.headfirst.ch6.command.remote;

public interface Command {
    public void execute();
    public void undo();
}
