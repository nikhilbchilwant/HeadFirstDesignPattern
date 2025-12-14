package com.headfirst.appendix.interpreter;

public class InterpreterTest {
    public static void main(String[] args) {
        System.out.println("--- Interpreter Pattern ---");
        
        // Grammar: "fly" or "quack"
        // Grammar: "repeat <n> <command>" OR "fly" OR "quack"
        String script = "repeat 2 fly quack fly";
        Context context = new Context(script);
        
        // Build the Parse Tree
        Sequence sequence = new Sequence();
        sequence.addExpression(new FlyCommand());
        sequence.addExpression(new QuackCommand());
        // Note: we pass null as the sub-command because our simple logic 
        // just peeks at the string dynamically instead of building a static tree.
        sequence.addExpression(new RepetitionCommand(null));
        
        // Execute loop
        while (context.getData().length() > 0) {
            if (!sequence.interpret(context)) {
                System.out.println("Unknown command: " + context.getData());
                break;
            }
        }
        
        System.out.println("Result:\n" + context.getOutput());
    }
}
