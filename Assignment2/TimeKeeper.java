/**
 Name: Athanasios Papapostolou
 AM  : 4147
 **/

/**
 @class: TimeKeeper
 @desc: Describes a global behaviour of changing time throughout sensor value updtaes
 **/
class TimeKeeper {
    /* Data */
    private int value; /* The value of time */

    /**
     @Constructor
     @desc: Default constructor
     **/
    TimeKeeper() {}
    /**
     @Constructor
     @desc: Creates a deep copy of the original object passed to it
     @params: original -> The original object to copy from
     **/
    TimeKeeper(TimeKeeper original) {
        this.value = original.getValue();
    }
    /**
     @Constructor
     @desc: Creates a TimeKeeper object with a default value passed to it
     @params: value -> The value of time
     **/
    TimeKeeper(int value) {
        this.value = value;
    }

    /* Accessor methods for value field */
    int getValue() {
        return this.value;
    }

    void setValue(int value) {
        this.value = value;
    }

    /* Overridden toString() method */
    @Override
    public String toString() {
        return("Time: " + this.value + "; ");
    }

    /* Overridden equals() method */
    @Override
    public boolean equals(Object obj) {
        /* Object is compared with itself */
        if(obj == this) {
            return true;
        }

        /* Check if obj is an instance of TimeKeeper */
        if(!(obj instanceof TimeKeeper)) {
            return false;
        }

        /* Typecast obj to TimeKeeper to compare members */
        TimeKeeper time = (TimeKeeper)obj;
        return this.value == time.getValue();
    }
}