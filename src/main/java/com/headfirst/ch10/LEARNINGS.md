# Chapter 10: State Pattern - Learning Notes

## 📚 Pattern Overview
**State Pattern**: Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

## 🎯 Key Concepts to Understand

### 1. The Problem
- **Before State Pattern**: Complex conditional logic (`if/else` or `switch`) scattered throughout code
- **Issue**: Hard to maintain, extend, and understand
- **Example**: Adding a new state requires modifying multiple methods

### 2. The Solution
- **Encapsulate states**: Each state becomes its own class
- **Delegate behavior**: Context delegates to current state object
- **State transitions**: States can trigger transitions to other states

### 3. Pattern Structure
```
Context (GumballMachine)
  └─ holds reference to → State (interface)
                            ├─ NoQuarterState
                            ├─ HasQuarterState
                            ├─ SoldState
                            └─ SoldOutState
```

## 🔑 Implementation Checklist

### State Interface
- [ ] Define all possible actions (insertQuarter, ejectQuarter, turnCrank, dispense)
- [ ] Each method represents an action that can be performed in any state

### Concrete State Classes
- [ ] NoQuarterState - waiting for quarter
- [ ] HasQuarterState - quarter inserted, ready for crank
- [ ] SoldState - dispensing gumball
- [ ] SoldOutState - no gumballs left

### Context (GumballMachine)
- [ ] Hold references to all state objects
- [ ] Maintain current state reference
- [ ] Delegate all actions to current state
- [ ] Provide state transition method
- [ ] Track gumball inventory

## 💡 Key Learning Points

### State vs Strategy Pattern
| Aspect | State Pattern | Strategy Pattern |
|--------|---------------|------------------|
| **Intent** | Alter behavior based on internal state | Choose algorithm at runtime |
| **Who decides** | States control transitions | Client chooses strategy |
| **Relationship** | States know about each other | Strategies are independent |

### Design Principles Applied
- **Encapsulate what varies**: State-specific behavior is encapsulated in state classes
- **Open/Closed Principle**: Can add new states without modifying existing code
- **Single Responsibility**: Each state class handles one state's behavior

## 🧪 Testing Scenarios

### Test Cases to Implement
1. **Happy Path**: Insert quarter → Turn crank → Get gumball
2. **Eject Quarter**: Insert quarter → Eject quarter
3. **Invalid Operations**:
   - Turn crank without quarter
   - Insert quarter twice
   - Eject when no quarter inserted
4. **Sold Out**: Use all gumballs → Try to buy more

## 🤔 Questions to Answer While Implementing

1. **Who controls state transitions?**
   - Answer: _______________

2. **Why does each state need a reference to GumballMachine?**
   - Answer: _______________

3. **What happens if we want to add a "Winner" state (10% chance of 2 gumballs)?**
   - Answer: _______________

4. **How does this pattern eliminate conditional logic?**
   - Answer: _______________

## 🎨 State Transition Diagram

TODO: Draw the state transition diagram as you implement:
```
[NoQuarter] --insertQuarter--> [HasQuarter]
[HasQuarter] --ejectQuarter--> [NoQuarter]
[HasQuarter] --turnCrank--> [Sold]
[Sold] --dispense--> [NoQuarter] (if gumballs remain)
[Sold] --dispense--> [SoldOut] (if no gumballs)
```

## 📝 Implementation Notes

### Challenges Faced
- 

### Insights Gained
- 

### Real-World Applications
- 

## 🚀 Extensions to Try

1. **Winner State**: Add a 10% chance to win 2 gumballs
2. **Refill Method**: Add ability to refill the machine
3. **Multiple Coins**: Support quarters, dimes, nickels
4. **State History**: Track state transitions for debugging

---

**Remember**: The State Pattern is about encapsulating state-based behavior into separate classes, making the code more maintainable and extensible!
