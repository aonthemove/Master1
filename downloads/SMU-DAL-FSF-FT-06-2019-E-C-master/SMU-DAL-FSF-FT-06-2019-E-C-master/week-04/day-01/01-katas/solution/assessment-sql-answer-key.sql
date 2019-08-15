---
--- northwind
---

-------------------------------

--- What are the categories of products in the database?
SELECT 
    products.category
FROM
    northwind.products;

--- What products are made by Dell?
SELECT 
    *
FROM
    northwind.products
WHERE
    product_name LIKE '%Dell%';

--- List all the orders shipped to Pennsylvania.
SELECT 
    *
FROM
    northwind.orders
WHERE
    ship_state = 'Pennsylvania';

--- List the first name and last name of all employees with last names that start with w
SELECT 
    employees.first_name, employees.last_name
FROM
    northwind.employees
WHERE
    employees.last_name LIKE 'W%';

--- List all customers from zipcodes that start with 55
SELECT 
    *
FROM
    northwind.customers
WHERE
    postal_code LIKE '55%';

--- List all customers from zipcodes that end with 0
SELECT 
    *
FROM
    northwind.customers
WHERE
    postal_code LIKE '%0';

 --- List the first name, last name, and email for all customers with a .org email address
SELECT 
    first_name, last_name, email
FROM
    northwind.customers
WHERE
    email LIKE '%.org';

--- List the first name, last name, and phone number for all customers from the 202 area code
SELECT 
    first_name, last_name, phone
FROM
    northwind.customers
WHERE
    phone LIKE '___202%';

--- List the order id for each order placed by George Wilson
SELECT 
    orders.id
FROM
    northwind.orders
        INNER JOIN
    northwind.customers ON customers.id = orders.customer_id
WHERE
    customers.first_name = 'George'
        AND customers.last_name = 'Wilson';

--- List all the products, quantities, and discounts associated with order 4003
SELECT 
    customers.first_name,
    customers.last_name,
    products.product_name,
    order_details.quantity,
    order_details.discount
FROM
    northwind.order_details
        INNER JOIN
    northwind.products ON products.id = order_details.product_id
        INNER JOIN
    northwind.orders ON orders.id = order_details.order_id
        INNER JOIN
    northwind.customers ON customers.id = orders.customer_id
WHERE
    order_details.order_id = 4003;

---
--- car_lot
---

----------------------------

--- Add the following cars to inventory:

--- 2012 Red Honda Accord
INSERT INTO car 
	(id, make, model, model_year, color) 
VALUES 
	(1, 'Honda', 'Accord', '2012', 'red');

--- 2017 Black Chevy Impala
INSERT INTO car 
	(id, make, model, model_year, color) 
VALUES 
	(2, 'Chevy', 'Impala', '2017', 'black');

--- 2019 Siver Ford F-150
INSERT INTO car 
	(id, make, model, model_year, color) 
VALUES 
	(3, 'Ford', 'F-150', '2019', 'silver');

--- 2020 White Subaru Outback
INSERT INTO car 
	(id, make, model, model_year, color) 
VALUES 
	(4, 'Subaru', 'Outback', '2020', 'white');

--- 2015 Silver Ford Mustang
INSERT INTO car 
	(id, make, model, model_year, color) 
VALUES 
	(5, 'Ford', 'Mustang', '2015', 'silver');

--- 2018 Blue Honda Ridgeline
INSERT INTO car 
	(id, make, model, model_year, color) 
VALUES 
	(6, 'Honda', 'Ridgeline', '2018', 'blue');

--- 2017 Gray Chevy Silverado
INSERT INTO car 
	(id, make, model, model_year, color) 
VALUES 
	7, 'Chevy', 'Silverado', '2017', 'gray');


--- Make the following updates to the database:

--- Change all Hondas to Black
UPDATE car
SET color = 'black' 
WHERE make = 'Honda';

--- Change 'Chevy' to 'Cheverolet'
UPDATE car
SET make = 'Cheverolet' 
WHERE make = 'Chevy';

--- Change all 2020 model years to 2019
UPDATE car
SET model_year = '2019' 
WHERE model_year = '2020';

--- Delete the following from the database:

--- Delete all blue inventory
 DELETE from car
WHERE color = 'blue';   
    
--- Delete all Fords
DELETE from car
WHERE make = 'Ford';

--- Delete all cars from 2012 and 2017
DELETE FROM car 
WHERE
    model_year IN ('2012' , '2017');