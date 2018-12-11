package com.sma.negociation.demo.messagerie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Messagerie {
    private static List<Message> messages = new ArrayList<>();

    public static List<Message> getMessages(int idAgent){
        return messages.stream()
                .filter(m->m.getEmetteur().getId() == idAgent)
                .collect(Collectors.toList());
    }

    public static void addMessage(Message message){
        messages.add(message);
    }
}