package com.sma.negociation.demo.strategies;

import java.util.Random;

public abstract class StrategieFournisseur extends Strategie {
	
	protected static double TAUXMAXDIMINUTION = 1.3;
	
	public StrategieFournisseur() {
		super();
		super.alea = new Random();
	}
	
}