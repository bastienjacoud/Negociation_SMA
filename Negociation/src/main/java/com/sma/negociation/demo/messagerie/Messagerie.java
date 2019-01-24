package com.sma.negociation.demo.messagerie;

import com.sma.negociation.demo.agent.Proposition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Messagerie {
    /**
     * Liste de messages à traiter
     */
    private static List<Message> messages = new ArrayList<>();

    /**
     * Retourne la liste des messages non traités concernant l'agent
     * @param idAgent
     * @return Liste de messages de l'agent.
     */
    public static synchronized List<Message> getMessages(int idAgent){
        return messages.stream()
                .filter(m->(m.getRecepteur().getId() == idAgent && !m.isTraite()))
                .collect(Collectors.toList());
    }

    /**
     * Ajouter un message
     * @param message
     */
    public static void addMessage(Message message){
        messages.add(message);
    }

    /**
     * Supprimer un message
     * @param message
     */
    public static void deleteMessage(Message message){
        messages.remove(message);
    }

    public static Proposition getAncienneProposition(int id_emetteur, int id_recepteur){
        List<Message> messages = Messagerie.getMessages(id_recepteur).
                stream()
                .filter(m -> m.getEmetteur().getId() == id_emetteur)
                .collect(Collectors.toList());
        if(messages.size() >= 2) {
            return messages.get(messages.size() - 2).getProposition();
        }return null;
    }
}