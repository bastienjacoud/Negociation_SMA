package com.sma.negociation.demo.messagerie;

import com.sma.negociation.demo.agent.Agent;
import com.sma.negociation.demo.agent.Proposition;

public class Message {

    /**
     *
     * ATTRIBUTS
     *
     */
    private static int compteurId = 0;
    private int idMessage;
    private TypeMessage typeMessage;
    private Agent recepteur;
    private Agent emetteur;
    private Proposition proposition;
    private boolean traite;

    /**
     *
     *  GETTER AND SETTER
     *
     */

    public TypeMessage getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(TypeMessage typeMessage) {
        this.typeMessage = typeMessage;
    }

    public Agent getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Agent recepteur) {
        this.recepteur = recepteur;
    }

    public Agent getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Agent emetteur) {
        this.emetteur = emetteur;
    }

    public Proposition getProposition() {
        return proposition;
    }

    public void setProposition(Proposition proposition) {
        this.proposition = proposition;
    }

    public boolean isTraite() {
        return traite;
    }

    public void setTraite(boolean traite) {
        this.traite = traite;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    /**
     *
     * CONSTRUCTOR
     *
     */

    public Message(TypeMessage typeMessage, Agent recepteur, Agent emetteur, Proposition proposition) {
        this.typeMessage = typeMessage;
        this.recepteur = recepteur;
        this.emetteur = emetteur;
        this.proposition = proposition;
        this.idMessage = compteurId++;
    }


    /**
     *
     * FUNCTIONS
     *
     */


}
