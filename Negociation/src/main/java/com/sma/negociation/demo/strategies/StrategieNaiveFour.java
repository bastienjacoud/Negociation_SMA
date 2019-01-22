package com.sma.negociation.demo.strategies;

import com.sma.negociation.demo.agent.Preference;
import com.sma.negociation.demo.agent.Proposition;

public class StrategieNaiveFour extends StrategieFournisseur {
	
	public StrategieNaiveFour(Preference pPreferenceAgent) {
		super(pPreferenceAgent);
	}

	@Override
	protected Proposition contreProposition(Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse) {
		// Si l'augmentation du fournisseur est faible
		if((propositionPartieAdverse.getMontant_prop() * anciennePropositionAdverse.getMontant_prop())/propositionPartieAdverse.getMontant_prop() > TAUXMAXDIMINUTION) {
			return propositionPartieAdverse;
		}
		return new Proposition(preferenceAgent.getPrixDepNeg());
	}

	@Override
	protected boolean accepter(Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse, boolean estTermine) {
		if(propositionPartieAdverse.getMontant_prop() < this.preferenceAgent.getBudget())
			return false;
		else
			return true;
	}

	@Override
	protected boolean refuser(Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse, boolean estTermine) {
		return !accepter(propositionPartieAdverse, anciennePropositionAdverse, estTermine);
	}

}
