/**
 Name: Athanasios Papapostolou
 AM  : 4147
 **/

/**
 @class: Temperature
 @desc: Describes the functions of a temperature sensor
 **/
class Temperature {
    /* Data */
    private int id; /* Unique sensor code */
    private int value; /* Sensor value */

    /* Composition elements */
    /* Instantiate a Reliability object with a default value */
    private Reliability reliab;

    /**
     @Constructor
     @desc: Default constructor
     **/
    Temperature() {}
    /**
     @Constructor
     @desc: Creates a deep copy of the original object passed
     @params: original -> The original object to copy from
     **/
    Temperature(Temperature original) {
        this.id = original.getId();
        this.value = original.getValue();
        this.reliab = new Reliability(original.getReliability());
    }
    /**
     @Constructor
     @desc: Creates a Temperature object with a specific id and value
     @params: id -> The specific unique id of the sensor
     @params: value -> The default value of the sensor
     **/
    Temperature(int id, int value) {
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

    int getValue() {
        return this.value;
    }

    void setValue(int value) {
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
        /* Returns a formatted string of the temperature value */
        return("Temperature: " + this.value + "; ");
    }

    /* Overridden equals() method */
    @Override
    public boolean equals(Object obj) {
        /* Object is compared with itself */
        if(obj == this) {
            return true;
        }

        /* Check if obj is an instance of Temperature */
        if(!(obj instanceof Temperature)) {
            return false;
        }

        /* Typecast obj to Temperature to compare members */
        Temperature temp = (Temperature)obj;
        return this.id == temp.getId()
                && this.value == temp.getValue();
    }
}