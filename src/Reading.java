public class Reading {
    private Time time;
    private double temperature, rainfall;

    public Reading(Time time, double temperature, double rainfall) {
        this.time = time;
        this.temperature = temperature;
        this.rainfall = rainfall;
    }

    public Time getTime() {
        return time;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getRainfall() {
        return rainfall;
    }
}
