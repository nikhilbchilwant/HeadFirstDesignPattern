package com.headfirst.appendix.interpreter;

public class RepetitionCommand implements Expression {
    private Expression commandToRepeat;

    public RepetitionCommand(Expression commandToRepeat) {
        this.commandToRepeat = commandToRepeat; // Specifically what we can repeat (e.g. a Sequence of any command)
    }

    public boolean interpret(Context context) {
        // Grammar: "repeat" <n> <command>
        // Example: "repeat 2 fly" -> expands to "fly fly"
        if (context.startsWith("repeat")) {
            context.skip("repeat");
            
            // 1. Parse N
            int count = parseCount(context);
            if (count <= 0) return false;
            
            // 2. Peek command to repeat
            String command = context.peek();
            
            // 3. Expand the string!
            StringBuilder expanded = new StringBuilder();
            for (int i = 0; i < count; i++) {
                expanded.append(command).append(" ");
            }
            
            // 4. Inject back into context
            // We removed "repeat 2", but we haven't removed the "fly" at the start yet.
            // Actually, we need to consume the "fly" from the original string so we can replace it with "fly fly"
            context.skip(command);
            
            context.prepend(expanded.toString().trim());
            
            // We handled the *expansion*, so we return true.
            // The main loop will then pick up the new "fly fly..." commands.
            return true;
        }
        return false;
    }
    
    private int parseCount(Context context) {
        // Hacky way to grab the next number
        String data = context.getData();
        String[] parts = data.split(" ");
        try {
            int count = Integer.parseInt(parts[0]);
            context.skip(parts[0]);
            return count;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
