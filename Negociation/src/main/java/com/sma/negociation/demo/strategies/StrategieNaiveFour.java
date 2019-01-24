package com.sma.negociation.demo.strategies;

import com.sma.negociation.demo.agent.Preference;
import com.sma.negociation.demo.agent.Proposition;

public class StrategieNaiveFour extends StrategieFournisseur {

	@Override
	protected Proposition contreProposition(Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse) {
		
		if(anciennePropositionAdverse == null) {
			double moyenne = (propositionPartieAdverse.getMontant_prop() + preferenceAgent.getPrixDepNeg()) / 2;
			return new Proposition(moyenne + super.alea.nextDouble() * (preferenceAgent.getPrixDepNeg() - moyenne));
		}
		// Si l'augmentation du fournisseur est faible
		if((propositionPartieAdverse.getMontant_prop() * anciennePropositionAdverse.getMontant_prop())/propositionPartieAdverse.getMontant_prop() > TAUXMAXDIMINUTION) {
			return propositionPartieAdverse;
		}
		return new Proposition(preferenceAgent.getPrixDepNeg());
	}

	@Override
	protected boolean accepter(Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse, boolean estTermine) {
		
		return propositionPartieAdverse.getMontant_prop() >= this.preferenceAgent.getPrixDepNeg();
	}

	@Override
	protected boolean refuser(Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse, boolean estTermine) {
		return propositionPartieAdverse.getMontant_prop() < this.preferenceAgent.getBudget() / 2;
	}

}
