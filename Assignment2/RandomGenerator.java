/**
 Name: Athanasios Papapostolou
 AM  : 4147
 **/

import java.util.Random; /* new Random(), .nextInt() .nextDouble() */

/**
 @class: RandomGenerator
 @desc: Describes the functions on creating random integers and doubles
 **/
class RandomGenerator {
    /* Random object */
    private Random r;

    /* Ideally we don't create a copy of this */
    // RandomGenerator(RandomGenerator original) {
    // 	this.r = new Random();
    // }

    /**
     @Constructor
     @desc: Create a simple Random object
     **/
    RandomGenerator() {
        this.r = new Random();
    }
    /**
     @func: generateRandom
     @desc: Generate a random integer between 0 and max
     @params: max -> The max value to generate a random int up to
     @returns: The random integer
     **/
    int generateRandom(int max) {
        return r.nextInt(max);
    }
    /**
     @func: generateRandom
     @desc: Generate a random double between 0 and max
     @params: max -> The max value to generate a random value up to
     @returns: the random double
     **/
    double generateRandom(double max) {
        return r.nextDouble() * max; /* Not sure yet why I have to multiply by max */
    }

    /* OPTIONAL: WE IDEALLY DON'T USE THESE ACCESSORS */

    // Random getR() {
    // 	return this.r;
    // }

    // void setR(Random r) {
    // 	this.r = r;
    // }

    /* WE IDEALLY DON'T OVERRIDE THESE METHODS  */

    /* Overridden toString() method */
    // @Override
    // public String toString() {
    //     return(this);
    // }

    // /* Overridden equals() method */
    // @Override
    // public boolean equals(Object obj) {
    //     /* Object is compared with itself */
    //     if(obj == this) {
    //         return true; 
    //     } 

    //     /* Check if obj is an instance of RandomGenerator */
    //     if(!(obj instanceof RandomGenerator)) {
    //         return false; 
    //     }

    //     /* Typecast obj to RandomGenerator to compare members */
    //     RandomGenerator fire = (RandomGenerator)obj;
    //     return this.r == fire.getR();
    // }
}