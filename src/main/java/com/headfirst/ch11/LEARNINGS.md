# Chapter 11: The Proxy Pattern

**Definition**: The Proxy Pattern provides a surrogate or placeholder for another object to control access to it.

## Implemented Proxies

### 1. Remote Proxy (Gumball Machine)
- **Use Case**: Interaction with objects on a remote machine (different JVM/Heap).
- **Technique**: Used Java RMI (Remote Method Invocation).
- **Components**: `GumballMachineRemote` (Remote Interface), `GumballMachine` (Server), `GumballMonitor` (Client).

### 2. Virtual Proxy (Image Viewer)
- **Use Case**: Deferring the creation/loading of expensive objects until they are needed.
- **Technique**: Used a proxy implementing `Icon` that spawns a background thread to load the real `ImageIcon`.
- **Components**: `ImageProxy` (Proxy), `ImageIcon` (Real Subject).

### 3. Dynamic Proxy (Matchmaking Service / Protection Proxy)
- **Use Case**: Controlling access to methods on an object based on caller permissions.
- **Technique**: Used `java.lang.reflect.Proxy` to create proxy instances at runtime.
- **Components**: `PersonBean`, `OwnerInvocationHandler`, `NonOwnerInvocationHandler`.

## The Proxy Zoo (Other Variants)

- **Firewall Proxy**: Controls access to a set of network resources protecting the subject from "bad" clients.
- **Smart Reference Proxy**: Provides additional actions when a subject is referenced (e.g., counting number of references).
- **Caching Proxy**: Provides temporary storage for results of expensive operations (e.g., web server proxy).
- **Synchronization Proxy**: Provides safe access to a subject from multiple threads.
- **Complexity Hiding Proxy (Facade Proxy)**: Hides the complexity of (and controls access to) a complex set of classes.
- **Copy-On-Write Proxy**: Controls the copying of an object by deferring the copy until it is required by a client (variation of Virtual Proxy).
