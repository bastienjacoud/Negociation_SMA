package com.sma.negociation.demo.strategies;

public abstract class Strategie {
	
	protected double valeurDepart;
	
	public Strategie(double pValeurDepart) {
		valeurDepart = pValeurDepart;
	}

	/**
	 * Nouvelle proposition d'un prix
	 * @return Nouveau prix
	 */
    protected abstract double contreProposition();
    
    /**
     * Vérifie si la proposition peut être acceptée
     * @return La proposition est accepté ou non
     */
    protected abstract boolean accepter();
    /**
     * Vérifie si la proposition peut être refusée
     * @return La proposition est refusée ou non
     */
    protected abstract boolean refuser();
    /**
     * Application de la stratégie
     * @return Nouvelle proposition de prix
     */
    public abstract double reflexion(double prix);
}