# 1.1 Cheatsheet

### LOGICAL OPERATORS

```java
int num1 = 4;
int num2 = 5;
int num3 = 5;


System.out.println(num1 > num2); //false
System.out.println(num2 == num3);//true
System.out.println(num1 > num2 || num2 == num3); //true
System.out.println(num1 > num2 && num2 == num3); //false
```

- Logical operators `&&` and `||` allow developers to create complex conditions.

### SWITCH

```java
int num = 4;
String operator = “+”;
switch (operator){
  case "-":
    System.out.println(num - num);
    break;
  case “+”:
    System.out.println(num + num);
    break;
  case “*”:
    System.out.println(num * num);
    break;
  case “/”:
    System.out.println(num / num);
    break;
  default: 
    System.out.println(“Invalid operator”);
}
```

- switch statements are an alternative syntax to `if` statements. While they are generally easier to read and more effiecient, there are only suited for simple conditions. 

### ARRAYS

```java
int[] arr1 = new int[4];
arr1[0] = 10;
arr1[1] = 20;
arr1[2] = 30;
arr1[3] = 40;

int[] arr2 = {10, 20, 30, 40};
```
- Arrays are lists of elements and can be declared in 2 different ways. 

### LOOPS

```java
for (int i = 0; i < 3; i++){
	System.out.println(i);
}

int j = 0; 
while(j < 1){
	System.out.println(j);
	j++;
}

int k = 1; 

do{
	System.out.println(k);
	k++;
}while(k < 1);
```

- There are 3 primary types of loops: while loops, do while loops, and for loops. Later we'll see enhanced for loops. 

