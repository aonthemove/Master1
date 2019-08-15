# 4.2 Cheatsheet

### DTOs

Data Transfer Objects, or **DTOs** are how we can map Java objects to database records.

We do this using **annotations**.

When creating our DTO, we use the **wrapper class** instead of primitives, i.e. `Integer` instead of `int`

```java
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;

    private String company;
    private String phone;

    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Note> notes;

    // Getters and  setters omitted for brevity
}
```

Annotations:

* ```@Entity```—class-level annotation that marks this as a persistable object. The class maps to a table.
* ```@Table```—class-level annotation that specifies the name of the table this class maps to. This is optional. The table name will be the class name if this annotation is not present.
* ```@Id```—property-level annotation that indicates that this is the primary key/identifier for this class.
* ```@GeneratedValue```—property-level annotation that indicates that the value for the property is generated.
    * We use ```strategy=GenerationType.AUTO``` because we want the database to auto-generate this value for us. This maps to ```auto_increment``` in MySQL.
* ```@OneToMany```—property-level annotation that indicates that this is the one side of a one to many relationship.
    * The ```mappedBy``` attribute indicates the propery in the associated object that acts as the foreign key (in our case, it is the ```customerId``` property of the Note class).
    * The ```CascadeType.ALL``` attribute value indicates that we want the database to delete all associated Notes if we delete the Customer.
    * The ```FetchType.EAGER``` attribute value indicates that we want Spring Data JPA to create all the Note objects associated with the Customer when the Customer object is instantiated. The other value for this attribute is ```FetchType.LAZY``` which defers the retrieval of Note data and creation of the Note objects until they are accessed by other code. We generally want all the data up front in a web service because we are shipping the data back to a client of some sort, so we use ```EAGER```.
    * Point out that our Customer class contains a Set of Notes. Spring Data JPA will take care of getting the data from the database and creating the Note objects for us.
* ```@JsonIgnoreProperties```—class-level annotation that specifies properties that should be ignored when serializing this object to JSON.
    * This is not JPA-specific and is not necessary for DAO functionality but it is needed when we use a JPA DAO in a REST web service where we want to exclude Hibernate-specific fields.


### JPA REPOSITORY

We can create a repository for our DTO by simply creating a new interface. JPA will fill in all the details for us!

```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
```

We can also create custom query methods by simply defining them in the repository interface.

```java
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    List<Customer> findByCompany(String company);
    List<Customer> findByLastNameAndCompany(String lastName, String company);
}
```

In addition to our customer queries, we get our basic CrudOperations for free.

Check out the JavaDoc page `https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html` for more info!

```
count()
delete()
deleteAll()
deleteById()
existsById()
findAll()
findAllById()
save()
saveAll()
```