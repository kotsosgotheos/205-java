/**
 Name: Athanasios Papapostolou
 AM  : 4147
 **/

/**
 @class: Location
 @desc: Assimilates the area where sensors are installed
 **/
class Location {
    /* Data */
    private int id; /* The unique id of each area in the building */

    /* Composition elements */
    private Temperature temp_sensor; /* Composes a temperature sensor */
    private Brightness bright_sensor; /* Composes a brightness sensor */
    private TimeKeeper time; /* Create a time object with a default value of 1 */

    /**
     @Constructor
     @desc: Default constructor
     **/
    Location() {}
    /**
     @Constructor
     @desc: A copy contructor of the original object
     @params: original -> The original object to copy from
     **/
    Location(Location original) {
        /* Static deep copying of the objects recursively */
        /* -> TO MAKE IT DYNAMIC, SERIALIZE THE OBJECTS WITH INLINE JSON */
        /* We don't pass composition data from outside the class*/
        this.id = original.getId(); /* Assign the id */
        this.temp_sensor = new Temperature(original.getTemperature());
        this.bright_sensor = new Brightness(original.getBrightness());
        this.time = new TimeKeeper(original.getTime());
    }
    /**
     @Constructor
     @desc: Creates a Location object
     @params: id -> The default id given by the callee
     **/
    Location(int id) {
        /* Each sensor class takes the location's id plus 1 or 2 respectively
         *	temp_sensor -> 1011
         *	bright_sensor -> 1012
         * as well as a default value of 0, before any readings are taken */
        this.id = id;
        this.temp_sensor = new Temperature(this.id + 1, 0);
        this.bright_sensor = new Brightness(this.id + 2, 0);
        this.time = new TimeKeeper(1);
    }

    /*********************************/
    /* Accessor methods for id field */
    int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /*********************************/

    /******************************/
    /* Used for copy constructors */
    Temperature getTemperature() {
        return this.temp_sensor;
    }
    Brightness getBrightness() {
        return this.bright_sensor;
    }
    private TimeKeeper getTime() {
        return this.time;
    }
    /******************************/

    /*****************************************************************************/
    /* Accessors to the specific sensor values (Provides stronger encapsulation) */
    int getTemperatureValue() {
        return this.temp_sensor.getValue();
    }

    void setTemperatureValue(int value) {
        this.temp_sensor.setValue(value);
    }

    double getBrightnessValue() {
        return this.bright_sensor.getValue();
    }

    void setBrightnessValue(double value) {
        this.bright_sensor.setValue(value);
    }
    /* Access multiple layers of composition data without committing to an inheritance based model */
    /* Follow the javascript 'Object.assign()' idea */
    double getTemperatureReliabilityValue() {
        return temp_sensor.getReliabilityValue();
    }

    void setTemperatureReliabilityValue(double value) {
        this.temp_sensor.setReliabilityValue(value);
    }

    double getBrightnessReliabilityValue() {
        return bright_sensor.getReliabilityValue();
    }

    void setBrightnessReliabilityValue(double value) {
        this.bright_sensor.setReliabilityValue(value);
    }

    int getTimeValue() {
        return time.getValue();
    }

    void setTimeValue(int value) {
        this.time.setValue(value);
    }
    /*****************************************************************************/

    /**
     @func: toString()
     @desc: Overrides the toString method
     @returns: A formatted string describing the id the self area
     **/
    @Override
    public String toString() {
        return("Area: " + this.id + "; ");
    }

    /**
     @func: equals
     @desc: Check for object equality between each specific object in the class (Composition helps on that as well)
     @returns: A boolean
     **/
    @Override
    public boolean equals(Object obj) {
        /* Object is compared with itself */
        if(obj == this) {
            return true;
        }

        /* Check if obj is an instance of Location */
        if(!(obj instanceof Location)) {
            return false;
        }

        /* Typecast obj to Location to compare members */
        Location loc = (Location)obj;
        return this.id == loc.getId();
    }
}