package com.sma.negociation.demo.logger;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import static org.springframework.boot.logging.LoggingSystemProperties.LOG_FILE;

public class MyLogger {

    private static Logger logger  = getInstance();

    private static Logger getInstance(){
        logger = Logger.getLogger(LOG_FILE);
        FileHandler fh;
        try{
            // This block configure the logger with handler and formatter
            fh = new FileHandler(LOG_FILE);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logger;
    }

    public static void logInfo(String log){
        logger.log(Level.INFO, log);
    }

    public static void logError(String log){
        logger.log(Level.SEVERE, log);
    }

    public static void logWarning(String log){
        logger.log(Level.WARNING, log);
    }
}
