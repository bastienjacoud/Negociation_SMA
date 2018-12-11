package com.sma.negociation.demo.regles;

public class Regle {

    /**
     *
     * Attributs
     *
     */

    private static long tempsNegociation = 30;
    private static RegleProtocole regleProtocole = RegleProtocole.NONE;
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

    public static RegleProtocole getRegleProtocole() {
        return regleProtocole;
    }

    public static void setRegleProtocole(RegleProtocole regleProtocole) {
        Regle.regleProtocole = regleProtocole;
    }

    public static int getNbPropositionMax() {
        return nbPropositionMax;
    }

    public static void setNbPropositionMax(int nbPropositionMax) {
        Regle.nbPropositionMax = nbPropositionMax;
    }
}
