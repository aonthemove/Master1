# 3.2 Cheatsheet

### SPRING ANNOTATIONS

- `@RestController` A class-level annotation which indicates to Spring that this is a REST Controller
- `@ResponseStatus` This is a method-level annotation that indicates the HTTP status code that is sent back when the method successfully handles the incoming request.
- `@RequestBody` This is a method–parameter-level annotation that maps JSON in the request body to a method parameter.
A component called the Jackson Mapper takes care of converting JSON to Java and Java to JSON.
    - **Note**: For Jackson Mapper to work properly, the Class to be mapped must have an empty constructor and getters/setters for all properties.
- `@PathVariable` and `@RequestBody` can both be used in the same method, without concern for order.

**Simple REST API for Puppies Resource**

```java
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PuppyController {

    private static int id = 1;
    private List<Puppy> puppyList;

    public PuppyController() {
        puppyList = new ArrayList<>();

        puppyList.add(new Puppy(id++, "Duke", 124, true));
        puppyList.add(new Puppy(id++, "Bogey", 55, false));
        puppyList.add(new Puppy(id++, "Poppy", 22, false));
        puppyList.add(new Puppy(id++, "Horse", 310, true));
        puppyList.add(new Puppy(id++, "Memphis", 1, true));
    }

    // Returns entire list of puppies
    @RequestMapping(value = "/puppies", method = RequestMethod.GET)
    public List<Puppy> getAllPuppies() {
        return puppyList;
    }

    // Returns puppy with the id specified
    @RequestMapping(value = "/puppies/{id}", method = RequestMethod.GET)
    public Puppy getPuppyById(@PathVariable int id) {

        for(Puppy puppy : puppyList) {
            if (puppy.getId() == id) {
                return puppy;
            }
        }

        return null;
    }

    // adds a new puppy to the list
    @RequestMapping(value = "/puppies", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Puppy createPuppy(@RequestBody Puppy puppy) {
        puppy.setId(id++);
        puppyList.add(puppy);
        return puppy;
    }

    // removes the puppy with the specified id
    // returns status code 204, saying all is well, but no content returned 
    @RequestMapping(value = "/puppies/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePuppy(@PathVariable int id) {
        int index = -1;

        for(int i = 0; i < puppyList.size(); i++) {
            if(puppyList.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        puppyList.remove(index);
    }

    // replaces the puppy at the specified id with the one provided in the request body
    // returns status code 204, saying all is well, but no content returned
    @RequestMapping(value = "/puppies/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateStudent(@PathVariable int id, @RequestBody Puppy puppy) {
        for (int i = 0; i < puppyList.size(); i++){
            if(puppyList.get(i).getId() == id){
                puppyList.set(i, puppy);
            }
        }
    }

}
```

### VALIDATION

Validation can be added to our REST API via annotations.

A list of possible constraints can be found here: `https://javaee.github.io/javaee-spec/javadocs/javax/validation/constraints/package-summary.html`

We place the constraint on the class properties directly. We can have multiple constraints on a property.

```java
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Puppy {

    @PositiveOrZero
    private int id;
    @NotBlank
    @NotNull
    private String name;
    @Max(value=500)
    private int kennelNum;
    private boolean isAdopted;

    // getters and setters excluded for brevity
}
```

Then we can validate any object of that type that is passed to us.

``` java 
// POST method for Puppy Controller
// @Valid annotation can be added to the Puppy object received in the request body
@RequestMapping(value = "/puppies", method = RequestMethod.POST)
@ResponseStatus(value = HttpStatus.CREATED)
public Puppy createPuppy(@RequestBody @Valid Puppy puppy) {
    puppy.setId(id++);
    puppyList.add(puppy);
    return puppy;
}
```

**Note**: You'll need to add the import for the `@Valid` annotation in the controller.