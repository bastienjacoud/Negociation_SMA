package com.sma.negociation.demo.regles;

public class Regle {

    /**
     *
     * Attributs
     *
     */

    private static long tempsNegociation = 500;
    private static RegleProtocole1 regleProtocole = RegleProtocole1.NONE;
    private static int nbPropositionMax = 5;

    /**
     *
     * GETTERS AND SETTERS
     *
     */

    public static long getTempsNegociation() {
        return tempsNegociation;
    }

    public static void setTempsNegociation(long tempsNegociation) {
        Regle.tempsNegociation = tempsNegociation;
    }

    public static RegleProtocole1 getRegleProtocole() {
        return regleProtocole;
    }

    public static void setRegleProtocole(RegleProtocole1 regleProtocole) {
        Regle.regleProtocole = regleProtocole;
    }

    public static int getNbPropositionMax() {
        return nbPropositionMax;
    }

    public static void setNbPropositionMax(int nbPropositionMax) {
        Regle.nbPropositionMax = nbPropositionMax;
    }
}
