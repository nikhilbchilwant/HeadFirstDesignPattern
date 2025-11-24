# Chapter 3: Decorator Pattern - Key Learnings

## Pattern Definition

**Decorator Pattern**: Attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

## Design Principle

**Open-Closed Principle**: Classes should be open for extension, but closed for modification.

## Core Concepts

### 1. The Problem
- Subclassing for every combination of features leads to **class explosion**
- Example: If you have 4 beverage types and 5 condiments, you'd need 4 × 2^5 = 128 classes!
- Maintenance nightmare when requirements change

### 2. The Solution
- Use **composition** instead of inheritance
- Wrap objects with decorator objects
- Decorators have the same supertype as the objects they decorate
- Can wrap a component with any number of decorators

### 3. Structure

```
Component (abstract)
├── ConcreteComponent (base object)
└── Decorator (abstract)
    ├── ConcreteDecoratorA
    └── ConcreteDecoratorB
```

## Implementation: Starbuzz Coffee

### Components

**Base Component**: `Beverage` (abstract class)
- `getDescription()`: String
- `cost()`: double (abstract)

**Concrete Components**: 
- `Espresso`
- `HouseBlend`
- `DarkRoast`
- `Decaf`

**Decorator**: `CondimentDecorator` (abstract)
- Extends `Beverage`
- Has a `Beverage` instance variable
- Must implement `getDescription()` as abstract

**Concrete Decorators**:
- `Mocha`
- `Whip`
- `Soy`
- `SteamMilk`

### Usage Example

```java
// Simple beverage
Beverage beverage = new Espresso();
System.out.println(beverage.getDescription() + " $" + beverage.cost());

// Decorated beverage
Beverage beverage2 = new HouseBlend();
beverage2 = new Mocha(beverage2);
beverage2 = new Mocha(beverage2);  // Double mocha!
beverage2 = new Whip(beverage2);
System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
```

## Real-World Example: Java I/O

### Java I/O Uses Decorator Pattern

```java
InputStream in = new LowerCaseInputStream(
    new BufferedInputStream(
        new FileInputStream("test.txt")));
```

**Component**: `InputStream`
**Concrete Components**: `FileInputStream`, `ByteArrayInputStream`, `StringBufferInputStream`
**Decorator**: `FilterInputStream`
**Concrete Decorators**: `BufferedInputStream`, `DataInputStream`, `LineNumberInputStream`

### Custom Decorator: LowerCaseInputStream

We created our own decorator to convert input to lowercase:

```java
public class LowerCaseInputStream extends FilterInputStream {
    public LowerCaseInputStream(InputStream in) {
        super(in);
    }
    
    @Override
    public int read() throws IOException {
        int c = in.read();
        return (c == -1 ? c : Character.toLowerCase((char)c));
    }
    
    @Override
    public int read(byte[] b, int offset, int len) throws IOException {
        int result = in.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte)Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}
```

## Enhancements: Factory + Builder

### Factory Pattern Integration
Created `BeverageFactory` to centralize beverage creation:
```java
public class BeverageFactory {
    public static Beverage createBeverage(BeverageType type) {
        return switch (type) {
            case ESPRESSO -> new Espresso();
            case HOUSE_BLEND -> new HouseBlend();
            // ...
        };
    }
}
```

### Builder Pattern Integration
Created `BeverageBuilder` for fluent decorator composition:
```java
Beverage beverage = new BeverageBuilder(new HouseBlend())
    .addMocha()
    .addMocha()
    .addWhip()
    .build();
```

**Benefits**:
- More readable than nested constructors
- Easy to add/remove decorators
- Fluent API

## Key Insights

### 1. Decorator vs. Inheritance
| Aspect | Inheritance | Decorator |
|--------|-------------|-----------|
| Flexibility | Static (compile-time) | Dynamic (runtime) |
| Combinations | Class explosion | Unlimited combinations |
| Modification | Requires changing class | Wrap with new decorator |
| Open-Closed | Violates principle | Follows principle |

### 2. When to Use Decorator
✅ **Use when**:
- Need to add responsibilities to individual objects dynamically
- Want to avoid class explosion from subclassing
- Need to combine behaviors in various ways
- Extension by subclassing is impractical

❌ **Don't use when**:
- Simple inheritance is sufficient
- Order of decoration doesn't matter (consider other patterns)
- Need to remove decorators frequently (can get complex)

### 3. Decorator Disadvantages
- Can result in many small objects (complexity)
- Code that relies on specific types can break
- Decorators can be hard to remove once added
- Order of decoration matters

## Design Patterns Comparison

### Decorator vs. Builder
- **Decorator**: Runtime behavior composition
- **Builder**: Complex object construction
- **Can combine**: Use Builder to simplify Decorator composition (as we did!)

### Decorator vs. Strategy
- **Decorator**: Adds responsibilities, wraps objects
- **Strategy**: Encapsulates algorithms, delegates behavior
- **Both**: Use composition over inheritance

## Java-Specific Learnings

### 1. Why No `@Override` in `FilterInputStream`?
- `FilterInputStream` created in Java 1.0 (1996)
- `@Override` introduced in Java 5 (2004)
- Backward compatibility concerns
- **Lesson**: Always use `@Override` in YOUR code!

### 2. Why Decorator Instead of Builder for I/O?
- Decorator allows dynamic, runtime composition
- Order of wrapping is explicit and important
- Anyone can create new decorators (extensibility)
- Builder would be less flexible for this use case
- **Lesson**: Choose pattern based on problem, not "enterprise trends"

### 3. Modern Java Features
- Used `var` for type inference
- Used switch expressions in Factory
- Removed redundant modifiers
- **Lesson**: Apply modern Java features where appropriate

## Testing

### StarbuzzCoffee Output
```
Espresso $1.99
House Blend Coffee, Mocha, Mocha, Whip $1.49
```

### InputTest Output
```
Original: I know the Decorator Pattern therefore I RULE!
Output:   i know the decorator pattern therefore i rule!
```

## Summary

The Decorator Pattern is a powerful tool for:
1. **Extending functionality** without modifying existing code
2. **Combining behaviors** dynamically at runtime
3. **Following Open-Closed Principle**
4. **Avoiding class explosion** from inheritance

**Key Takeaway**: Favor composition over inheritance, and use decorators to add responsibilities dynamically while keeping your code flexible and maintainable.

## Files Created

### Starbuzz Coffee
- `Beverage.java` - Abstract component
- `Espresso.java`, `HouseBlend.java` - Concrete components
- `CondimentDecorator.java` - Abstract decorator
- `Mocha.java`, `Whip.java` - Concrete decorators
- `BeverageFactory.java` - Factory for creating beverages
- `BeverageBuilder.java` - Builder for fluent decoration
- `BeverageType.java` - Enum for beverage types
- `StarbuzzCoffee.java` - Main test class

### Java I/O
- `LowerCaseInputStream.java` - Custom decorator
- `InputTest.java` - Test class
- `test.txt` - Test file

## Next Steps

Continue to Chapter 4: Factory Pattern (more depth on object creation patterns)
