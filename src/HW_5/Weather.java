package HW_5;

import java.util.GregorianCalendar;

public interface Weather {
    GregorianCalendar getDate();
    double averageRainfall();
    double averageTemperature();
}
