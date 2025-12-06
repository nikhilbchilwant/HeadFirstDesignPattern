# Chapter 9: Iterator and Composite Patterns

## Iterator Pattern

### Pattern Definition
**Provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.**

### The Problem
Different collections use different internal structures:
- `DinerMenu` uses **array**
- `PancakeHouseMenu` uses **ArrayList**
- Client code shouldn't know or care about these differences

### The Solution
Create an `Iterator` interface that provides uniform traversal:
```java
public interface Iterator {
    boolean hasNext();
    MenuItem next();
}
```

### Key Components
1. **Iterator Interface** - Defines traversal methods (`hasNext()`, `next()`)
2. **Concrete Iterators** - Implement iteration for specific collections
   - `DinerMenuIterator` - Iterates over array
   - `PancakeHouseMenuIterator` - Iterates over ArrayList
3. **Aggregate** - Provides `createIterator()` method
   - `DinerMenu`, `PancakeHouseMenu`
4. **Client** - Uses iterators without knowing collection type
   - `Waitress` - Prints menus using iterators

### Implementation Details

#### Array Iterator (DinerMenuIterator)
```java
public class DinerMenuIterator implements Iterator {
    MenuItem[] items;
    int position = 0;
    
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }
    
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }
}
```

#### ArrayList Iterator (PancakeHouseMenuIterator)
```java
public class PancakeHouseMenuIterator implements Iterator {
    ArrayList<MenuItem> items;
    int position = 0;
    
    public boolean hasNext() {
        return position < items.size();
    }
    
    public MenuItem next() {
        MenuItem menuItem = items.get(position);
        position++;
        return menuItem;
    }
}
```

### Benefits
✓ **Encapsulation** - Internal structure hidden from client
✓ **Single Responsibility** - Collection manages storage, Iterator manages traversal
✓ **Uniform Interface** - Same code works with different collections
✓ **Flexibility** - Easy to add new collection types

---

## Composite Pattern

### Pattern Definition
**Allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.**

### The Problem
Menus can contain:
- Individual menu items (leaves)
- Submenus (composites) which can contain more items or submenus

We need to treat both uniformly without complex conditional logic.

### The Solution
Create a component interface that both leaves and composites implement.

### Key Components

1. **Component (MenuComponent)** - Abstract base class
   - Defines interface for both leaf and composite
   - Provides default implementations (throw `UnsupportedOperationException`)

2. **Leaf (MenuItem)** - Individual objects
   - Overrides operations that make sense for leaves
   - Cannot have children

3. **Composite (Menu)** - Container objects
   - Can contain MenuComponents (leaves or other composites)
   - Implements `add()`, `remove()`, `getChild()`
   - Delegates operations to children

4. **Client (Waitress)** - Works with Component interface
   - Treats leaves and composites uniformly

### Tree Structure
```
ALL MENUS (Menu)
├── PANCAKE HOUSE MENU (Menu)
│   ├── K&B's Pancake Breakfast (MenuItem)
│   └── Regular Pancake Breakfast (MenuItem)
├── DINER MENU (Menu)
│   ├── Vegetarian BLT (MenuItem)
│   ├── BLT (MenuItem)
│   └── DESSERT MENU (Menu)
│       ├── Apple Pie (MenuItem)
│       └── Cheesecake (MenuItem)
└── CAFE MENU (Menu)
    └── Veggie Burger (MenuItem)
```

### Implementation Highlights

#### Component (MenuComponent)
```java
public abstract class MenuComponent {
    // Operations for leaves
    public String getName() { throw new UnsupportedOperationException(); }
    public double getPrice() { throw new UnsupportedOperationException(); }
    
    // Operations for composites
    public void add(MenuComponent c) { throw new UnsupportedOperationException(); }
    public void remove(MenuComponent c) { throw new UnsupportedOperationException(); }
    
    // Operation for both
    public void print() { throw new UnsupportedOperationException(); }
}
```

#### Leaf (MenuItem)
```java
public class MenuItem extends MenuComponent {
    String name, description;
    boolean vegetarian;
    double price;
    
    // Override only operations that make sense for a leaf
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void print() { 
        System.out.println("  " + name + ", " + price); 
    }
}
```

#### Composite (Menu)
```java
public class Menu extends MenuComponent {
    ArrayList<MenuComponent> menuComponents = new ArrayList<>();
    String name, description;
    
    public void add(MenuComponent c) { menuComponents.add(c); }
    public void remove(MenuComponent c) { menuComponents.remove(c); }
    
    // Recursive print!
    public void print() {
        System.out.println(name + ", " + description);
        for (MenuComponent component : menuComponents) {
            component.print();  // Polymorphic call
        }
    }
}
```

### Benefits
✓ **Uniform Treatment** - Client code same for leaf and composite
✓ **Tree Structures** - Natural representation of hierarchies
✓ **Recursive Operations** - Operations propagate through tree
✓ **Flexibility** - Easy to add new component types
✓ **Simplicity** - Client doesn't need conditional logic

### Design Trade-offs
- **Single Responsibility vs. Transparency**: MenuComponent violates Single Responsibility (has both leaf and composite operations) but gains transparency (uniform interface)
- **Type Safety**: Clients can call operations that don't make sense (e.g., `add()` on MenuItem), but we handle with exceptions

---

## Pattern Comparison

| Aspect | Iterator | Composite |
|--------|----------|-----------|
| **Purpose** | Traverse collections | Represent hierarchies |
| **Structure** | Linear | Tree |
| **Key Benefit** | Hide collection details | Treat parts and wholes uniformly |
| **When to Use** | Multiple collection types | Part-whole relationships |

## Design Principles Applied

### Iterator Pattern
- **Single Responsibility Principle** - Separate collection from iteration
- **Encapsulation** - Hide internal structure
- **Program to Interface** - Iterator interface, not implementation

### Composite Pattern
- **Open/Closed Principle** - Add new components without changing client
- **Liskov Substitution** - Leaf and Composite interchangeable
- **Composite Reuse** - Build complex structures from simple parts

---

## Real-World Usage in Java

### Iterator Pattern
- **Java Collections Framework**: `java.util.Iterator`
  ```java
  List<String> list = new ArrayList<>();
  Iterator<String> iterator = list.iterator();
  while (iterator.hasNext()) {
      System.out.println(iterator.next());
  }
  ```
- Enhanced for-loop uses Iterator internally

### Composite Pattern
- **Java AWT/Swing**: `Component` → `Container` (composite), `Button` (leaf)
- **Java NIO**: `Path` for files and directories
- **XML DOM**: `Node` → `Element` (composite), `Text` (leaf)

---

## Key Takeaways

### Iterator
1. Encapsulate iteration logic
2. Support multiple traversal algorithms
3. Simplify collection interface
4. Enable uniform access to different collections

### Composite
1. Build tree structures naturally
2. Treat individual and composite objects uniformly
3. Use recursion for operations on tree
4. Trade type safety for transparency

### When to Use Together
Iterator and Composite work well together:
- Use **Composite** to build tree structure (menus with submenus)
- Use **Iterator** to traverse the tree (print all items)
- Example: `Menu.print()` uses iterator to traverse children
