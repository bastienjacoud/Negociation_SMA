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
        MyLogger.logInfo("hello negociateur" + getId());
        System.out.println(preference);
        Proposition propositionDepart = new Proposition(preference.getPrixDepNeg());
        Messagerie.addMessage(new Message(TypeMessage.REQUETE, AgentFournisseur.agentFournisseurs.get(0), this, propositionDepart));

        // while condition d'arr
        while (!exit) {
            MyLogger.logInfo("Démarrage négociateur " + getId());

            if (!Messagerie.getMessages(this.getId()).isEmpty()) {
                boolean isNegTimeUp = isNegTimeUp(temps_dep_neg);
                Message message_recu = Messagerie.getMessages(this.getId()).get(Messagerie.getMessages(this.getId()).size() - 1);
                MyLogger.logInfo(message_recu.toString());
                Proposition nouvelleProposition = this.strategieNegociateur.reflexion(message_recu.getProposition(), Messagerie.getAncienneProposition(message_recu.getEmetteur().getId(), this.getId()), isNegTimeUp);
                if (nouvelleProposition == null || nouvelleProposition.equals(message_recu.getProposition())) stopAgent();
                else {
                    Messagerie.addMessage(new Message(TypeMessage.CONTRE_PROPOSITION, message_recu.getEmetteur(), this, nouvelleProposition));
                }
            }
        }
    }

    public void stopAgent() {
        exit = true;
    }

    private boolean isNegTimeUp(long temps_dep_neg) {
        return (TimeUnit.MILLISECONDS.toMinutes(temps_dep_neg - System.currentTimeMillis()) > 3);
    }
}
