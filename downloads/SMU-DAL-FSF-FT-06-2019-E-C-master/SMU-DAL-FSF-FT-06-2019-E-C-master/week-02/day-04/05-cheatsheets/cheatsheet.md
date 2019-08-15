# 2.4 Cheatsheet

### LISTS

Many classes implement the `List` interface. Most often, the `List` we wish to use is the `ArrayList`.

An `ArrayList` is similar to, and ultimately backed by, an `Array`, but differs in a couple of key ways.

The first is that an `ArrayList` has a dynamic size -- we can add as many elements as we wish, and do not have to declare a size upon instantiation.

The second is that an `ArrayList` can only contain Objects. If we wish to store primitives -- ints, chars, booleans, etc -- we have to use a **Wrapper Class**.

```java
List<Integer> numList = new ArrayList<>();
numList.add(3);
numList.add(4);
```

We declare any `List` to be of type `List<E>` where `E` is the object type that can be stored in the `List`. This way, when we program to the interface, our specific implementation (ArrayList, LinkedList, Vector, etc) does not matter. Our methods of operation are all from the `List` interface.

```java
List<String> stuList = new ArrayList<>();
stuList.add("Jessi");
stuList.add("Jimmy");
stuList.add("Ming");
```

### MAPS

Maps store key-value pairs. Keys must be unique, but values do not have to. Again, we program to the interface and declare the Map to be of type `Map<K, V>` where `K` is the data type of the **key** and `V` is the data type of the **value**.

```java
Map<String, Integer> heights = new HashMap<>();

heights.put("Joe", 72);
heights.put("Jane", 63);
heights.put("Sally", 65);

int joesHeight = heights.get("Joe");
```

We can add elements to our `Map` with the `put` method and retrieve them with the `get` method.


### OTHER DATA STRUCTURES

**Stacks** are **L**ast **I**n, **F**irst **O**ut, or **LIFO**, data structures. An easy way to remember this is to think of a stack of pancakes. In order to get to the bottom of the stack, you must first eat each of the pancakes on top. A common usage is to store the **call stack**.

**Queues** are **F**irst **I**n, **F**irst **O**ut, or **FIFO**, data structures. Think of this like a queue at the bank -- the first person to arrive is the first one served. A common usage is to queure process for the CPU.

**LinkedLists** are another type of `List`, similar to arrays, but with a different implementation. This gives them access to the same methods of manipulation as all other lists, but affects performance. They are less efficient for value lookups, but more efficient for inserting and deleting new elements.
