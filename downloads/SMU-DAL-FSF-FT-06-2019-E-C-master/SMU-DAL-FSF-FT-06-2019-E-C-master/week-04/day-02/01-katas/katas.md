# Car Lot DAO

This project involves the creation of a Spring Data JPA Repository and database.

## Structure
Your solution must have the following structural elements:

* Your solution must be in an IntelliJ project called ```CarLotJpaRepositoryFirstNameLastName``` where Firstname and Lastname are your first and last name respectively.
* Your solution must utilize Spring Data JPA.

## Methodology

* Create your Java objects, annotate them, and let Spring Data JPA create your database.
* Use the tests to guide you.

## Requirements/Features

This project is a Spring Data JPA repository and relational database that keeps track of cars on a car lot. 

* Your Repository API must allow callers to create, read, read all, update, and delete Cars in the system. The system must also allow callers to find Cars by Make, to find Cars by Color, and to find Cars by Make and Color.

The Car DTO should model the below schema

```sql
CREATE TABLE car (
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	make VARCHAR(100) NOT NULL,
	model VARCHAR(100) NOT NULL,
	year VARCHAR(4) NOT NULL,
	color VARCHAR(100) NOT NULL
);

---

© 2019 Trilogy Education Services
