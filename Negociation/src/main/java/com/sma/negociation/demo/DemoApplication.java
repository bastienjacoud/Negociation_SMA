package com.sma.negociation.demo;

import com.sma.negociation.demo.agent.AgentFournisseur;
import com.sma.negociation.demo.agent.AgentNegociateur;
import com.sma.negociation.demo.agent.Preference;
import com.sma.negociation.demo.logger.MyLogger;
import com.sma.negociation.demo.regles.Concession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	private static Mode modeInteraction = Mode.SIMPLE;

    public static void main(String[] args) {
        switch(modeInteraction) {
        case SIMPLE: 
        	AgentFournisseur fournisseur = new AgentFournisseur(null);
        	AgentNegociateur negociateur = new AgentNegociateur(null);
        	
        	Preference prefNego = new Preference(500.0, null, null, null);
        	Preference prefFour = new Preference(1000.0, null, null, null);
        	
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
