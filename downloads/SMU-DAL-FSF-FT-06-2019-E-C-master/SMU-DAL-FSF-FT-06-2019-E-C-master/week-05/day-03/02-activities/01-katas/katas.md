# Kata Instructions

### Physics Library

Goals: 
- Write tests to satisfy the requirements below. 
- Then implement the code to pass the tests. 

Your requirements state that you need a Physics library with the following functionality
- All numbers are doubles
- calculateForce which returns the product of mass and acceleration
- calculateVelocity which returns distance2 minus distance1 divided by time2 minus time1. 
- calculateMass which returns weight divided by gravity
- calculateAcceleration which returns velocity2 minus velocity1 divided by time2 minus time1.

### Summing Library

Goals: 
- Write tests to satisfy the requirements below. 
- Then implement the code to pass the tests. 

Your requirements state that you need a Summing library with the following functionality
- You need a class that has four properties primeSum, evenSum, oddSum, sum each a double. 
- You need an additional class with 1 property - a List of instances of the above class.
- You must be able to add new instances to the List. A new instance is created by passing in an integer. The sum of all of the primes from 1 to this number should be calculated and stored as primeSum. Similarly, the sum of all even numbers from 1 to this number should be calculated and stored as evenSum. Oddsum stores the 
sum of odds and sum stores the sum of all numbers from 1 to the supplied number. 
- The latter class should have a method to flatten the List to an array, which is to say, take the 4
numbers from each object in the list and store them in an array. e.g.: [ primeSum1, evenSum1, oddSum1, sum1, primeSum2, evenSum2, oddSum2, sum2, … ]