## Chapter 6: Command Pattern

### Pattern Definition
**Encapsulates a request as an object**, letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

### Key Components
1. **Command Interface** - Declares `execute()` and `undo()` methods
2. **Concrete Commands** - Implement the interface, hold receiver reference
3. **Receiver** - The object that performs the actual work
4. **Invoker** - Holds commands and triggers execution
5. **Client** - Creates commands and sets them on invoker

### Examples Implemented

#### Simple Remote Control
- Basic command pattern structure
- Single command slot
- Demonstrates decoupling of invoker and receiver

#### Advanced Remote with Undo
- 7 command slots (ON/OFF pairs)
- Undo functionality
- NoCommand (Null Object pattern)
- State-based undo (CeilingFan saves previous speed)

#### MacroCommand
- Composite pattern applied to commands
- Executes multiple commands as one
- **Undo in reverse order (LIFO)** - critical for proper state restoration

#### Enterprise Version
**Modern Java 17+ features:**
- `var` keyword
- Switch expressions  
- Enum-based type safety
- `Objects.requireNonNull()` validation
- Try-catch error handling
- Custom `CommandExecutionException`
- Metadata (timestamps, descriptions)
- Structured logging
- Immutability (final fields)

### Key Learnings
✓ **Decoupling** - Invoker doesn't know about receivers
✓ **Flexibility** - Easy to add new commands without changing invoker
✓ **Queueing** - Commands can be queued, logged, scheduled
✓ **Undo/Redo** - Built-in support for reversible operations
✓ **Macro operations** - Compose commands for complex workflows

### Design Principles Applied
- **Encapsulation** - Request encapsulated as object
- **Single Responsibility** - Each command does one thing
- **Open/Closed** - Add commands without modifying invoker
