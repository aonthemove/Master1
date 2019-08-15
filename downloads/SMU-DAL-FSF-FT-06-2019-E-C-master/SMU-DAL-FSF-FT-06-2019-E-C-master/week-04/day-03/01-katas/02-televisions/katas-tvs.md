# Television Service Layer

This project involves the creation of a Spring Data JPA Repository and database.

## Structure
Your solution must have the following structural elements:

* Your solution must be in an IntelliJ project called ```TelevisionJpaRepositoryFirstnameLastname``` where Firstname and Lastname are your first and last name respectively.
* Your solution must use Spring Data JPA.

## Methodology

* Create your Java objects, annotate them, and let Spring Data JPA create your database.
* Use the tests to help guide you.

## Requirements/Features

This project is a Spring Data JPA repository and relational database that keeps track of televisions in inventory. 

* Create a DTO for the Television table found below
* Create a JPA Repository.
	* Your DAO API must allow callers to create, read, read all, update, and delete Televisions in the system. The system must also allow callers to find Televisions by Manufacturer
* Create a ServiceLayer.
	* In addition to the above functions, the service layer must do the following:
		* Contain a method called `findTelevisionsAboveSize` which returns only TVs above (and including) the specified size.
		* Contain a method called `findTelevisionsNewerThan` which returns only TVs newer than (and including) the specified year.
		* Contain a method called `findByEitherManufacturer` which takes in two manufacturers and returns TVs made by either.
		* Contain a method called `findAverageByManufacturer` which returns the average screen size of all TVs by the specified manufacturer.

```sql
CREATE TABLE televisions (
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	manufacturer VARCHAR(255) NOT NULL,
	model VARCHAR(255) NOT NULL,
	year INTEGER NOT NULL,
	screen_size DECIMAL (4,1) NOT NULL
);
```

---

© 2019 Trilogy Education Services
