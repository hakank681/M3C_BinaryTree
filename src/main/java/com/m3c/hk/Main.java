package com.m3c.hk;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by alumniCurie07 on 11/10/2017.
 */
public class Main {

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args){

        initialiseLogging();
        LoggingExample loggingExample = new LoggingExample();
        loggingExample.setMessage("Welcome to logging");
        loggingExample.displayMessage();

        BinaryTreeStandard binaryTreeStandard = new BinaryTreeStandard();

    }

    public static void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        log.info("Logging initialised");
    }

}
