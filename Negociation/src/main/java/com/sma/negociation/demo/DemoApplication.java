package com.sma.negociation.demo;

import com.sma.negociation.demo.agent.AgentFournisseur;
import com.sma.negociation.demo.agent.AgentNegociateur;
import com.sma.negociation.demo.agent.Preference;
import com.sma.negociation.demo.logger.MyLogger;
import com.sma.negociation.demo.strategies.StrategieNaiveFour;
import com.sma.negociation.demo.strategies.StrategieNaiveNego;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	private static Mode modeInteraction = Mode.SIMPLE;

    public static void main(String[] args) {
    	MyLogger.logInfo("Démarrage");
        switch(modeInteraction) {
        case SIMPLE:       	
        	Preference prefNego = new Preference(6000, null, null, null, 2000);
        	Preference prefFour = new Preference(4000, null, null, null, 10000);
        	
        	AgentFournisseur fournisseur = new AgentFournisseur(prefFour, new StrategieNaiveFour());
        	AgentNegociateur negociateur = new AgentNegociateur(prefNego, new StrategieNaiveNego());
        	
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
