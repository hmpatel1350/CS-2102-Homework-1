package HW_5;

public class Reading {
    private final Time time;
    private final double temperature;
    private final double rainfall;

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
