# 3.1 Cheatsheet

### REST API

REST APIs follow some general rules:

* Resources are indicated by URIs
* Actions are indicated by HTTP methods
* Data is transferred via media types in the request and response bodies (usually JSON)

The most common HTTP verbs (or methods) to know are:

* `GET` - used to retrieve data (browsers make GET requests when you type a URL in the address bar).
* `POST` - used to add new data to a database.
* `PUT` - used to update an existing database entry (like changing a students name).
* `DELETE` - used to remove an entry from the database entirely. 

### SPRING BOOT

We can create our basic application skeleton using Spring Initializr 

1. Open the browser and navigate to `https://start.spring.io`.
1. Create a new project with the following settings (anything not specified below should be left at the default value):
  - Project Metadata - Artifact: \<PROJECTNAME\>
  - Dependencies: Web
1. Click Generate Project.
1. Unzip the project and open it in IntelliJ.

### SPRING ANNOTATIONS

We create a controller to tell Spring Boot how to handle requests on specific endpoints

```java
@RestController
public class HelloController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getHello() {
        return "hello";
    }
}
```

- `@RestController` specifies (among other things) that the return values of methods annotated with `@RequestMapping` should be included in the HTTP response body.
- `@RequestMapping` specifies that the associated method gets invoked when the endpoint described in the annotation is called. In our case, this method will get called when a GET request is sent to localhost:8080.


We can specify specific resources by using **path variables**

```java
@RestController
public class EchoServiceController {

 @RequestMapping(value = "/echo/{input}", method = RequestMethod.GET)
    public String getEcho(@PathVariable String input) {
        return input;
    }
}
```

`@PathVariable` annotation: 
- Maps a path variable (marked by {} in the path) to a method parameter.
- The Spring Framework takes care of correctly converting the value to the right type.
- Place this annotation before the method parameter that you want to associate with the path variable.
- If the name of the path variable is the same as the name of the method variable, no further configuration is needed.
- If they don't match, you can specify which path variable to map to the parameter like this: @PathVariable("pathVarName")
