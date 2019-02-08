package com.sma.negociation.demo.agent;

import com.sma.negociation.demo.logger.MyLogger;
import com.sma.negociation.demo.messagerie.Message;
import com.sma.negociation.demo.messagerie.Messagerie;
import com.sma.negociation.demo.messagerie.TypeMessage;
import com.sma.negociation.demo.regles.Regle;
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

            if (Messagerie.haveMessages(getId())) {
                boolean isNegTimeUp = isNegTimeUp(temps_dep_neg); // Contrôle du temps restant
                Message message_recu = Messagerie.getLastMessage(getId());
                isNegTimeUp = isNegTimeUp || Messagerie.getMessages(this.getId()).size() > Regle.getNbPropositionMax(); // Controle du nombre de propositions
                MyLogger.logInfo(message_recu.toString());
                // Arret des discussions
                if(message_recu.getTypeMessage() == TypeMessage.ACK) {
                	
                	// Négociation réussie
                	if(message_recu.getProposition() != null) {
                		MyLogger.logInfo("[RESULTAT] Négociation réussi, confirmation du fournisseur : " + message_recu.getProposition());
                	} else {
                		MyLogger.logWarning("[RESULTAT] Refus du négociateur, arrêt de l'échange");
                	}
                	return;
                }
                Proposition nouvelleProposition = this.strategieFournisseur.reflexion(message_recu.getProposition(), 
                		Messagerie.getAncienneProposition(message_recu.getEmetteur().getId(), this.getId()), 
                		Messagerie.getAncienneProposition(this.getId(), message_recu.getEmetteur().getId()), isNegTimeUp);
                if (nouvelleProposition == null || nouvelleProposition.equals(message_recu.getProposition())) stopAgent(message_recu.getEmetteur(), nouvelleProposition);
                else {
                    Messagerie.addMessage(new Message(TypeMessage.CONTRE_PROPOSITION, message_recu.getEmetteur(), this, nouvelleProposition));
                }
                message_recu.setTraite(true);
            }
        }
    }

    public void stopAgent(Agent agentEmetteur, Proposition proposition) {
    	Messagerie.addMessage(new Message(TypeMessage.ACK, agentEmetteur, this, proposition));
        exit = true;
    }

    private boolean isNegTimeUp(long temps_dep_neg) {
        return (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - temps_dep_neg) > Regle.getTempsNegociation());
    }
}
