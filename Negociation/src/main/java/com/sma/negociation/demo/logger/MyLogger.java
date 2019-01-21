package com.sma.negociation.demo.logger;


public class MyLogger {

    public static void logInfo(String log){
        ConsoleLogger.logInfo(log);
        FileLogger.logInfo(log);
    }

    public static void logError(String log){
        ConsoleLogger.logError(log);
        FileLogger.logError(log);
    }

    public static void logWarning(String log){
        ConsoleLogger.logWarning(log);
        FileLogger.logWarning(log);
    }
}
