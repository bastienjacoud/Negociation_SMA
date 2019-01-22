package com.sma.negociation.demo.strategies;

import com.sma.negociation.demo.agent.Preference;
import com.sma.negociation.demo.agent.Proposition;

public abstract class Strategie {
	
	protected Preference preferenceAgent;

	/**
	 * Nouvelle proposition d'un prix
	 * @param propositionPartieAdverse Proposition de l'agent adverse
	 * @param anciennePropositionAdverse Proposition précédente de l'agent adverse
	 * @return Nouvelle proposition
	 */
    protected abstract Proposition contreProposition(Proposition propositionPartieAdverse, 
    		Proposition anciennePropositionAdverse);
    
    /**
     * Vérifie si la proposition peut être acceptée
	 * @param propositionPartieAdverse Proposition de l'agent adverse
	 * @param anciennePropositionAdverse Proposition précédente de l'agent adverse
	 * @param estTermine La negociation est terminé ou non
     * @return La proposition est accepté ou non
     */
    protected abstract boolean accepter(Proposition propositionPartieAdverse, 
    		Proposition anciennePropositionAdverse, boolean estTermine);
    /**
     * Vérifie si la proposition peut être refusée
	 * @param propositionPartieAdverse Proposition de l'agent adverse
	 * @param anciennePropositionAdverse Proposition précédente de l'agent adverse
	 * @param estTermine La negociation est terminé ou non
     * @return La proposition est refusée ou non
     */
    protected abstract boolean refuser(Proposition propositionPartieAdverse, 
    		Proposition anciennePropositionAdverse, boolean estTermine);
    /**
     * Application de la stratégie
	 * @param propositionPartieAdverse Proposition de l'agent adverse
	 * @param anciennePropositionAdverse Proposition précédente de l'agent adverse
	 * @param estTermine La negociation est terminé ou non
     * @return Nouvelle proposition
     */
    public Proposition reflexion(Proposition propositionPartieAdverse, 
    		Proposition anciennePropositionAdverse, boolean estTermine) {
    	
    	// Si la proposition remplit les critères attendues
    	if(accepter(propositionPartieAdverse, anciennePropositionAdverse, estTermine)) {
    		return propositionPartieAdverse;
    	}
    	
    	// Si la proposition remplit les critères de refus
    	if(refuser(propositionPartieAdverse, anciennePropositionAdverse, estTermine)) {
    		return null;
    	}
    	
    	// Si on arrive ici, on refuse dans tous les cas
    	if(estTermine) {
    		return null;
    	} else {
    		return contreProposition(propositionPartieAdverse, anciennePropositionAdverse);
    	}
    }
    
    public void setPreferenceAgent(Preference pPreference) {
    	preferenceAgent = pPreference;
    }
    
    public Preference getPreferenceAgent() {
    	return preferenceAgent;
    }
}