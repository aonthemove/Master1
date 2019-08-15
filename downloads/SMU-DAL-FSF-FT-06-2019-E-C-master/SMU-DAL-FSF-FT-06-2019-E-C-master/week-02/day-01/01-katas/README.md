# Katas

## Structure

- Add the code necessary to the `starter-code` project `U1M2L1Katas`.
- All classes should part of the `com.company` package.
- Tests can be found in the `test/java` directory. Once you have written each class, uncomment the code in the associated test and run it.
- Once all classes have been written, you can test them at once by uncommenting the code in `AllKatasTest` and running it.

## UML Diagrams

UML Diagrams are a commonly used tool for communicating the structure and functionality of an object-oriented program. Class diagrams are used to represent the classes to be programmed.

Read more about UML Diagrams before continuing on with the katas.
`https://www.lucidchart.com/pages/uml-class-diagram#discovery__top`

## Building Classes

Working off of the UML diagrams found in `starter-code`, create a class for each of the objects that have been previously modeled. Do not worry about using these classes in any way — just build the class to the specifications in the UML diagrams.

The constructor for each class should initialize every property of the object.

_**Example**_
```java
public Lion(String nameIn, int ageIn, int weightIn) {
    this.name = nameIn;
    this.age = ageIn;
    this.weight = weightIn;
}
```

The properties of every class should only be accessible via getters and setters.

---
© 2019 Trilogy Education Services
