package com.sma.negociation.demo.agent;

import com.sma.negociation.demo.logger.MyLogger;
import com.sma.negociation.demo.messagerie.Message;
import com.sma.negociation.demo.messagerie.Messagerie;
import com.sma.negociation.demo.messagerie.TypeMessage;
import com.sma.negociation.demo.strategies.StrategieNegociateur;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class AgentNegociateur extends Agent {
    private volatile boolean exit = false;
    private StrategieNegociateur strategieNegociateur;

    public AgentNegociateur(Preference preference, StrategieNegociateur strategieNegociateur) {
        super(preference);
        this.strategieNegociateur = strategieNegociateur;
        this.strategieNegociateur.setPreferenceAgent(preference);
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
        //initier une negotiation
        MyLogger.logInfo("Négociateur (Agent n°" + getId() + ")  actif");
        Proposition propositionDepart = new Proposition(preference.getPrixDepNeg());
        Messagerie.addMessage(new Message(TypeMessage.REQUETE, AgentFournisseur.agentFournisseurs.get(0), this, propositionDepart));

        // while condition d'arr
        while (!exit) {
            if (Messagerie.haveMessages(getId())) {
                boolean isNegTimeUp = isNegTimeUp(temps_dep_neg);
                Message message_recu = Messagerie.getLastMessage(getId());
                MyLogger.logInfo(message_recu.toString());
                // Arret des discussions
                if (message_recu.getTypeMessage() == TypeMessage.ACK) {
                    stopAgent();
                    MyLogger.logWarning("Négociateur (Agent n°" + getId() + ")  terminé");

                    // Négociation réussie
                    if (message_recu.getProposition() != null) {
                        MyLogger.logInfo("[RESULTAT] Négociation réussi : " + message_recu.getProposition());
                    }
                    return;
                }
                Proposition nouvelleProposition = this.strategieNegociateur.reflexion(message_recu.getProposition(),
                        Messagerie.getAncienneProposition(message_recu.getEmetteur().getId(), this.getId()),
                        Messagerie.getAncienneProposition(this.getId(), message_recu.getEmetteur().getId()), isNegTimeUp);
                if (nouvelleProposition == null || nouvelleProposition.equals(message_recu.getProposition())) {
                    Messagerie.addMessage(new Message(TypeMessage.ACK, message_recu.getEmetteur(), this, nouvelleProposition));
                    if(nouvelleProposition == null) {
                        MyLogger.logWarning("Refus de la part du négociateur de la somme suivante :" + message_recu.getProposition().getMontant_prop() + ", la transaction était finie : " + isNegTimeUp(temps_dep_neg));
                    }
                    stopAgent();
                } else {
                    Messagerie.addMessage(new Message(TypeMessage.CONTRE_PROPOSITION, message_recu.getEmetteur(), this, nouvelleProposition));
                }
               message_recu.setTraite(true);
            }
        }
        MyLogger.logWarning("Négociateur (Agent n°" + getId() + ")  terminé");
    }

    public void stopAgent() {
        exit = true;
    }

    private boolean isNegTimeUp(long temps_dep_neg) {
        return (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - temps_dep_neg) > 10);
    }
}
