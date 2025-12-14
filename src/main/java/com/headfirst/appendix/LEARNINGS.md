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
- **Files**: `Handler`, `SpamHandler`, `FanHandler`, `ClientTest`.
- **Key Learning**: Decouples the sender of a request from its receiver. Multiple objects get a chance to handle the request.
- **Modern Alternative**:
    - **Functional Loop/Stream**: Instead of a linked list of objects, define a `Stream<Function<Request, Boolean>>`.
    - Use `stream.filter(h -> h.apply(req)).findFirst()` to find the handler that processes it.
    - **Benefits**: No need for an abstract base class or explicit `successor` management. Handlers can be simple Lambdas.
    - **See**: `FunctionalHandlerTest.java`.

### 4. Flyweight
**Scenario**: Efficiently rendering a forest of 1 million trees.
- **Files**: `TreeType` (Flyweight), `Tree` (Context), `TreeFactory`.
- **Key Learning**: drastic memory optimization by separating state:
    - **Intrinsic State**: Shared, read-only data (e.g., texture, color). stored in the Flyweight.
    - **Extrinsic State**: Unique, context-specific data (e.g., x, y position). Passed to the Flyweight when needed.
- **Origin**: Named after the boxing weight class (lightweight).
- **Modern Context**:
    - **String Pools**: Java Strings are flyweights (interned).
    - **GPU Instancing**: Game engines strictly separating Mesh data from Transform data.

### 5. Interpreter
**Scenario**: Parsing a simple duck command language: `repeat 2 fly quack`.
- **Files**: `Context`, `Expression`, `FlyCommand`, `RepetitionCommand`, `Sequence`.
- **Key Learning**: Representing a grammar as classes. Each class interprets a specific rule.
- **Advanced Concept**: **Macro Expansion**. Our `RepetitionCommand` works by dynamically rewriting the input string (e.g., `repeat 2 fly` -> `fly fly`) and injecting it back into the context for further processing.
- **Modern Context**: mostly replaced by existing scripting engines (Nashorn, GraalVM) or data formats (JSON/YAML) unless creating a specialized Domain Specific Language (DSL).

### 6. Mediator
**Scenario**: centralizing communication between objects (e.g., Home Automation).
- **Files**: `Mediator`, `Colleague`, `SmartHomeMediator`, `Alarm`, `CoffeePot`.
- **Key Learning**: Reduces chaotic dependencies ("Spaghetti Code") by forcing objects to communicate through a hub.
- **JDK Usage**: 
    - `java.util.Timer` (acts as mediator between tasks).
    - `java.util.concurrent.Executor` (mediates between tasks and threads).

### 7. Memento
**Scenario**: saving and restoring state (e.g., Game Save).
- **Files**: `GameMemento`, `GameOriginator`, `GameCaretaker`.
- **Key Learning**: Captures internal state without violating encapsulation (private fields remain private to the world, but accessible to the restoration logic).
- **JDK Usage**:
    - `java.io.Serializable` (The ultimate memento).
    - `java.util.Date` (internal long time value).

### 8. Prototype
**Scenario**: cloning objects to save creation costs (e.g., Monster Spawner).
- **Files**: `Monster`, `Dragon`, `Zombie`, `MonsterSpawner`.
- **Key Learning**: Use `clone()` (or a custom `copy()` method) to create new instances from an existing instance, bypassing the cost of `new` (DB calls, asset loading).
- **JDK Usage**:
    - `java.lang.Object.clone()` (The native cloning mechanism).
    - `java.util.ArrayList(Collection c)` (Copy constructor).

### 9. Visitor
**Scenario**: adding operations to a structure without changing it (e.g., Menus).
- **Files**: `Visitor`, `CalorieCountVisitor`, `Menu`, `MenuItem`, `Ingredient`.
- **Key Learning**: Allows you to add new operations (e.g., CalorieCount, VegetarianCheck, XMLExport) to a **Composite** structure without modifying the structure classes.
- **Double Dispatch**: The element calls `visitor.visit(this)`, passing itself back to the visitor. This ensures the method executed depends on both the Visitor type AND the Element type.
- **JDK Usage**:
    - `java.nio.file.FileVisitor` (Used by `Files.walkFileTree` to perform actions on files recursively).
    - `javax.lang.model.element.ElementVisitor` (Used in Annotation Processing).

## 📚 JDK Usage Summary (All Patterns)
| Pattern | JDK Example |
|---------|-------------|
| **Bridge** | Drivers (`java.sql.Driver`), Logging (SLF4J -> Logback/Log4j) |
| **Builder** | `java.lang.StringBuilder`, `java.util.stream.Stream.Builder`, `java.net.http.HttpClient.newBuilder()` |
| **Chain of Responsibility** | `javax.servlet.Filter` (Servlet Filters), `java.util.logging.Logger` (Parent loggers) |
| **Flyweight** | `java.lang.String` (String Pool), `java.lang.Integer.valueOf()` (Cache -128 to 127) |
| **Interpreter** | `java.util.regex.Pattern` (interprets regex string), `java.text.Format` |
| **Mediator** | `java.util.concurrent.ExecutorService` (mediates tasks), `java.util.Timer` |
| **Memento** | `java.io.Serializable`, `java.awt.geom.GeneralPath` |
| **Prototype** | `java.lang.Object.clone()`, `java.util.ArrayList` (shallow copy constructor) |
| **Visitor** | `java.nio.file.FileVisitor` (walking file trees), `javax.lang.model.element.ElementVisitor` |
