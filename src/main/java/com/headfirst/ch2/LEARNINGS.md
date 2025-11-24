# Chapter 2: Observer Pattern - Key Learnings

## Pattern Definition

**Observer Pattern**: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

## Design Principle

**Loose Coupling**: Strive for loosely coupled designs between objects that interact.

## Core Concepts

### 1. The Problem
- Need to notify multiple objects when state changes
- Don't want tight coupling between the subject and observers
- Want to add/remove observers dynamically at runtime

### 2. The Solution
- Subject maintains a list of observers
- Observers register/unregister with the subject
- When subject's state changes, it notifies all observers
- Observers pull or receive the data they need

### 3. Structure

```
Subject (interface)
├── ConcreteSubject
    └── maintains state
    └── notifies observers

Observer (interface)
└── ConcreteObserver
    └── implements update()
```

## Implementation: Weather Station

### Components

**Subject Interface**: `Subject`
- `registerObserver(Observer o)`
- `removeObserver(Observer o)`
- `notifyObservers()`

**Observer Interface**: `Observer`
- `update()` - Called when subject's state changes

**Concrete Subject**: `WeatherService`
- Implements `Subject`
- Maintains list of observers
- Holds `WeatherData` state
- Notifies observers when weather changes

**Concrete Observer**: `WeatherSubscriber`
- Implements `Observer`
- Holds reference to `WeatherService` (to pull data)
- Updates display when notified

**Data Class**: `WeatherData`
- Simple POJO holding temperature, humidity, pressure
- Getters and setters for each field

### Usage Example

```java
WeatherService weatherService = new WeatherService();
WeatherSubscriber subscriber1 = new WeatherSubscriber("Subscriber1", weatherService);
WeatherSubscriber subscriber2 = new WeatherSubscriber("Subscriber2", weatherService);

weatherService.registerObserver(subscriber1);
weatherService.registerObserver(subscriber2);

// Update weather - all subscribers get notified
weatherService.updateWeather();

// Remove one observer
weatherService.removeObserver(subscriber1);
weatherService.updateWeather(); // Only subscriber2 gets notified
```

## Java 17 Features Applied

### 1. Diamond Operator (Java 7+)
**Current Code**:
```java
observers = new ArrayList<Observer>();
```

**Could be simplified to**:
```java
observers = new ArrayList<>();
```

### 2. Var Keyword (Java 10+)
**Current Code**:
```java
WeatherService weatherService = new WeatherService();
WeatherSubscriber weatherSubscriber = new WeatherSubscriber("Name", weatherService);
```

**Could use var**:
```java
var weatherService = new WeatherService();
var weatherSubscriber = new WeatherSubscriber("Name", weatherService);
```

### 3. Records for Data Class (Java 14+)
**Current Code** (`WeatherData.java`):
```java
public class WeatherData {
    int temperature = 0;
    int humidity = 0;
    int pressure = 0;
    
    // 20+ lines of getters/setters
}
```

**Could be a Record**:
```java
public record WeatherData(int temperature, int humidity, int pressure) {}
```

**Benefits**:
- Immutable by default
- Auto-generated constructor, getters, equals(), hashCode(), toString()
- Much more concise (1 line vs 30+ lines)

### 4. Enhanced For-Each (Already Used)
```java
for (Observer observer : observers) {
    observer.update();
}
```
✅ Already using this modern feature!

### 5. Text Blocks for Multi-line Output (Java 15+)
**Current Code**:
```java
System.out.println(subsciberName + " Temperature: " + weatherData.getTemperature());
System.out.println(subsciberName + " Humidity: " + weatherData.getHumidity());
System.out.println(subsciberName + " Pressure: " + weatherData.getPressure());
```

**Could use Text Block**:
```java
System.out.printf("""
    %s Weather Update:
    Temperature: %d
    Humidity: %d
    Pressure: %d
    """, subscriberName, 
    weatherData.getTemperature(),
    weatherData.getHumidity(), 
    weatherData.getPressure());
```

### 6. Sealed Interfaces (Java 17)
**Not Recommended Here** - Observer pattern should be open for extension!

## Push vs Pull Model

### Current Implementation: Pull Model
Observers pull data from the subject:
```java
@Override
public void update() {
    WeatherData weatherData = weatherService.getWeatherData(); // Pull
    // Use the data
}
```

**Pros**:
- Observers get only what they need
- More flexible

**Cons**:
- Observers need reference to subject
- More coupling

### Alternative: Push Model
Subject pushes data to observers:
```java
public interface Observer {
    void update(int temperature, int humidity, int pressure); // Push
}

@Override
public void notifyObservers() {
    for (Observer observer : observers) {
        observer.update(
            weatherData.getTemperature(),
            weatherData.getHumidity(),
            weatherData.getPressure()
        );
    }
}
```

**Pros**:
- Less coupling (observers don't need subject reference)
- Simpler observer implementation

**Cons**:
- All observers get all data (even if they don't need it)
- Less flexible

## Real-World Examples

### Java Built-in Observer Pattern
Java used to have `java.util.Observer` and `java.util.Observable` (deprecated in Java 9):
```java
// Old way (deprecated)
class MyObservable extends Observable {
    public void changeState() {
        setChanged();
        notifyObservers();
    }
}
```

**Why deprecated?**
- Not serializable
- Forces inheritance (can't extend another class)
- Thread-safety issues

**Modern alternatives**:
- `PropertyChangeListener` (JavaBeans)
- `Flow` API (Java 9+) for reactive streams
- Third-party libraries: RxJava, Project Reactor

### Modern Reactive Approach (Java 9+)
```java
// Using Flow API
SubmissionPublisher<WeatherData> publisher = new SubmissionPublisher<>();

Flow.Subscriber<WeatherData> subscriber = new Flow.Subscriber<>() {
    @Override
    public void onNext(WeatherData data) {
        System.out.println("Weather: " + data);
    }
    // ... other methods
};

publisher.subscribe(subscriber);
publisher.submit(new WeatherData(72, 65, 30));
```

## Design Considerations

### When to Use Observer Pattern
✅ **Use when**:
- One object's state change should notify multiple objects
- Objects should be loosely coupled
- Number of observers can change at runtime
- Need broadcast communication

❌ **Don't use when**:
- Only one observer (use direct method call)
- Observers need to be notified in specific order (use Chain of Responsibility)
- Need request-response pattern (use Command or Mediator)

### Observer Pattern Disadvantages
1. **Memory leaks**: Forgetting to unregister observers
2. **Update order**: No guarantee on notification order
3. **Cascading updates**: Observer updates can trigger more updates
4. **Debugging**: Hard to trace the flow of notifications

## Code Quality Issues Found

### 1. Typo in Variable Name
```java
private String subsciberName; // Should be "subscriberName"
```

### 2. Missing Access Modifiers
```java
int temperature = 0; // Should be private
```

### 3. Could Use Final
```java
private final List<Observer> observers; // Make it final
private final WeatherData weatherData;  // Make it final
```

### 4. Initialization in Constructor
```java
public WeatherService() {
    observers = new ArrayList<>(); // Use diamond operator
    weatherData = new WeatherData();
    random = new Random();
}
```

## Improved Version with Java 17 Features

### WeatherData as Record
```java
public record WeatherData(int temperature, int humidity, int pressure) {
    // Compact constructor for validation
    public WeatherData {
        if (temperature < -100 || temperature > 150) {
            throw new IllegalArgumentException("Invalid temperature");
        }
    }
}
```

### WeatherService with Modern Java
```java
public class WeatherService implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private WeatherData weatherData = new WeatherData(0, 0, 0);
    private final Random random = new Random();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update); // Method reference
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void updateWeather() {
        weatherData = new WeatherData(
            random.nextInt(100),
            random.nextInt(100),
            random.nextInt(100)
        );
        notifyObservers();
    }
}
```

## Summary

The Observer Pattern is essential for:
1. **Decoupling** objects that need to communicate
2. **Dynamic** subscription/unsubscription
3. **Broadcasting** state changes to multiple listeners

**Key Takeaway**: Use Observer when you need one-to-many communication with loose coupling. Modern Java provides better alternatives (Flow API, reactive streams) for complex scenarios, but the classic Observer pattern is still valuable for simple use cases.

## Files in Chapter 2

- `Observer.java` - Observer interface
- `Subject.java` - Subject interface
- `WeatherData.java` - Data class (could be a record)
- `WeatherService.java` - Concrete subject
- `WeatherSubscriber.java` - Concrete observer
- `Main.java` - Demo application

## Next Steps

Consider refactoring to use:
1. Records for `WeatherData`
2. Diamond operator in `ArrayList` initialization
3. Method references in `notifyObservers()`
4. Text blocks for formatted output
5. Fix typo: `subsciberName` → `subscriberName`
