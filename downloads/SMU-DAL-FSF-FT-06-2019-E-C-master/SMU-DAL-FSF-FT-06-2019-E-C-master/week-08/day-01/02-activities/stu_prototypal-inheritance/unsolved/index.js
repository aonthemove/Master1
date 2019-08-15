// **Instructions:**

// Discuss the code below with your partner. 

// Work together to guess where the following properties and methods exist: 

// 1. numOfFeet 
// 2. sound
// 3. color
// 4. name
// 5. makeNoise
// 6. sayName
// 7. rollOver

// Run the code below. Use `console.log()` to print the `rover` object to the console. Note which functions and properties are on the object. 

// Navigate through the object and find the reference to its prototype. Expand the prototype. Note which functions exist there. 

// Which function(s) are we missing? See if you can find them. 


class Animal {
    constructor (numOfFeet, sound, color){
      this.numOfFeet = numOfFeet;
      this.sound = sound;
      this.color = color;
    }
  
    makeNoise(){
      console.log(this.sound);
    }
  
  }
  
  class Dog extends Animal{
    constructor (color, name){
      super(4, 'woof', color);
      this.name = name;
    }
  
    sayName (){
      console.log(this.name);
    }
  }
  
  const rover = new Dog('black', 'Rover McSweeten III');
  
  rover.rollOver = function (){
    console.log('rolling over');
  }