# Coffee Inventory DAO

This project involves the creation of a Spring Data JPA Repository and database.

## Structure
Your solution must have the following structural elements:

* Use the starter code provided.
* Your solution must use Spring Data JPA.

## Methodology

* Create your Java objects, annotate them, and let Spring Data JPA create your database.
* Use the tests to help guide you.

## Requirements/Features

This project is a Spring Data JPA repository and relational database that keeps track of coffee in inventory. 

* Your DAO API must allow callers to create, read, read all, update, and delete Coffees and Roasters in the system. The system must also allow callers to find Coffees by Roaster Id, Coffees by Type, and Coffees by Roaster Id and Type.

Your DTOs should model the below MySQL tables:

```sql
CREATE TABLE  coffee (
	coffee_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    roaster_id INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL,
    count INTEGER NOT NULL,
    unit_price decimal(5,2) NOT NULL,
    description VARCHAR (255), 
    type VARCHAR (50)
);

CREATE TABLE if not exists roaster (
	roaster_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    street VARCHAR (50) NOT NULL,
    city VARCHAR (50) NOT NULL,
    state CHAR(2) NOT NULL,
    postal_code VARCHAR (25) NOT NULL,
    phone VARCHAR (15) NOT NULL,
    email VARCHAR (60) NOT NULL,
    note VARCHAR (255)
);

/* Foreign Keys: coffee */
ALTER TABLE coffee ADD CONSTRAINT fk_coffee_roaster FOREIGN KEY (roaster_id) REFERENCES roaster(roaster_id);
```


---

© 2019 Trilogy Education Services





