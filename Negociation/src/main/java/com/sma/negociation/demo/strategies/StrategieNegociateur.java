package com.sma.negociation.demo.strategies;

import java.util.Random;

public abstract class StrategieNegociateur extends Strategie {

	protected static double TAUXMAXAUGMENTATION = 0;
	
	public StrategieNegociateur() {
		super();
		super.alea = new Random();
	}
}