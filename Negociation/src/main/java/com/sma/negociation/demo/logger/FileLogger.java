package com.sma.negociation.demo.logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import static org.springframework.boot.logging.LoggingSystemProperties.LOG_FILE;

@Configuration
@PropertySource("classpath:root/test.props")
public class FileLogger implements Logger {
    private static java.util.logging.Logger logger = getInstance();

    private static java.util.logging.Logger getInstance(){
        logger = java.util.logging.Logger.getLogger("file.log");
        FileHandler fh;
        
        logger.setUseParentHandlers(false);
        Handler[] handlers = logger.getHandlers();
        for(Handler handler : handlers)
        {
                if(handler.getClass() == FileHandler.class)
                    logger.removeHandler(handler);
        }
        
        try{
            // This block configure the logger with handler and formatter
            fh = new FileHandler("log.txt");       
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh); 
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
