package com.sma.negociation.demo;

import com.sma.negociation.demo.agent.AgentFournisseur;
import com.sma.negociation.demo.agent.AgentNegociateur;
import com.sma.negociation.demo.agent.Preference;
import com.sma.negociation.demo.logger.MyLogger;
import com.sma.negociation.demo.regles.Concession;
import com.sma.negociation.demo.regles.Regle;
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
			Preference prefNego1 = new Preference(6000, null, null, null, 2000);
			Preference prefNego2 = new Preference(7000, null, null, null, 3500);
			Preference prefFour1 = new Preference(4000, null, null, null, 10000);

			AgentFournisseur fournisseur1 = new AgentFournisseur(prefFour1, new StrategieNaiveFour());
			AgentNegociateur negociateur1 = new AgentNegociateur(prefNego1, new StrategieNaiveNego());
			AgentNegociateur negociateur2 = new AgentNegociateur(prefNego2, new StrategieNaiveNego());

			fournisseur1.run();
			negociateur1.run();
			negociateur2.run();
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
