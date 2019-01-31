package com.sma.negociation.demo.logger;

import java.util.logging.*;

public class ConsoleLogger implements Logger {
    private static java.util.logging.Logger logger = getInstance();

    private static java.util.logging.Logger getInstance(){
        logger = java.util.logging.Logger.getLogger("console");
        logger.setUseParentHandlers(false);

        StreamHandler sh = new StreamHandler(System.err, new SimpleFormatter());
        logger.addHandler(sh);
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
