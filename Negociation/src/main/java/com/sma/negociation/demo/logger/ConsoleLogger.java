package com.sma.negociation.demo.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class ConsoleLogger implements Logger {
    private static java.util.logging.Logger logger = getInstance();

    private static java.util.logging.Logger getInstance(){
        logger = java.util.logging.Logger.getLogger("console.log");
        ConsoleHandler ch;
        // This block configure the logger with handler and formatter
        ch = new ConsoleHandler();
        logger.addHandler(ch);
        logger.setUseParentHandlers(false);
        ch.setFormatter(new SimpleFormatter());
        return logger;
    }

    public static void logInfo(String log){
        logger.log(Level.INFO, LoggerUtil.infoString(log));
    }

    public static void logError(String log){
        logger.log(Level.SEVERE, LoggerUtil.errorString(log));
    }

    public static void logWarning(String log){
        logger.log(Level.WARNING, LoggerUtil.warningString(log));
    }
}
