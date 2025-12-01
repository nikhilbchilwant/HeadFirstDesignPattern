package com.headfirst.ch6.command.remote;

/**
 * Null Object pattern - default empty command.
 * Eliminates the need for null checks.
 */
public class NoCommand implements Command {
    public void execute() {}
    public void undo() {}
}
