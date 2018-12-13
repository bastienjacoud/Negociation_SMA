package com.sma.negociation.demo.agent;

import com.sma.negociation.demo.strategies.StrategieFournisseur;

public class AgentFournisseur extends Agent {
    public StrategieFournisseur strategieFournisseur;
    public AgentFournisseur(StrategieFournisseur strategieFournisseur) {
        super();
        this.strategieFournisseur = strategieFournisseur;
    }

    @Override
    public void run() {

    }
}
