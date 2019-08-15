# List of Katas
​
## Structure
​
- Add the code to each `.js` referenced for each kata.
- Add a link to the `index.html` file to run the code.
- Comment out the link once your code is complete for each kata.
​
## Requirements
​
1. In `functions.js` define and implement the following functions:
​
    - **Subtract Two**: Create a function called `subtract` that takes two parameters (a and b) and returns the value of b subtracted from a.
    - **Subtract or Zero**: Create a function called `subtractOrZero` that takes two parameters (a and b) and returns the value of b subtracted from a, unless the result is less than zero, in which case, return 0.
    - **Max**: Create a function called `max` that takes three parameters (a, b, and c) and returns the value of the largest of the three.
    - **Min**: Create a function called `min` that takes three parameters (a, b, and c) and returns the value of the smallest of the three.
    - **isLarger**: Create a function called `isLarger` that takes two parameters (first and second) and returns true if the first is greater than second.
1. In `arrays.js`, define and implement the following functions:
​
	- **Total**: Create a function called `total` which returns the sum of all the values in an array. Your code should work for an array of any size.
	    - _Example Input_: `[0, 1, 2, 3, 4, 5, 6, 7]`
	    - _Example Output_: `28`
	- **Total Odd**: Create a function called `totalOdd` which returns the sum of only the values of the odd numbered indexes in an array. Your code should work for an array of any size.
	    - _Example Input_: `[0, 1, 2, 3, 4, 5, 6, 7]`
	    - _Example Output_: `16`
	- **Total Even**: Create a function called `totalEven` the sum of only the values of the even numbered indexes in an array. Your code should work for an array of any size.
	    - _Example Input_: `[0, 1, 2, 3, 4, 5, 6, 7]`
	    - _Example Output_: `12`
	- **2nd Largest Number**: Create a function called `secondLargestNumber` which returns the second largest number in an array. Your code should work for an array of any size. Assume your input array will always have a length of at least 2.
	    - _Example Input_: `[0, 1, 2, 3, 4, 5, 6, 7]`
	    - _Example Output_: `6`
1. In `classes.js`, complete the following:
	- Working off of the UML diagrams found in `starter-code`, create a class for each of the objects that have been previously modeled.
	- Instantiate and use each class at least once.
1. In `inheritance.js`, complete the following:
	1. Create a `Car` class. It should implement `Vehicle` and have the following properties:
	    - `make`
	    - `model`
	    - `milesTraveled`
	1. Create a `Sedan` class. It should extend `Car` and have the following properties:
	    - `numDoors`
	    - `poweredWindows`
	1. Create an `Accord` class. It should extend `Sedan` and have the following properties:
	    - `year`
	    - `engine`
	    - `transmission`
	1. Instantiate and use the `Accord` class.