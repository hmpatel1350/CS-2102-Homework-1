package HW_5;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Examples {

    GregorianCalendar day1 = new GregorianCalendar(2022, 2, 15);

    private LinkedList<Double> getTestRainfall1 () {
        LinkedList<Double> test = new LinkedList<>();

        test.add(0.0);
        test.add(0.5);
        test.add(1.0);

        return test;
    }

    private LinkedList<Double> getTestRainfall2() {
        LinkedList<Double> test = new LinkedList<>();

        test.add(0.5);
        test.add(2.5);

        return test;
    }

    private LinkedList<Double> getTestTemp1(){
        LinkedList<Double> test = new LinkedList<>();

        test.add(75.0);
        test.add(74.0);
        test.add(76.0);

        return test;
    }

    private LinkedList<Double> getTestTemp2(){
        LinkedList<Double> test = new LinkedList<>();

        test.add(68.0);
        test.add(72.0);

        return test;
    }

    TodaysWeatherReport report1 = new TodaysWeatherReport(day1, getTestTemp1(), getTestRainfall1());
    TodaysWeatherReport report2 = new TodaysWeatherReport(day1, getTestTemp2(), getTestRainfall2());

    TodaysWeatherReport emptyReport = new TodaysWeatherReport(day1, new LinkedList<Double>(), new LinkedList<Double>());

    Reading r1 = new Reading(new Time(6, 0), 75.0, 1.0);
    Reading r2 = new Reading(new Time(12, 0), 70.0, 0.0);
    Reading r3 = new Reading(new Time(14, 0), 65.0, 0.5);
    Reading r4 = new Reading(new Time(20, 0), 80.0, 1.5);

    private LinkedList<Reading> getReadings1() {
        LinkedList<Reading> test = new LinkedList<>();

        test.add(r1);
        test.add(r2);

        return test;
    }

    private LinkedList<Reading> getReadings2() {
        LinkedList<Reading> test = new LinkedList<>();

        test.add(r2);
        test.add(r3);

        return test;
    }

    private LinkedList<Reading> getReadings3() {
        LinkedList<Reading> test = new LinkedList<>();

        test.add(r3);
        test.add(r4);

        return test;
    }

    private LinkedList<Reading> getReadings4() {
        LinkedList<Reading> test = new LinkedList<>();

        test.add(r1);
        test.add(r2);
        test.add(r3);
        test.add(r4);

        return test;
    }

    WeatherStation station = new WeatherStation(report1);

    public Examples() {
        station.addTodaysReport(new GregorianCalendar(2022, 2, 1), getReadings1());
        station.addTodaysReport(new GregorianCalendar(2022, 2, 2), getReadings2());
        station.addTodaysReport(new GregorianCalendar(2022, 2, 3), getReadings3());
        station.addTodaysReport(new GregorianCalendar(2022, 2, 4), getReadings3());
    }

    @Test
    public void testAvgRainfall() {
        assertEquals(report1.averageRainfall(), 0.5, 0.01);
    }

    @Test
    public void testAvgRainfall2() {
        assertEquals(report2.averageRainfall(), 1.5, 0.01);
    }

    @Test
    public void testAvgRainfallEmpty() {
        assertEquals(emptyReport.averageRainfall(), 0, 0.01);
    }

    @Test
    public void testAvgTemp() {
        assertEquals(report1.averageTemperature(), 75, 0.01);
    }

    @Test
    public void testAvgTemp2() {
        assertEquals(report2.averageTemperature(), 70, 0.01);
    }

    @Test
    public void testAvgTempEmpty() {
        assertEquals(emptyReport.averageTemperature(), 0, 0.01);
    }

    @Test
    public void testTotalMonthlyRainfall() {
        assertEquals(station.totalMonthRainfall(2, 2022), 143.875, 0.01);
    }

    @Test
    public void testAverageMonthlyTemp() {
        assertEquals(station.averageMonthTemp(2, 2022), 0, 0.01);
    }
}



