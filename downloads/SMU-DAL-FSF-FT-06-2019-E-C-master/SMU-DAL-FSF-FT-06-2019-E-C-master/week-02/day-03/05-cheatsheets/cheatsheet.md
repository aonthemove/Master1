# 2.3 Cheatsheet

### INTERFACES

Interfaces are like a contract that guarantees to a user that certain methods exist on any class that implements the interface. The specific implementation may change from class to class, but the basic abilities stay the same.

Interfaces define only methods -- they cannot have properties.

```java
public interface Storable {
    public void storeData();
    public void retrieveData();
}
```

We can implement interfaces in a class with the `implements` keyword.

```java
public class SchoolRecord implements Storable {
      // Properties here
  // Additional methods here
    public void storeData() {
    // method body implementation here
  }
    public void retrieveData() {
    // method body implementation here
  }
}
```

We can also implement multiple interfaces. When we do, we have to implement all methods defined on all interfaces.

```java
public interface Auditable {
    public void runAudit();
    public void sendAuditToState();
}
```

```java
public class SchoolRecord implements Storable, Auditable {
    // Properties here
    // Additional methods here

    // Storable methods here
    public void storeData() {
        System.out.print("storing data");
    }

    public void retrieveData() {
        System.out.print("getting data");
    }

    // Auditable methods here
    public void runAudit() {
        System.out.print("auditing");
    }

    public void sendAuditToState() {
        System.out.print("audit sent");
    }
}
```

### STATIC KEYWORD

Static members exist once per class. Each object instantiated from a class does **not** get its own copy of static members, but instead gets a reference to public or protected static members.

A common use case is in utility classes that need not be instantiated, such as a simple calculator.

```java
public class Math {
  public static int add(int a, int b) {
    return a + b;
  }

  public static int subtract(int a, int b) {
    return a - b;
  }

  public static int divide(int a, int b) {
    return a / b;
  }

  public static int multiply(int a, int b) {
    return a * b;
  }
}
```

### COMPOSITION

A common tactic to make applications less redundant and more maintainable is **composition**. Composition means that objects can be composed of other objects.

Rather than defining common properties and methods multiple times, we can define them once and instantiate as many times as needed.

```java
public class Door {
  private boolean isOpen = false;

  public void open(){
    this.isOpen = true;
  }

  public void close(){
    this.isOpen = false;
  }
}
```
```java
public class Car{
  private Door fpDoor = new Door();
  private Door fdDoor = new Door();
  private Door rpDoor = new Door();
  private Door rdDoor = new Door();
}
```
