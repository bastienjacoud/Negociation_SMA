package com.sma.negociation.demo.agent;

import com.sma.negociation.demo.logger.MyLogger;
import com.sma.negociation.demo.messagerie.Message;
import com.sma.negociation.demo.messagerie.Messagerie;
import com.sma.negociation.demo.messagerie.TypeMessage;
import com.sma.negociation.demo.strategies.StrategieFournisseur;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AgentFournisseur extends Agent {
    private volatile boolean exit = false;
    public StrategieFournisseur strategieFournisseur;
    public static ArrayList<AgentFournisseur> agentFournisseurs = new ArrayList<>();

    public AgentFournisseur(Preference preference, StrategieFournisseur strategieFournisseur) {
        super(preference);
        this.strategieFournisseur = strategieFournisseur;
        this.strategieFournisseur.setPreferenceAgent(preference);
        agentFournisseurs.add(this);
    }

    @Override
    public void run() {
        MyLogger.logInfo("Fournisseur (Agent n°" + getId() + ")  actif");

        long temps_dep_neg = System.currentTimeMillis();
        // while condition d'arr
        while (!exit) {

            if (!Messagerie.getMessages(this.getId()).isEmpty()) {
                boolean isNegTimeUp = isNegTimeUp(temps_dep_neg);
                Message message_recu = Messagerie.getMessages(this.getId()).get(Messagerie.getMessages(this.getId()).size() - 1);
                MyLogger.logInfo(message_recu.toString());
                Proposition nouvelleProposition = this.strategieFournisseur.reflexion(message_recu.getProposition(), Messagerie.getAncienneProposition(message_recu.getEmetteur().getId(), this.getId()), isNegTimeUp);
                if (nouvelleProposition == null || nouvelleProposition.equals(message_recu.getProposition())) stopAgent(message_recu.getEmetteur(), message_recu.getProposition());
                else {
                    Messagerie.addMessage(new Message(TypeMessage.CONTRE_PROPOSITION, message_recu.getEmetteur(), this, nouvelleProposition));
                }
            }
        }
    }

    public void stopAgent(Agent agentEmetteur, Proposition proposition) {
    	Messagerie.addMessage(new Message(TypeMessage.ACK, agentEmetteur, this, proposition));
        exit = true;
    }

    private boolean isNegTimeUp(long temps_dep_neg) {
        return (TimeUnit.MILLISECONDS.toMinutes(temps_dep_neg - System.currentTimeMillis()) > 3);
    }
}
