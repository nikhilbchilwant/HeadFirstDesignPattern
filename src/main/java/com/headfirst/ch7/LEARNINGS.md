## Chapter 7: Adapter & Facade Patterns

### Adapter Pattern
**Definition:** Converts the interface of a class into another interface clients expect, allowing incompatible classes to work together.

#### One‑Way Adapter (Duck/Turkey)
- **Target interface:** `Duck` (`quack()`, `fly()`)
- **Adaptee:** `Turkey` (`gobble()`, `fly()`)
- **Adapter:** `TurkeyAdapter` implements `Duck` and wraps a `Turkey`
- **Translation:** `quack()` → `gobble()`, `fly()` → `fly()` repeated 5 times

#### Two‑Way Adapter
- **Single class implements both interfaces** (`OldVendorInterface` & `NewVendorInterface`).
- Enables gradual migration: the same adapter works with legacy code expecting the old interface and new code expecting the new interface.
- Solves the mixed‑codebase problem without rewriting existing components.

### Facade Pattern
**Definition:** Provides a unified, higher‑level interface to a set of interfaces in a subsystem, simplifying client interaction.

#### Home Theater Example
- **Subsystem components (6):** `Amplifier`, `DvdPlayer`, `Projector`, `TheaterLights`, `Screen`, `PopcornPopper`.
- **Without Facade:** Client must invoke many methods in the correct order to watch a movie.
- **With Facade:** `HomeTheaterFacade.watchMovie(String movie)` handles all setup; `endMovie()` handles cleanup.

### Adapter vs Facade
| Aspect            | Adapter                              | Facade                               |
|-------------------|--------------------------------------|--------------------------------------|
| **Intent**        | Convert an incompatible interface    | Simplify a complex subsystem         |
| **Classes**       | One (adaptee)                        | Many (subsystem)                     |
| **Why**           | Incompatibility between APIs         | Reducing complexity for the client   |
| **Result**        | New interface matches expected usage  | Simple, high‑level interface to use   |

### Key Learnings
- **Adapter:** Object composition, runtime flexibility, interface translation, two‑way adapters for migration.
- **Facade:** Simplification, principle of least knowledge, decoupling, still allows direct subsystem access when needed.
- **Design Principles Applied:** Program to interface, favor composition, least knowledge, open/closed.

### When to Use
- **Adapter:** Legacy integration, third‑party libraries with mismatched APIs, gradual system migration.
- **Facade:** Complex subsystems where a simple client API is desirable, layered architecture.

---
