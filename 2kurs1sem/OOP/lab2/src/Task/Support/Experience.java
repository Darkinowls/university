package Task.Support;

public class  Experience {
    private int months;
    private int years;

    public int getMonths() { return months; }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getExperienceInMonths(){
        return getMonths() + 12 * getYears();
    }

}
