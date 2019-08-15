# 1.1 Cheatsheet

### PRINT TO THE CONSOLE 
`System.out.println("Hello World");` 
- In real application, this is often used for finding bugs and tracking issues. 

<br />

### GET USER INPUT AND PRINT

```java
Scanner scanner = new Scanner(System.in);
String input = scanner.nextLine();
System.out.println(“You wrote “ + input);
```

- Used for building CLI tools (programs that run in the terminal), but nnot in building web servers. 
<br />

### VARIABLES

```java
String name = “Christopher Robin”;

int age = 5;

double favNumber = 7.2456;

Boolean isWeird = true;
```
- used to store values for later use


### COMPARATORS

```java
int num1 = 1; 
int num2  = 2;
Boolean isEqual = num1 == num2; //single equals is the assignment operator. Double equals is the comparator operator
Boolean isLarger = num1 > num2; // greater than
Boolean isSmaller = num1 < num2; //less than
```
- comparators compare 2 values and generate a boolean value.

### CONDITIONALS

```java
int num1 = 4;
int num2 = 5;

if(num1 == num2){
	System.out.println(“These numbers are equal”);
}else {
	System.out.println(“These numbers are not equal”);
}
```

- Conditionals run certain blocks of code only if a given condition is met. 