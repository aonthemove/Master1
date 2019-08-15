# 2.2 Cheatsheet

### INHERITANCE

Classes can inherit properties and methods from another class. This represents an **is-a** relationship.

We signify that a class is inheriting from another using the `extends` keyword.

```java
public class Mammal {
  private boolean isWarmBlooded = true; 
  private String name;
  private String sound;  
  
  public void speak(){
    System.out.println(this.sound + " " + this.sound);
  }
}
```
```java
public class Dog extends Mammal {
  public Dog(String name){
    this.name = name;
  }

  public void pant(){
    System.out.println("Hu hu hu hu hu");
  }
}
```

Objects can be declared as either the child or parent type, but this limits the methods and properties the object has access to.

```java
public static void main (String[] args){

  Dog rover = new Dog("Rover");
  rover.speak();
  rover.pant();

  Mammal betti = new Dog("Betti");
  betti.speak();
  betti.pant(); // betti can't pant because Mammals don't have a pant method defined
} 
```

When one class inherits from another, we can use the `super` keyword to access methods and properties found in the parent class.

We can also use it invoke the parent constructor when needed.

```java
public class Mammal {
  private String name;
  private String sound;
  
  public Mammal(String sound){
    this.sound = sound;
  }

}
```
```java
public class Dog extends Mammal {
  public Dog(String name){
    super("Ruff");
    this.name = name;
  }

}
```

### METHOD OVERRIDING

A sub-class can override the methods defined on the superclass. To do so, the method must have the exact same access modifier, return type, name, and parameters. This is distinct from overloading where only the name is necessarily the same.

```java
public class Building {

    private double length;
    private double width;
    private double height;
    private int roomCount;

    public Building(double length, double width, double height, int roomCount) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.roomCount = roomCount;
    }

    public void addRooms() {
        this.roomCount++;
    }

    public double averageRoomVolume() {
      return (length * width * height) / roomCount;
    }

    // getters and setters excluded for brevity
}
```
```java
public class Home extends Building {

    private int bedroomCount;
    private String paintColor;

    public Home(double length, double width, double height, int roomCount, int bedroomCount, String paintColor) {
        super(length, width, height, roomCount);
        this.bedroomCount = bedroomCount;
        this.paintColor = paintColor;
    }

    // paint is overloaded
    public void paint() {
        System.out.println("ah fresh paint");
    }

    public void paint(String color) {
        System.out.println("ah fresh " + color + " paint");
    }

    // addRooms is overriding addRooms from the superclass
    public void addRooms() {
        this.bedroomCount++;
    }

    //overriding averageRoomVolume from the superclass
    public double averageRoomVolume() {
      return (length * width * height) / bedroomCount;
    }


    // getters and setters excluded for brevity
}
```

### ABSTRACT CLASSES

Abstract classes are a special type of class that cannot be instantiated. Methods on an abstract class can also be declared as `abstract`. When they are, no implementation is required in the abstract class, but the method must be implemented in any subclass of the abstract class.

```java
public abstract class Animal {
  private String name; 
  private int numOfLegs;

  public void sleep(){
    System.out.println("zzzzzzz");
  }

  public abstract void eat();
}
```

```java
public class Dog extends Animal{
  public void eat(){
    System.out.println("mmmmm kibble");
  }
}
```
```java
public class PolarBear extends Animal{
  public void eat(){
    System.out.println("mmmm seal!");
  }
}
```
