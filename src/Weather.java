import java.util.GregorianCalendar;

public interface Weather {
    public GregorianCalendar getDate();
    public double averageRainfall();
    public double averageTemperature();
}
