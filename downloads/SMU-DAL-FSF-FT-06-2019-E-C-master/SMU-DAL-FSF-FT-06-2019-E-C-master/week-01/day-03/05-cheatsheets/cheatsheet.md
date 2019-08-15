# 1.3 Cheatsheet

### METHODS

```java
public static int subtract(int num1, int num2){
	return num1 - num2;
}
```
- method signatures have the following layout: 

`<accesss modifier> <optional static keyword> <return type> <method name>(<paramters>)`

### OVERLOADING

```java
public static int subtract(int num1, int num2){
	return num1 - num2;
}

public static int subtract(int num1, int num2, int num3){
	return num1 - num2 - num3;
}

public static double subtract(double num1, double num2){
	return num1 - num2;
}
```

- methods can be overloading by providing multiple methods with the same name but different parameter count or types. 