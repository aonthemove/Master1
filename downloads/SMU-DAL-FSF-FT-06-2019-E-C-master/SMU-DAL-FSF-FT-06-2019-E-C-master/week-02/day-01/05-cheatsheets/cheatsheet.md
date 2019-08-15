# 2.1 Cheatsheet

### CLASSES

Classes are blueprints for creating objects. By convention, we capitalize the first letter in a Class name.

```java
public class Student{
  private String name; 
  private int id; 
  private double gpa;

  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getGpa() {
    return this.gpa;
  }

  public void setGpa(double gpa) {
    if (gpa > 4.0) {
      this.gpa = 4.0;
    } else {
      this.gpa = gpa;
    }
  }
}
```

Classes can have properties and methods. Both are camel-cased by convention. Properties are set to private, so that we can control how they are accessed or set, and by whom. For access and modifications, we use getters and setters.

We can create new instances of a class, called instantiation, using the `new` keyword.

```java
public static void main(String[] args){
  Student student1 = new Student();
}
```

We can access properties and methods (if we have permission to do so, i.e. they are not set to `private`) using **dot notation**.

```java
public static void main(String[] args){
  Student student1 = new Student();
  student1.setName("Sheryl");
  System.out.println(student1.getName());
}
```

### CONSTRUCTORS

Constructors are a special kind of method that have the same name as the class and no return type. They are invoked when a new instance is created.

```java
public class Student{
  private String name; 
  private int id; 
  private double gpa;

  public Student(String name, int id, double gpa){
    this.name = name;
    this.id = id;
    this.gpa = gpa;
  }

  // getters and setters excluded for brevity
}
```

The `this` keyword is used to refer to object in question -- the specific instance that is being created.

Constructors can also be overloaded -- an object can have multiple constructors.

```java
public class Student{
  private String name; 
  private int id; 
  private double gpa;

  public Student(String name, int id, double gpa){
    this.name = name;
    this.id = id;
    this.gpa = gpa;
  }

  public Student(String name){
    this.name = name;
  }

  // getters and setters excluded for brevity
}
```

If no constructor is provided, the compiler provides the empty, default constructor.

```java
// default constructor
public Student() {

}
```
