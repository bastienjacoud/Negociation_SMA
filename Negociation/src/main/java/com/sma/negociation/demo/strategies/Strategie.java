package com.sma.negociation.demo.strategies;

import java.util.Random;

import com.sma.negociation.demo.agent.Preference;
import com.sma.negociation.demo.agent.Proposition;

public abstract class Strategie {
	
	protected Preference preferenceAgent;
	protected Random alea;

	/**
	 * Nouvelle proposition d'un prix
	 * @param propositionPartieAdverse Proposition de l'agent adverse
	 * @param anciennePropositionAdverse Proposition précédente de l'agent adverse
	 * @param ancienneProposition Ptroposition précédente de l'agent
	 * @return Nouvelle proposition
	 */
    protected abstract Proposition contreProposition(Proposition propositionPartieAdverse, 
    		Proposition anciennePropositionAdverse, Proposition ancienneProposition);
    
    /**
     * Vérifie si la proposition peut être acceptée
	 * @param propositionPartieAdverse Proposition de l'agent adverse
	 * @param anciennePropositionAdverse Proposition précédente de l'agent adverse
	 * @param ancienneProposition Proposition précédente de l'agent
	 * @param estTermine La negociation est terminé ou non
     * @return La proposition est accepté ou non
     */
    protected abstract boolean accepter(Proposition propositionPartieAdverse, 
    		Proposition anciennePropositionAdverse, Proposition ancienneProposition, boolean estTermine);
    /**
     * Vérifie si la proposition peut être refusée
	 * @param propositionPartieAdverse Proposition de l'agent adverse
	 * @param anciennePropositionAdverse Proposition précédente de l'agent adverse
	 * @param ancienneProposition Proposition précédente de l'agent
	 * @param estTermine La negociation est terminé ou non
     * @return La proposition est refusée ou non
     */
    protected abstract boolean refuser(Proposition propositionPartieAdverse, 
    		Proposition anciennePropositionAdverse, Proposition ancienneProposition, boolean estTermine);
    /**
     * Application de la stratégie
	 * @param propositionPartieAdverse Proposition de l'agent adverse
	 * @param anciennePropositionAdverse Proposition précédente de l'agent adverse
	 * @param ancienneProposition Proposition précédente de l'agent
	 * @param estTermine La negociation est terminé ou non
     * @return Nouvelle proposition
     */
    public Proposition reflexion(Proposition propositionPartieAdverse, 
    		Proposition anciennePropositionAdverse, Proposition ancienneProposition, boolean estTermine) {
    	
    	// Si la proposition remplit les critères attendues
    	if(accepter(propositionPartieAdverse, anciennePropositionAdverse, ancienneProposition, estTermine)) {
    		return propositionPartieAdverse;
    	}
    	
    	// Si la proposition remplit les critères de refus
    	if(refuser(propositionPartieAdverse, anciennePropositionAdverse, ancienneProposition, estTermine)) {
    		return null;
    	}
    	
    	// Si on arrive ici, on refuse dans tous les cas
    	if(estTermine) {
    		System.out.println("FINIIIIIII");
    		return null;
    	} else {
    		return contreProposition(propositionPartieAdverse, anciennePropositionAdverse, ancienneProposition);
    	}
    }
    
    public void setPreferenceAgent(Preference pPreference) {
    	preferenceAgent = pPreference;
    }
    
    public Preference getPreferenceAgent() {
    	return preferenceAgent;
    }
}