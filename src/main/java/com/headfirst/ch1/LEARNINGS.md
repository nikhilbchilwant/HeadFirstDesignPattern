# Java 17 Modernization - Chapter 1

This document explains the Java 17 features applied to the Strategy Pattern implementation in `ch1`.

## Changes Made

### 1. Sealed Interfaces (Java 17) - REVERTED FOR EXTENSIBILITY
**What**: Sealed interfaces restrict which classes can implement them.

**Why We Tried It**: Makes the Strategy Pattern more explicit and type-safe. The compiler knows exactly which implementations exist.

**Why We Reverted It**: For a learning repository where you'll add new duck types and behaviors, sealed interfaces would prevent extension. The Strategy Pattern's strength is the Open/Closed Principle - open for extension, closed for modification.

**When to Use Sealed Interfaces**:
- ✅ Domain modeling with fixed cases (Result, Option, State machines)
- ✅ Expression trees in compilers
- ❌ Strategy Pattern in extensible systems
- ❌ Learning projects where you'll add implementations

**Current Code** (extensible):
```java
public interface FlyBehavior {
    void fly();
}
```

**What We Had** (sealed, not extensible):
```java
public sealed interface FlyBehavior permits FlyWithWings, FlyNoWay {
    void fly();
}
```

**Benefits**:
- Compiler enforces which classes can implement the interface
- Better documentation - you can see all implementations at a glance
- Enables exhaustive pattern matching in switch expressions
- Prevents unauthorized implementations

### 2. Final Classes
**What**: All implementing classes are now marked `final`.

**Why**: Required by sealed interfaces. Each permitted class must be `final`, `sealed`, or `non-sealed`.

**Files Changed**:
- `FlyWithWings.java`
- `FlyNoWay.java`
- `Quack.java`
- `MuteQuack.java`

**Example**:
```java
public final class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
```

### 3. Removed Redundant `public` Modifier
**What**: Removed `public` keyword from interface methods.

**Why**: Interface methods are public by default in Java. This is cleaner and follows modern conventions.

### 4. Local Variable Type Inference with `var` (Java 10+)
**What**: Used `var` keyword in `MiniDuckSimulator`.

**Why**: Reduces verbosity while maintaining type safety. The compiler infers the type.

**Before**:
```java
Duck mallard = new MallardDuck();
```

**After**:
```java
var mallard = new MallardDuck();
```

**Benefits**:
- Less redundant code
- Still fully type-safe (compiler knows the type)
- Easier to refactor

## Learning Points

### When to Use Sealed Interfaces
✅ **Good for**:
- Strategy Pattern - you know all strategies upfront
- State Pattern - finite set of states
- Domain models with fixed hierarchies

❌ **Not good for**:
- Plugin architectures - need open extension
- Libraries - users should be able to extend
- When you want third-party implementations

### Sealed vs Final
- **Sealed interface**: Controls who can implement
- **Final class**: Prevents subclassing
- Together: Creates a closed hierarchy

### Trade-offs
**Pros**:
- Type safety
- Exhaustive checking
- Clear documentation
- Better IDE support

**Cons**:
- Less flexible
- Can't add new implementations without modifying the interface
- May conflict with Open/Closed Principle in some cases

### 5. Functional Interfaces & Lambdas (Modern Strategy Pattern)
**What**: Replacing concrete Strategy classes with **Lambdas** or **Method References**.

**Why**: 
In modern Java, if an interface has only one abstract method (a "Functional Interface"), you don't need to create a separate class implementation for it. You can just pass a lambda.

**Example**:
Instead of:
```java
public class FlyWithRocket implements FlyBehavior {
    public void fly() { System.out.println("Rocket!"); }
}
duck.setFlyBehavior(new FlyWithRocket());
```

You can do:
```java
duck.setFlyBehavior(() -> System.out.println("Rocket!"));
```

**Benefits**:
- Drastically reduces boilerplate (fewer small classes).
- Keeps ad-hoc behaviors close to where they are used.
- More readable for simple behaviors.

**See**: `FunctionalDuckSimulator.java`

## Running the Code
```bash
mvn clean compile
java -cp target/classes com.headfirst.ch1.MiniDuckSimulator
```

Expected output remains the same:
```
Quack
I'm flying!!
I can't fly
```
