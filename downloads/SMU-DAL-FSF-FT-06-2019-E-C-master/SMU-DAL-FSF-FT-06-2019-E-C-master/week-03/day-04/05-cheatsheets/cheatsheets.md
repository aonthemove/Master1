# 3.4 Cheatsheet

### EXCEPTION HANDLING

An exception happens when a problem arises during a program's execution.

By default, exceptions stop the execution of our code. We generally want to handle them gracefully instead.

One of the ways we can handle an exception is called a **try/catch block**.

```java
public class App {
  public static void main(String[] args){

      int a = createInt("hi");
      System.out.println(a);
      System.out.println("Prints after a");
  }

  public static int createInt(String x){
      int y;

      try {
        y = Integer.parseInt(x);
      } catch (NumberFormatException e) {
        y = -1; 
      }

        return y;
      }
}
```

If we have a **checked exception**, we can pass the buck to the method caller using the `throws` keyword, and make them handle the exception.

```java
public static void main(String[] args) {
    System.out.println("Start");
    
    try {
        pause();
    } catch(InterruptedException e) {
        System.out.println(e);
    }

    System.out.println("End");
}

public static void pause() throws InterruptedException {
    Thread.sleep(5000);
}
```

### CUSTOM EXCEPTIONS

We can create custom exceptions when we have additional properties or methods that would provide an advantage to doing so.

```java
//Checked Exception
public class IllegalImageExtension extends Exception {
    public IllegalImageExtension(String msg) {
        super(msg);
    }
}

//Unchecked Exception
public class IllegalImageExtension extends RuntimeException {
    public IllegalImageExtension(String msg) {
        super(msg);
    }
}
```

### EXCEPTIONS IN SPRING

We can create additional classes and methods to handle exceptions in our Spring Boot applications.

**Controller**
```java
@RestController
public class EchoRangeServiceController {

    @RequestMapping(value = "/echo/{input}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int echo(@PathVariable int input) {
        if (input < 1 || input > 10) {
            throw new IllegalArgumentException("Input must be between 1 and 10.");
        }

        return input;
    }
}
```

**Exception Handler**
```java
@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ControllerExceptionHandler {

 @ExceptionHandler(value = {IllegalArgumentException.class})
 @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
 public ResponseEntity<VndErrors> outOfRangeException(IllegalArgumentException e, WebRequest request) {
    VndErrors error = new VndErrors(request.toString(), e.getMessage());
    ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    return responseEntity;
   }
}
```

- `@RestControllerAdvice` annotation makes the Spring Framework aware that this is an error handler for the controllers of this application.
- `@RequestMapping` annotation produces attribute to indicate that error handling methods of this class return application/vnd.error+json format. vnd.error is a standard for returning error information from a REST API. We don't have to use vnd.errors; we can choose what we return to the client. We are just using vnd.error as an example.
- `@ExceptionHandler` declares that this method will handle IllegalArgumentExceptions.
- `@ResponseStatus`declares that this method will return a 422 Unprocessable Entity status. This means that the request was syntactically correct (i.e., it is well-formed HTTP) but that the service can't process it because it it doesn't meet some business rule.
- `ResponseEntity<VndErrors>` from this method. This object will get converted to JSON by the JacksonMapper just as the return types of the methods in the controller are.
- The name of the method is arbitrary. Use a meaningful name.
- Our first parameter is the exception that we want this method to handle. The Spring Framework will automatically hand that to the method.
- The second parameter is the WebRequest. This parameter is not required, but we choose to have the Spring Framework pass it to the method so we can use it to provide better error messages.

In the body of the method:
- First we create a VndErrors object. The constructor takes two parameters.
- The first one is called `logref`. It is used to correlate this error to application logs. In our case, we use the request itself, but different teams and applications will have different standards for what to include here.
- The second parameter is the message for the error. We use the message from the exception.
- Next we create a new ResponseEntity<VndErrors> object. The constructor has two parameters:
  - The VndErrors object
  - The HttpStatus we want to associate with the response.
  