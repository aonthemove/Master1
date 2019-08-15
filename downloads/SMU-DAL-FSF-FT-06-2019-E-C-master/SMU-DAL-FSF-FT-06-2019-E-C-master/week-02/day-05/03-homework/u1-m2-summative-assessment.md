# Summative Assessment: Object-Oriented Programming in Java

This assessment consists of several coding exercises that evaluate your understanding of object-oriented programming in Java.

## Structure
* All code must reside in one directory called `U1-M2-Summative-Lastname-Firstname`.
* Your solution for each exercise must reside in its own IntelliJ project as specified in the exercise specifications below.

## Requirements/Features

### CarInventory 

In this activity you will design and build a simple application based on the specification below. This specification is intentionally vague, this exercise is meant to force you to think about the design of the application and to ask good questions about the requirements.

Create your solution in an IntelliJ project called (```CarInventory```).

1. This application must keep track of an inventory of cars.
1. It must track the following data about the cars in inventory:
    1. Make
    1. Model
    1. Year
    1. Color
    1. Miles on the odometer
1. The application must allow the user to do the following:
    1. Add a car to inventory
    1. Delete a car from inventory
    1. List all the cars in inventory
    1. Search for cars by:
        1. Make
        1. Model
        1. Year
        1. Color
        1. Less than a certain number of miles
1. The user interface for this application must be the command line

You are to use Collections, Lists, Maps, and everything else you've learned thus far in the course to solve this problem.

**CHALLENGE:**
- Handle any Exceptions resulting from bad input values
- Implement the search functionality using Java 8 streams and lambdas

---

### RPGInheritance
In this exercise, you will design an inheritance hierarchy for characters in a video game. Your design must include a common base clase for the following three character types:
* Farmer
* Constable
* Warrior


Create your solution in an IntelliJ project called (```RPGInheritance```).

* Farmer
  * Properties:
    * name
    * strength (initial value = 75)
    * health (initial value = 100)
    * stamina (initial value = 75)
    * speed (initial value = 10)
    * attackPower (initial value = 1)
  * Abilities:
    * run
    * plow
    * harvest
    * attack
    * heal
    * decreaseHealth
    * increaseStamina
    * decreaseStamina
* Constable
  * Properties
    * name
    * strength (initial value = 60)
    * health (initial value = 100)
    * stamina (initial value = 60)
    * speed (initial value = 20)
    * attackPower (initial value = 5)
    * jurisdiction
  * Abilities:
    * run
    * arrest
    * attack
    * heal
    * decreaseHealth
    * increaseStamina
    * decreaseStamina
* Warrior
  * Properties
    * name
    * strength (initial value = 75)
    * health (initial value = 100)
    * stamina (initial value = 100)
    * speed (initial value = 50)
    * attackPower (initial value = 10)
    * shieldStrength (initial value = 100)
  * Abilities:
    * run
    * attack
    * heal
    * decreaseHealth
    * increaseStamina
    * decreaseStamina
    * decreaseShieldStrength
---
© 2019 Trilogy Education Services




