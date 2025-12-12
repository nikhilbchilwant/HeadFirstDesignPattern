# Chapter 12: Compound Patterns (Duck Simulator) - Learning Notes

## 📚 Overview
We are building a Duck Simulator to see how patterns can work together.

## 🏗️ Patterns Used

### 1. Adapter Pattern
- **Purpose**: To interact with a `Goose` as if it were a `Quackable`.
- **Implementation**: `GooseAdapter` wraps `Goose` and implements `Quackable`.

### 2. Decorator Pattern
- **Purpose**: To add behavior (counting quacks) without modifying existing classes.
- **Implementation**: `QuackCounter` wraps any `Quackable`.

### 3. Abstract Factory Pattern
- **Purpose**: To control the creation of families of objects (e.g., ensuring all ducks are counted).
- **Implementation**: `AbstractDuckFactory`, `CountingDuckFactory`.

### 4. Composite Pattern
- **Purpose**: To treat a collection of objects (`Flock`) safely as a single object.
- **Implementation**: `Flock` implements `Quackable` and holds a list of `Quackable`s.

### 5. Observer Pattern
- **Purpose**: To be notified when interesting things happen (a quack).
- **Implementation**: `QuackObservable`, `Observer`, `Quackologist`.

## 🧪 Testing Checklist
- [ ] Run `DuckSimulator` and verify basic quacking.
- [ ] Verify `GooseAdapter` prints "Honk".
- [ ] Verify `QuackCounter` correctly tracks the number of quacks.
- [ ] Verify `CountingDuckFactory` creates decorated ducks automatically.
- [ ] Verify `Flock` iterates through all ducks.
- [ ] Verify `Quackologist` receives notifications.

## 📝 Notes
- Notice how the `Flock` (Composite) also acts as an Observable's subject, but delegates registration to its children? (Or does it? Check the book implementation!)
- The `Observable` helper class prevents code duplication in every Duck class.
