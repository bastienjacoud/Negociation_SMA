package com.sma.negociation.demo.strategies;

import com.sma.negociation.demo.agent.Preference;
import com.sma.negociation.demo.agent.Proposition;

public class StrategieNaiveNego extends StrategieNegociateur {

	@Override
	protected Proposition contreProposition(Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse, Proposition ancienneProposition) {
		double ancienneValeur = (ancienneProposition == null ? preferenceAgent.getPrixDepNeg() : ancienneProposition.getMontant_prop());
		
		if(anciennePropositionAdverse == null) {
			double moyenne = (preferenceAgent.getBudget() + preferenceAgent.getPrixDepNeg()) / 2;
			return new Proposition(moyenne + super.alea.nextDouble() * (preferenceAgent.getPrixDepNeg() - moyenne));
		}
		// Si l'augmentation du fournisseur est faible
		if(propositionPartieAdverse.getMontant_prop() / anciennePropositionAdverse.getMontant_prop() < TAUXMAXAUGMENTATION) {
			double ecart = propositionPartieAdverse.getMontant_prop() - ancienneValeur;
			double variableAugmentation = ecart / 2 + super.alea.nextDouble() * (ancienneValeur - (ecart/2));
			double res = ancienneValeur + variableAugmentation;

			// Garde-fous
			if(res > preferenceAgent.getBudget())
				res = preferenceAgent.getBudget();
			
			return new Proposition(res);
		}
		return new Proposition(ancienneValeur);
	}

	@Override
	protected boolean accepter(Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse, Proposition ancienneProposition, boolean estTermine) {
		return propositionPartieAdverse.getMontant_prop() <= this.preferenceAgent.getBudget();
	}

	@Override
	protected boolean refuser(Proposition propositionPartieAdverse, 
			Proposition anciennePropositionAdverse, Proposition ancienneProposition, boolean estTermine) {
		return propositionPartieAdverse.getMontant_prop() > this.preferenceAgent.getBudget() * 2;
	}

}
