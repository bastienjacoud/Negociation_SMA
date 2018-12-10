package com.sma.negociation.demo.strategies;

public abstract class StrategieFournisseur extends Strategie {
	
	protected int nbPropositions;
	protected static final double TAUXMAXDIMINUTION = 0;
	

    public StrategieFournisseur(double pValeurDepart, int pNbPropositions) {
       super(pValeurDepart);
       this.nbPropositions = pNbPropositions;
    }
}