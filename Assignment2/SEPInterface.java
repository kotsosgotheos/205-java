/**
 Name: Athanasios Papapostolou
 AM  : 4147
 **/

import java.util.Objects;
import java.util.Vector; /* new Vector(), .add(), */
import java.lang.Math; /* .exp() */
import java.util.concurrent.atomic.AtomicInteger; /* new AtomicInteger() */

/**
 @class: SEPInterface
 @desc: Describes the basic operations of the fire system
 such as adding sensors to locations and updating their values
 **/
class SEPInterface {
    /* Data */
    private int defaultBuildingId; /* Create a default id to pass to Building objects for initialization */
    private int defaultLocationId; /* Create a default id to pass to Location objects for initialization */

    /* Composition data */

    /* Simulates the sensor parameters */
    private RandomGenerator rand;
    private Writer writer;

    /* Create a vector for storing the building and their locations */
    private Vector<Building> buildings;

    /* The data to create after updating values read by sensors (used for measures.txt) */
    /* USe a StringBuilder in order to avoid potential buffer overflows
        (string being too big for a single variable) */
    private StringBuilder data;

    /**
     @Constructor
     @desc: Default constructor
     **/
    SEPInterface() {
        this.defaultBuildingId = 0;
        this.defaultLocationId = 1000;
        this.rand = new RandomGenerator();
        this.writer = new Writer();
        this.buildings = new Vector<Building>();
        this.data = new StringBuilder();
    }

	/* Optional to use copy constructor because its the main class executing the loop of the program
		Ideally we don't create a deep copy of this
	*/

    /**
     @func: checkForId
     @desc: Check if a specific building id exists in the vector
     @params: id -> The id to search for
     @returns: A boolean signaling if the id exists or not
     **/
    boolean checkForId(int id) {
        /* Streamlines the buildings and filters for a building_id passing the given test */
        /* Considering all buildings have unique id's the any single match can pass the test */
        return buildings.stream().anyMatch(build -> build.getId() == id);
    }

    /**
     @func: showBuildings
     @desc: Iterate through the buildings vector and display each element
     **/
    void showBuildings() {
        /* Use the overridden toString method */
        buildings.stream().forEach(build -> {
            /* Print the building id and the number for Locations with installed modules */
            System.out.print(build);
            System.out.print("Number of locations with installed modules: " + build.getLocations().size() + ";\n");
        });
    }

    /**
     @func: insertBuilding
     @desc: Insert a new building in the vector
     **/
    void insertBuilding() {
        /* Fix the defaultBuildingId to the next number */
        this.defaultBuildingId += 1;

        /* Buildings have id's of 1010, 1020, 1030.. */
        /* Add the building object to the vector */
        buildings.add(new Building(this.defaultBuildingId));
    }

    /**
     @func: insertLocation
     @desc: Inserts a new location to the system, Creates a new Location object
     **/
    void insertLocation(int building_id) {
        /* Fix the defaultLocationId to the next set of 10s */
        this.defaultLocationId += 10;

        /* Locations have id's of 1010, 1020, 1030.. */
        /* Find the the locations vector inside the buildings' one */
        /* Add the location object to the inline vector of the building object */
        Objects.requireNonNull(buildings.stream() /* Avoid possible nullExceptions (REDUNDANT) */
                .filter(build -> build.getId() == building_id) /* Filter for the given id */
                .findAny() /* We know for sure that every element has a different id */
                .orElse(null)) /* Catch null pointer exceptions */
                .getLocations() /* Get the vector */
                .add(new Location(this.defaultLocationId)); /* Create a new Location object */
    }

    /**
     @func: updateCounters
     @desc: Update the readings of the sensors by creating random values of them
     **/
    void updateCounters(int building_id) {
        /* Find the the locations vector inside the buildings one */
        /* Avoid possible nullExceptions (REDUNDANT) */
        Vector<Location> locations = Objects.requireNonNull(buildings.stream()
                .filter(build -> build.getId() == building_id) /* Filter for the given id */
                .findAny() /* We know for sure that every element has a different id */
                .orElse(null)) /* Catch null pointer exceptions */
                .getLocations(); /* Get the vector */

        /* Generate random values according to rules */
        /* Update the files */
        if(locations.size() > 1) {
            /* Only write data to the file if we have at least 2 readings */
            /* That is done because we want to log the previous data before reading new ones */
            writer.writeToFile(data.toString());
            writer.closeFile();
        }

        data.delete(0, data.capacity()); /* Reset the string stream after writing data to the file */

        /* Update the values */
        locations.stream().forEach(loc -> {
            /* Use the specific accessors to set random data to the sensors and reliability values */

            /* Temperature: Random int between 0 and 100 */
            loc.setTemperatureValue(rand.generateRandom(100));

            /* Brightness: Random double between 0 and 200*/
            loc.setBrightnessValue(rand.generateRandom(200.0));

            /* Reliability: e^(L*time) where L = 10^(-3) and time is increasing after every sensor update */
            loc.setTemperatureReliabilityValue(Math.exp(-0.001 * loc.getTimeValue()));
            loc.setBrightnessReliabilityValue(Math.exp(-0.001 * loc.getTimeValue()));

            /* Messy code! */
            /* Create the data string by combining all data from the getters */
            data.append("Building: ").append(building_id).append("; ");
            data.append(loc).append(loc.getTemperature()).append(loc.getBrightness()); /* id, temp, bright */
            data.append(String.format("Total reliability: %.2f", loc.getTemperatureReliabilityValue() /* reliab */
                    * loc.getBrightnessReliabilityValue())).append("; ");
            data.append("Time: ").append(loc.getTimeValue()).append(";\n"); /* time */

            /* After updating sensors in the area we increment its time by 1 */
            loc.setTimeValue(loc.getTimeValue() + 1);
        });
    }

    /**
     @func: checkForFire
     @desc: Perform calculations to figure out if there's a fire or no
     **/
    void checkForFire(int building_id) {
        /* Signifies if there is a fire or not and carries it outside the loop */
        AtomicInteger flag = new AtomicInteger(0);

        /* We optionally print data to the terminal */
        System.out.print(data.toString());

        /*
        Extract needed values
        We have fire if:
            Temperature > 50
            Brightness > 140
            Total reliability = r1 * r2 > 0.9
        */
        /* Find the the locations vector inside the buildings one */
        Objects.requireNonNull(buildings.stream() /* Avoid possible nullExceptions (REDUNDANT) */
                .filter(build -> build.getId() == building_id) /* Filter for the given id */
                .findAny() /* We know for sure that every element has a different id */
                .orElse(null)) /* Catch null pointer exceptions */
                .getLocations().stream() /* Get the vector */

                /* This method allows for compartmentalization of function calls (Good for calling threads!) */
                .filter(loc -> loc.getTemperatureValue() > 50)
                .filter(loc -> loc.getBrightnessValue() > 140)
                .filter(loc -> loc.getTemperatureReliabilityValue()
                        * loc.getBrightnessReliabilityValue() > 0.9)
                .forEach(loc -> { /* Print out the filtered elements (Locations that are in fire) */
                    System.out.println("There is fire in a location, id: " + loc.getId());
                    flag.getAndIncrement(); /* Set the flag if there's a fire */
                });

        /* There is no fire if the flag is not set */
        if(flag.equals(new AtomicInteger(0))) System.out.println("There is no fire.");
    }

    /* OPTIONAL: WE IDEALLY DON'T USE THESE ACCESSORS */

    // public int getDefaultLocationId() {
    //     return this.defaultLocationId;
    // }

    // public void setDefaultLocationId(int defaultLocationId) {
    //     this.defaultLocationId = defaultLocationId;
    // }

    // public int getDefaultBuildingId() {
    //     return this.defaultBuildingId;
    // }

    // public void setDefaultBuildingId(int defaultBuildingId) {
    //     this.defaultBuildingId = defaultBuildingId
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

    //     /* Check if obj is an instance of SEPInterface */
    //     if(!(obj instanceof SEPInterface)) {
    //         return false;
    //     }

    //     /* Typecast obj to SEPInterface to compare members */
    //     SEPInterface fire = (SEPInterface)obj;
    //     return Integer.compare(this.defaultLocationId, fire.getDefaultLocationId()) == 0
    //     && Integer.compare(this.defaultBuildingId, fire.getDefaultBuildingId());
    // }
}
