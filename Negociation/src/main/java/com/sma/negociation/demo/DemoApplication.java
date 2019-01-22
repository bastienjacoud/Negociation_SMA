package com.sma.negociation.demo;

import com.sma.negociation.demo.agent.AgentFournisseur;
import com.sma.negociation.demo.agent.AgentNegociateur;
import com.sma.negociation.demo.agent.Preference;
import com.sma.negociation.demo.logger.ConsoleLogger;
import com.sma.negociation.demo.logger.MyLogger;
import com.sma.negociation.demo.regles.Concession;
import com.sma.negociation.demo.strategies.StrategieNaiveFour;
import com.sma.negociation.demo.strategies.StrategieNaiveNego;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	private static Mode modeInteraction = Mode.SIMPLE;

    public static void main(String[] args) {
    	MyLogger.logInfo("Démarrage");
        switch(modeInteraction) {
        case SIMPLE:       	
        	Preference prefNego = new Preference(500.0, null, null, null);
        	Preference prefFour = new Preference(1000.0, null, null, null);
        	
        	AgentFournisseur fournisseur = new AgentFournisseur(new StrategieNaiveFour(prefFour));
        	AgentNegociateur negociateur = new AgentNegociateur(new StrategieNaiveNego(prefNego));
        	
        	fournisseur.run();
        	negociateur.run();
        	break;
        case DEUX_NEGOCIATEURS:
        	break;
        case FOURNISSEURS_MULTIPLES:
        	break;
        case NEGOCATEURS_MULTIPLES:
        	break;
		default:
			break;
        }
    }
}
