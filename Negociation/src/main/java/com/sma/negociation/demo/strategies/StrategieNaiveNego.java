package com.sma.negociation.demo.strategies;

import com.sma.negociation.demo.agent.Preference;
import com.sma.negociation.demo.agent.Proposition;

public class StrategieNaiveNego extends StrategieNegociateur {

	public StrategieNaiveNego(double pValeurDepart) {
		super(pValeurDepart);
		TAUXMAXAUGMENTATION = 0.15;
	}
	
	@Override
	protected Proposition contreProposition(Preference preference, Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean accepter(Preference preference, Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse, boolean estTermine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean refuser(Preference preference, Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse, boolean estTermine) {
		// TODO Auto-generated method stub
		return false;
	}

}
