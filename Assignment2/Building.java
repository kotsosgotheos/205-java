/**
 Name: Athanasios Papapostolou
 AM  : 4147
 **/

import java.util.Vector; /* new Vector(), .add(), */

/**
 @class: Building
 @desc: Creates a building hosting all locations where sensors are installed
 **/
class Building {
    /* Data */
    private int id;

    /* Composition data */
    /* Create a vector for storing the locations and their data */
    /* Create accessors copy constructor and overridden methods (NOT RECOMMENDED TO USE) */
    private Vector<Location> locations;

    /**
     @Constructor
     @desc: Default constructor
     **/
    Building() {}
    /**
     @Constructor
     @desc: Creates a deep copy of the object passed in
     @params: original -> The original object to copy from
     **/
    Building(Building original) {
        this.id = original.getId();
        this.locations = new Vector<Location>();
    	/* Because locations is a mutable vector we have to copy
    	 each individual mutable object recursively until we copy 
    	 immutable objects (HARD TO MAINTAIN, NOT RECOMMENDED TO USE) */
        original.getLocations().stream().forEach(loc -> {
            this.locations.add(new Location(loc));
        });
    }
    /**
     @Constructor
     @desc: Creates a building with a unique id and locations vector
     @params: id -> The unique id for the building
     **/
    Building(int id) {
        this.id = id;
        this.locations = new Vector<Location>();
    }

    /********************************/
    /* Accessors for the 'id' field */
    int getId() {
        return this.id;
    }

    void setId(int id) {
        this.id = id;
    }
    /********************************/

    /******************************/
    /* Used for copy constructors */
    Vector<Location> getLocations() {
        return this.locations;
    }
    /******************************/

    /* Overridden toString() method */
    @Override
    public String toString() {
        /* Returns a formatted string of the Building id */
        return("Building: " + this.id + "; ");
    }

    /* Overridden equals() method */
    @Override
    public boolean equals(Object obj) {
        /* Object is compared with itself */
        if(obj == this) {
            return true;
        }

        /* Check if obj is an instance of Building */
        if(!(obj instanceof Building)) {
            return false;
        }

        /* Typecast obj to Building to compare members */
        Building building = (Building)obj;
        return this.id == building.getId();
    }
}