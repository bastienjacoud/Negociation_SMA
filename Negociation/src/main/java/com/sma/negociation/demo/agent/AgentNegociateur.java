package com.sma.negociation.demo.agent;

import com.sma.negociation.demo.strategies.StrategieNegociateur;

public class AgentNegociateur extends Agent {
    private StrategieNegociateur strategieNegociateur;

    public AgentNegociateur(StrategieNegociateur strategieNegociateur) {
        super();
        this.strategieNegociateur = strategieNegociateur;
    }

    public StrategieNegociateur getStrategieNegociateur() {
        return strategieNegociateur;
    }

    public void setStrategieNegociateur(StrategieNegociateur strategieNegociateur) {
        this.strategieNegociateur = strategieNegociateur;
    }

    @Override
    public void run() {
        long temps_dep_neg = System.currentTimeMillis();
        long temps_courant = 0;
        // while condition d'arr
        while (true) {
            //calculer la diff de temps avt l'envoi du message pour savoir si on stoppe
            temps_courant = System.currentTimeMillis();
        }

    }
}
