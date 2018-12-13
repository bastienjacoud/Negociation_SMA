package com.sma.negociation.demo.strategies;

import com.sma.negociation.demo.agent.Preference;

public abstract class StrategieFournisseur extends Strategie {
	
	protected static double TAUXMAXDIMINUTION = 0;
	
	public StrategieFournisseur(Preference pPreferenceAgent) {
		super(pPreferenceAgent);
	}
	
}