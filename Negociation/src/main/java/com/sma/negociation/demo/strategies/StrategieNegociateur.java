package com.sma.negociation.demo.strategies;

import java.util.Random;

public abstract class StrategieNegociateur extends Strategie {

	protected static double TAUXMAXAUGMENTATION = 1.3;
	
	public StrategieNegociateur() {
		super();
		super.alea = new Random();
	}
}