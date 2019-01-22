package com.sma.negociation.demo.agent;

import java.util.ArrayList;
import java.util.Date;

import com.sma.negociation.demo.compagnies.Compagnie;

public class Preference {
    private double budget;
    private ArrayList<Compagnie> compagnies;
    private Date dateVenteMax;
    private Date dateVenteMin;
    private double prixDepNeg;


    public Preference(double budget, ArrayList<Compagnie> compagnies, Date dateVenteMax, Date dateVenteMin, double prixDepNeg) {
        this.setBudget(budget);
        this.setCompagnies(compagnies);
        this.setDateVenteMax(dateVenteMax);
        this.setDateVenteMin(dateVenteMin);
        this.setPrixDepNeg(prixDepNeg);
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Date getDateVenteMax() {
        return dateVenteMax;
    }

    public void setDateVenteMax(Date dateVenteMax) {
        this.dateVenteMax = dateVenteMax;
    }

    public Date getDateVenteMin() {
        return dateVenteMin;
    }

    public void setDateVenteMin(Date dateVenteMin) {
        this.dateVenteMin = dateVenteMin;
    }

    public ArrayList<Compagnie> getCompagnies() {
        return compagnies;
    }

    public void setCompagnies(ArrayList<Compagnie> compagnies) {
        this.compagnies = compagnies;
    }

    public double getPrixDepNeg() {
        return prixDepNeg;
    }

    public void setPrixDepNeg(double prixDepNeg) {
        this.prixDepNeg = prixDepNeg;
    }
}
