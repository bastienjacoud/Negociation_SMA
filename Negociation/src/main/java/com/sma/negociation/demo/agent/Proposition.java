package com.sma.negociation.demo.agent;

public class Proposition {
    private double montant_prop;

    public Proposition(double montant_prop) {
        this.montant_prop = montant_prop;
    }

    public double getMontant_prop() {
        return montant_prop;
    }

    public void setMontant_prop(double montant_prop) {
        this.montant_prop = montant_prop;
    }
    
    public String toString() {
    	return "Montant : " + montant_prop;
    }
}
