/**
 Name: Athanasios Papapostolou
 AM  : 4147
 **/

import java.util.Scanner; /* new Scanner(), nextInt() */

/* Do not create accessors and overridden methods for composition data unless we create copy constructors */
/* Use composition as an object communication method throughout all classes */
/* Every copy constructor in each object performs a recursive deep copy of its elements */

/**
 @class: SEP
 @desc: Main class
 **/
public class SEP {
    /* Program setup */
    private static SEPInterface sep = new SEPInterface(); /* Main interface */
    private static Scanner s = new Scanner(System.in);

    /**
     @func: Main
     @desc: Manages the buildings
     @returns: The state of the program (0 for no errors, 1 for errors)
     **/
     private static int Main() {
        System.out.println("\n1) Display buildings with installed interfaces.");
        System.out.println("2) Insert a new building.");
        System.out.println("3) Install/Edit modules on a given building.");
        System.out.println("4) Exit.");
        System.out.print("Choose: ");

        /* Getting a string alleviates every input error considering integers */
        String arg = s.nextLine();
        switch(arg) {
            case "1": /* Display buildings */
                sep.showBuildings();
                break;
            case "2": /* Insert a new building */
                sep.insertBuilding();
                break;
            case "3": /* Install modules on a given building */
                System.out.print("Select a building id to install modules on, id: ");
                String inline_arg = s.nextLine(); /* Grab the building id we want to edit */
                /* Check if the given id exists in the building vector */
                try {
                    if (sep.checkForId(Integer.parseInt(inline_arg))) {
                        while(installModules(inline_arg) == 0) {
                            /* Create a similar loop for further menus */
                        }
                    } else { /* The id provided does not correspond to any building */
                        System.out.println("There is no building with such id.");
                    }
                }
                catch(Exception e) {
                    /* Catches integer parsing errors (The cases we input letters and such) */
                    System.out.println("There is no building with such id.");
                }
                break;
            case "4": /* Exit the program */
                return 1;
            default:
                return 0; /* Redo the loop */
            // return 1;
            /* return 1 if you want to exit the program on wrong input */
        }
        return 0;
    }

    /**
     @func: installModules
     @desc: Manages the buildings
     @returns: The state of the program (0 for no errors, 1 for errors)
     **/
    private static int installModules(String building_id) {
        System.out.println("\n1) Input a building location.");
        System.out.println("2) Update sensor readings.");
        System.out.println("3) Check for fire.");
        System.out.println("4) Back to main menu.");
        System.out.print("Choose: ");

        /* Getting a string alleviates every input error considering integers */
        String arg = s.nextLine();
        switch(arg) {
            case "1": /* Insert a new location */
                sep.insertLocation(Integer.parseInt(building_id));
                break;
            case "2": /* Update counters  */
                sep.updateCounters(Integer.parseInt(building_id));
                break;
            case "3": /* Check for a fire */
                sep.checkForFire(Integer.parseInt(building_id));
                break;
            case "4": /* Back to main menu */
                return 1;
            default:
                return 0; /* Redo the loop */
            // return 1;
            /* return 1 if you want to exit the program on wrong input */
        }
        return 0;
    }

    /**
     @main
     @desc: Executes the Main function
     **/
    public static void main(String[] args) {
        while(Main() == 0) {
            /* Indefinite loop */
        }
    }
}
