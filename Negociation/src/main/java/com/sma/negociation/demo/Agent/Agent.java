package com.sma.negociation.demo.agent;

public abstract class Agent implements Runnable{
    Preference preference;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private static int compteur_id = 0;

    public Agent() {
   this.id = compteur_id++;
    }

    @Override
    public abstract void run() ;
}
