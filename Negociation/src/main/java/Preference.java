import java.util.Date;

public class Preference {
    double budget = 0;
    Date dateVenteMax;
    Date dateVenteMin;

    public Preference(double budget, Date dateVenteMax, Date dateVenteMin) {
        this.budget = budget;
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
}
