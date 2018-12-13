package com.sma.negociation.demo.regles;

public abstract class RegleProtocole {

    /**
     *
     * ATTRIBUTS
     *
     */

    protected double seuil;
    protected int ratio;


    /**
     *
     * GETTERS AND SETTERS
     *
     */

    public double getSeuil() {
        return seuil;
    }

    public void setSeuil(double seuil) {
        this.seuil = seuil;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    /**
     *
     * CONSTRUCTORS
     *
     */

    public RegleProtocole(double seuil, int ratio) {
        this.seuil = seuil;
        this.ratio = ratio;
    }

    public RegleProtocole(){
    }
}
