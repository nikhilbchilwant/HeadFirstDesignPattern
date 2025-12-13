# Appendix: Leftover Patterns

This module explores the additional patterns referenced in the Appendix of Head First Design Patterns.

## 🏗️ Patterns Structure

### 1. Bridge
**Scenario**: Decoupling a Remote Control (Abstraction) from the TV implementation (Implementor).
- **Files**: `RemoteControl`, `GenericRemote`, `TV`, `Sony`.
- **Key Learning**: Allows the Abstraction (controls) and Implementation (hardware) to vary independently.
- **Mechanism**: Usage of **Composition** (`RemoteControl` HAS-A `TV`) instead of Inheritance allows switching implementations at runtime and prevents "Class Explosion" (e.g., `SonyRemote`, `SonyAdvancedRemote`, `LGRemote`...).

### 2. Builder
**Scenario**: building a complex `Vacation` package step-by-step.
- **Files**: `VacationBuilder`, `OutdoorsVacationBuilder`, `Vacation`, `TripDirector`.
- **Key Learning**:
    1.  **GoF Style**: Uses a `Director` to orchestrate an `AbstractBuilder`. Good for enforcing a specific construction sequence or when the construction algorithm is complex.
    2.  **Effective Java Style** (`Pizza.java`): Uses a static inner `Builder` class with a **Fluent Interface** (method chaining). Best for creating immutable objects with many optional constructor parameters ("Telescoping Constructor" problem).

### 3. Chain of Responsibility
**Scenario**: Processing incoming emails through a series of handlers (Spam -> Fan -> Complaint).
- **Files**: `Handler`, `SpamHandler`, `FanHandler`, `ComplaintHandler`, `Email`.

### 4. Flyweight (TODO)
**Scenario**: efficiently rendering a generic forest of trees.

### 5. Interpreter (TODO)
**Scenario**: interpreting a simple language or expression.

### 6. Mediator (TODO)
**Scenario**: centralizing communication between objects (e.g., Home Automation).

### 7. Memento (TODO)
**Scenario**: saving and restoring state (e.g., Game Save).

### 8. Prototype (TODO)
**Scenario**: cloning objects to save creation costs (e.g., Monster Spawner).

### 9. Visitor (TODO)
**Scenario**: adding operations to a structure without changing it (e.g., Menus).
