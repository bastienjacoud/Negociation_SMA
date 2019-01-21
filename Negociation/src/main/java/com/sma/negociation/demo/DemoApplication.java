package com.sma.negociation.demo;

import com.sma.negociation.demo.logger.MyLogger;
import com.sma.negociation.demo.regles.Concession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {

        MyLogger.logInfo("ça fonctionne");
        MyLogger.logError("Il y a une erreur");
        MyLogger.logWarning("Avertissement !!!");
    }
}
