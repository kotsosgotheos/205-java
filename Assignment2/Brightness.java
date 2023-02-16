/**
 Name: Athanasios Papapostolou
 AM  : 4147
 **/

/**
 @class: Brightness
 @desc: Describes the functions of a brightness sensor
 **/
class Brightness {
    /* Data */
    private int id; /* Unique sensor code */
    private double value; /* Sensor value */

    /* Composition elements */
    /* Define a Reliability object with a default value */
    private Reliability reliab;

    /**
     @Constructor
     @desc: Default constructor
     **/
    Brightness() {}
    /**
     @Constructor
     @desc: Creates a deep copy of the original object passed to it
     @params: original -> The original object to copy from
     **/
    Brightness(Brightness original) {
        this.id = original.getId();
        this.value = original.getValue();
        this.reliab = new Reliability(original.getReliability());
    }
    /**
     @Constructor
     @desc: Creates a Brightness object
     @params: id -> The unique if of the sensor
     @params: value -> The default value passed to the sensor
     **/
    Brightness(int id, double value) {
        this.id = id;
        this.value = value;
        this.reliab = new Reliability(0);
    }

    /*************************************************/
    /* Accessor methods for id, value, reliab fields */
    int getId() {
        return this.id;
    }

    void setId(int id) {
        this.id = id;
    }

    double getValue() {
        return this.value;
    }

    void setValue(double value) {
        this.value = value;
    }
    /*************************************************/

    /******************************/
    /* Used for copy constructors */
    private Reliability getReliability() {
        return this.reliab;
    }
    /******************************/

    /***************************************************/
    /* Accessor methods for composition data of reliab */
    double getReliabilityValue() {
        return this.reliab.getValue();
    }

    void setReliabilityValue(double value) {
        this.reliab.setValue(value);
    }
    /***************************************************/

    /* Overridden toString() method */
    @Override
    public String toString() {
        /* Returns a formatted string of the brightness value */
        return("Brightness: " + String.format("%.2f", this.value) + "; ");
    }

    /* Overridden equals() method */
    @Override
    public boolean equals(Object obj) {
        /* Object is compared with itself */
        if(obj == this) {
            return true;
        }

        /* Check if obj is an instance of Brightness */
        if(!(obj instanceof Brightness)) {
            return false;
        }

        /* Typecast obj to Brightness to compare members */
        Brightness bright = (Brightness)obj;
        return this.id == bright.getId()
                && Double.compare(this.value, bright.getValue()) == 0;
    }
}