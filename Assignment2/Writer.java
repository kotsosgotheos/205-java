/**
 Name: Athanasios Papapostolou
 AM  : 4147
 **/

import java.io.FileWriter; /* new Writer(), .write(), .flush(), .close() */

/**
 @class: Writer
 @desc: Describes the functions of writing data to a file
 **/
class Writer {
    /* FileWriter object */
    private FileWriter writer;

    /**
     @Constructor
     @desc: Create a deep copy of the object passed
     **/

    /* Ideally we don't create a copy of this */
    // Writer(Writer original) {
    // 	this.writer = new FileWriter("measures.txt");
    // }

    /**
     @Constructor
     @desc: Create a basic writer object
     **/
    Writer() {
        /* Write data to measures.txt located on the same directory as our main class */
        try {
            this.writer = new FileWriter("measures.txt");
        }
        catch(Exception e) {
            // System.out.println(e); /* Swallow the error */
        }
    }

    /**
     @func: writeToFile
     @desc: Write data to file (NOT APPEND)
     @params: data -> A string that contains present data about sensor readings
     **/
    void writeToFile(String data) {
        try {
            /* Reset the file stream */
            this.writer = new FileWriter("measures.txt");
            writer.write(data); /* Needs to be converted/downcast */
        }
        catch(Exception e) { /* Catch out any exceptions and optionally print them to the terminal */
            // System.out.println(e); /* Swallow the error */
        }
    }

    /**
     @func: closeFile
     @desc: Close the file after flushing the data out of the writer object
     **/
    void closeFile() {
        try {
            writer.flush(); /* Flush data from file descriptor */
            writer.close(); /* Close the file descriptor */
        }
        catch(Exception e) { /* Catch out any exceptions and optionally print them to the terminal */
            // System.out.println(e); /* Swallow the error */
        }
    }

    /* OPTIONAL: WE IDEALLY DON'T USE THESE ACCESSORS */

    // FileWriter getWriter() {
    // 	return this.writer;
    // }

    // void setWriter(FileWriter writer) {
    // 	this.writer = writer;
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

    //     /* Check if obj is an instance of Writer */
    //     if(!(obj instanceof Writer)) {
    //         return false; 
    //     }

    //     /* Typecast obj to Writer to compare members */
    //     Writer fire = (Writer)obj;
    //     return this.writer == fire.getWriter();
    // }
}