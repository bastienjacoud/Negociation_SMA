package com.sma.negociation.demo.strategies;

public abstract class StrategieNegociateur extends Strategie {

	protected static double TAUXMAXAUGMENTATION = 0;

    public StrategieNegociateur(double pValeurDepart) {
        super(pValeurDepart);
    }
}