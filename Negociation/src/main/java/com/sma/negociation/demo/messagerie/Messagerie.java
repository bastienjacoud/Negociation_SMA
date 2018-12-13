package com.sma.negociation.demo.messagerie;

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
    public static List<Message> getMessages(int idAgent){
        return messages.stream()
                .filter(m->(m.getEmetteur().getId() == idAgent && !m.isTraite()))
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
}