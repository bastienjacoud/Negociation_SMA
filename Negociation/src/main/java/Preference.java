import java.util.ArrayList;
import java.util.Date;

public class Preference {
    private double budget;
    private ArrayList<Compagnie> compagnies;
    private Date dateVenteMax;
    private Date dateVenteMin;
    private double prixDepNeg;
    

    public Preference(double budget, ArrayList<Compagnie> compagnies, Date dateVenteMax, Date dateVenteMin) {
        this.budget = budget;
        this.compagnies = compagnies;
        this.dateVenteMax = dateVenteMax;
        this.dateVenteMin = dateVenteMin;
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
}
