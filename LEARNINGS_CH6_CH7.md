# Design Pattern Learnings - Chapters 6 & 7

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

---

## Chapter 7: Adapter & Facade Patterns

### Adapter Pattern

**Definition**: Converts the interface of a class into another interface clients expect. Lets classes work together that couldn't otherwise because of incompatible interfaces.

#### Duck/Turkey Example (One-Way)
- **Target**: `Duck` interface (`quack()`, `fly()`)
- **Adaptee**: `Turkey` interface (`gobble()`, `fly()`)
- **Adapter**: `TurkeyAdapter` implements Duck, wraps Turkey
- **Translation**: `quack()` → `gobble()`, `fly()` → `fly() × 5`

#### Two-Way Adapter
**Single class implements BOTH interfaces!**
- Implements `OldVendorInterface` AND `NewVendorInterface`
- Enables gradual migration from legacy to modern code
- Same adapter object works with old and new code paths
- Solves the "mixed codebase" problem

**Use Case**: Legacy system migration
- Old code expects `OldVendorInterface`
- New code expects `NewVendorInterface`  
- Two-way adapter bridges both without rewriting everything

### Facade Pattern

**Definition**: Provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

#### Home Theater Example
**Subsystem (6 components):**
- Amplifier, DvdPlayer, Projector, TheaterLights, Screen, PopcornPopper

**Without Facade:**
```java
// 10+ method calls to watch a movie!
popper.on();
popper.pop();
lights.dim(10);
screen.down();
projector.on();
// ... many more
```

**With Facade:**
```java
homeTheater.watchMovie("Raiders of the Lost Ark");
```

### Adapter vs Facade

| Aspect | Adapter | Facade |
|--------|---------|--------|
| **Intent** | Convert interface | Simplify interface |
| **Classes** | One (adaptee) | Many (subsystem) |
| **Why** | Incompatibility | Complexity |
| **Result** | New interface matches expected | Simpler interface to subsystem |

### Key Learnings

#### Adapter
✓ **Object Composition** - Wraps adaptee, no inheritance needed
✓ **Runtime Flexibility** - Can adapt different objects at runtime
✓ **Interface Translation** - Bridges incompatible interfaces
✓ **Two-Way Adapter** - One class, multiple interfaces for migration

#### Facade
✓ **Simplification** - Hide complexity behind simple interface
✓ **Principle of Least Knowledge** - Client only knows facade
✓ **Decoupling** - Subsystem can change without affecting clients
✓ **Not Limiting** - Clients can still access subsystem directly if needed

### Design Principles Applied
- **Program to interface** - Both patterns use interfaces
- **Favor composition** - Both use object composition
- **Least Knowledge** - Facade minimizes dependencies
- **Open/Closed** - Extend without modifying existing code

---

## Cross-Pattern Insights

### When to Use Each

**Command Pattern:**
- Need to parameterize objects with operations
- Queue/schedule/log operations
- Undo/redo functionality
- Macro operations (multiple commands as one)

**Adapter Pattern:**
- Working with legacy code
- Third-party libraries with incompatible interfaces
- Gradual system migration (two-way adapter)

**Facade Pattern:**
- Complex subsystem needs simplified interface
- Want to decouple clients from subsystem
- Layered architecture (facade per layer)

### Common Threads
All three patterns emphasize:
- **Encapsulation** - Hide complexity
- **Flexibility** - Easy to extend and modify
- **Decoupling** - Reduce dependencies between components
- **Object Composition** - Build complex behavior from simple parts
