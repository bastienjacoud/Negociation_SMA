package com.sma.negociation.demo.agent;

public abstract class Agent implements Runnable {
    Preference preference;
    protected Thread thread;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private static int compteur_id = 0;

    public Agent(Preference pPreferenceAgent) {
        this.id = compteur_id++;
        thread = new Thread(this);
        thread.start();
        preference = pPreferenceAgent;
    }

    @Override
    public abstract void run();
}
