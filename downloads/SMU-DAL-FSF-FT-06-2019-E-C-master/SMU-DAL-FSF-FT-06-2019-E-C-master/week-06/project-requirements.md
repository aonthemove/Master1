# Capstone 1 Project Requirements

Choosing one of the scenarios listed in the "Client Requirements" section, design and build an application using Spring Boot and JPA backed by a SQL database that meets the following criteria:

1. Meets all client requirements
1. Employs TDD in every phase of architecting the project
1. Provides highly usable documentation
1. Normalizes all database tables to 3rd normal form
1. Employs at least 1 join

## Custom Cars
A client is running a custom car manufacturing firm. They hand build custom cars to order. They work with 5 different suppliers who all provide different parts.  Supplier A provides tires, brakes, rims, exhaust, and bumpers. Supplier B provides radios, speakers, miscellaneous electronics, upholstery, and trim. Supplier C provides fiberglass, steel, and molded plastic parts. Supplier D provides engines, differentials, catalytic converters, fuel pumps, and axles. Supplier E provides radiators, fans, belts, compressors, and heater cores.  The client needs to be able to accomplish the following tasks: 

Add new type of item to inventory and associate it with a specific vendor. 
Add or update vendor information (name, email, phone)
Update type of items in inventory  (part name, associated vendor, quantity in stock, price per item)
Add a new individual item to the inventory (each type like brake can have hundreds of individual items each with a unique serial number. If we have 50 brakes in stock, there should be at least 50 entries in table of individual parts with brake as their type and a unique serial number for each)
Delete individual items from inventory (when a new car is built, it should be associated with the requisite parts by serial number and those should be marked as “used” in a status column, they should not be removed from the database. Items will be deleted if they are lost or defective) 

Search for low inventory (any item with less than 50 remaining in stock). 
Add new orders with a start date and completion date (this should automatically decrement inventory by the specified amount on the start date - this requires scheduling a task to run on a given date. This should also associate individual parts serial numbers with this build and mark those parts as “used” in the individual parts table). 
Delete orders (should mark any previously associated parts as unused). 
Update quantity in stock of any part.

---

## Building Access
The client works with building owners and property management companies across the nation. They are currently working with a client in California and are looking to install an access card system building-wide. 

The building is 8 stories and each floor is occupied by a different company except the 7th and 8th floors. The 7th and 8th floors are both occupied by one company.

On top of that, the 6th floor tenant has 2 additional areas that requires elevated access for their employees. In addition to a general working area, the 6th floor also has conference rooms that are reserved for only managers of their company and a server room that is reserved only for their Database Admin.
Create 7 dummy companies to occupy all of the floors of the building. 
Come up with 30 different people and randomly assign them to each company. Things to include:
Name
Company 
Title
Hire Date
Working Hours Start Time
Working Hours End Time
entry into the building will not be allowed except for between the Start and End time.

The program needs to be able to do the following:

New User Creation
New Company Creation
User Deletion
Company Deletion
Handle Promotions/Demotions (Changes in access if any)
Directory Function: Retrieve all company information.
Search for all Employees of a given company.
Request authorization for entry
Keep a log of all entries and exits, which simply tracks the user id, whether it was an entry or exit, and the time
Retrieve the entry/exit log for a specific user, as well as for a specific company.

——

## Airline Travel
A client is looking to migrate their analogue flight information system to digital. The client partners with 5 major airlines to enable service to travelers nationwide. There are 6 to 12 hubs nationwide and not all airlines go to all hubs. 

On a daily basis there are, on average, 30 flights across all airports and utilize a mixture of all airports and airlines. Each flight varies in price based on distance or hub. Assume that each stop along the way adds 45 minutes to the total travel time but reduces price. 

Add new airlines and associate what airports it serves. Ability to delete airlines.
Add new flights and associate which airline the flights are with, as well as the destination and departure airport. Ability to delete flights.
Retrieve all flight information
Retrieve all Airport Hub information
Retrieve all Airline information
Flight prices based on distance. Calculate the cheapest or shortest flight between two airports. 
Retrieve all flight information associated with a specific airline at a specific airport.

---

## Task Board
A client wants to build out a Kanban board from scratch as it will be proprietary software. The task board should be able to hold any number of user-defined categories such as “In-Progress” and/or “Completed”. At a minimum the client wants to have 4 categories. Within each category, users should be able to add as many tasks as they wish. 

Each task should have a title, description, due date, and be able to associate multiple users.

Retrieve all tasks from all categories.
Retrieve all tasks associated with a user.
Retrieve all tasks associated with a specific category AND user.
Add new tasks. Title, Description, Due Date, and at least one user is required. Multiple users are optional. Users must be selected only from users that exist in the application.
Add new Users. They don’t have to be assigned to a task at creation. 
Ability to alter tasks from one category to another.
Ability to alter tasks from one user to another (this includes the ability to remove and add users to tasks).
Ability to alter task’s description, title, and due date.
Ability to get a completion percentage by category. 

---

## Marketplace
A client wants to build an inventory management system for their warehouse. The inventory management system must account for multiple different product categories such as beds, televisions, sofas, shoes, etc. Each product must be associated with a category. Each product should have a price, quantity, and rating (1-5). System should store previous orders.

Retrieve all products in a specified category.
Retrieve all products in a specified category above a rating of 4.
Be able to sort products based on price in ascending or descending order. This sort must be done using your own algorithm.
Ability to create a cart that will sum the total price of all items in the cart. 
Ability to add/remove products to/from the cart.
Ability to create new categories
Ability to create new products
Ability to add/update quantity based on items in the cart.
Ability to add/edit ratings to an existing product
Ability to retrieve order history. This must allow the client to see all items and quantities of each order.

