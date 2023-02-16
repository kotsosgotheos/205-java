/**
 Name: Athanasios Papapostolou
 AM  : 4147
 **/

/**
 @class: Reliability
 @desc: Describes the reliability value of each sensor
 (Converting data into classes and functions into state for stronger encapsulation)
 **/
class Reliability {
    /* Data */
    private double value; /* The value of reliability in each sensor */

    /**
     @Constructor
     @desc: Default constructor
     **/
    Reliability() {}
    /**
     @Constructor
     @desc: Creates a deep copy of passed object
     @params: original -> The original object to copy from
     **/
    Reliability(Reliability original) {
        this.value = original.getValue();
    }
    /**
     @Constructor
     @desc: Creates a Realiability object
     @params: value -> The value of reliability
     **/
    Reliability(double value) {
        this.value = value;
    }

    /* Accessor methods for the value field */
    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    /* Overriden toString() method */
    @Override
    public String toString() {
        /* Return a formatted string of the value */
        return String.format("%.2f", this.value);
    }

    /* Overriden equals() method */
    @Override
    public boolean equals(Object obj) {
        /* Object is compared with itself */
        if(obj == this) {
            return true;
        }

        /* Check if obj is an instance of Reliability */
        if(!(obj instanceof Reliability)) {
            return false;
        }

        /* Typecast obj to Reliability to compare members */
        Reliability reliab = (Reliability)obj;
        return Double.compare(this.value, reliab.getValue()) == 0;
    }
}