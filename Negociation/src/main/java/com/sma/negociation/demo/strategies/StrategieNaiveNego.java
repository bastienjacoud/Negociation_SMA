package com.sma.negociation.demo.strategies;

public class StrategieNaiveNego extends StrategieNegociateur {

	public StrategieNaiveNego(double pValeurDepart) {
		super(pValeurDepart);
	}

	@Override
	public double reflexion(double prix) {
		// TODO Auto-generated method stub
				return 0;
	}

	@Override
	protected double contreProposition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean accepter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean refuser() {
		// TODO Auto-generated method stub
		return false;
	}

}
