package com.sma.negociation.demo.strategies;

import com.sma.negociation.demo.agent.Preference;

public abstract class StrategieNegociateur extends Strategie {

	protected static double TAUXMAXAUGMENTATION = 0;
	
	public StrategieNegociateur(Preference pPreferenceAgent) {
		super(pPreferenceAgent);
	}
}