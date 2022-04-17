package HW_3;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.LinkedList;

public class EarthquakeExamples {
    Earthquake1 E1 = new Earthquake1();
    LinkedList<Double> noData = new LinkedList<>();
    LinkedList<Double> threeDates = new LinkedList<>();
    LinkedList<Double> hasNeg = new LinkedList<>();
    LinkedList<Double> badBothSides = new LinkedList<>();
    LinkedList<MaxHzReport> NovReports = new LinkedList<>();
    LinkedList<MaxHzReport> hasNegReports = new LinkedList<>();
    LinkedList<MaxHzReport> badBothSidesReport = new LinkedList<>();

    public EarthquakeExamples() {
        threeDates.add(20151013.0);
        threeDates.add(10.0);
        threeDates.add(5.0);
        threeDates.add(20151020.0);
        threeDates.add(40.0);
        threeDates.add(50.0);
        threeDates.add(45.0);
        threeDates.add(20151101.0);
        threeDates.add(6.0);
        NovReports.add(new MaxHzReport(20151101.0, 6.0));

        hasNeg.add(20151013.0);
        hasNeg.add(-1.0);
        hasNeg.add(3.0);
        hasNeg.add(2.0);
        hasNeg.add(20151014.0);
        hasNeg.add(2.0);
        hasNeg.add(-3.0);
        hasNeg.add(20151017.0);
        hasNeg.add(-1.0);
        hasNeg.add(0.1);
        hasNeg.add(-2.0);
        hasNeg.add(1.0);

        badBothSides.add(20151013.0);
        badBothSides.add(1.0);
        badBothSides.add(-5.0);
        badBothSides.add(-1.0);
        badBothSides.add(20151113.0);
        badBothSides.add(1.0);
        badBothSides.add(4.0);
        badBothSides.add(100.0);
        badBothSides.add(20151115.0);
        badBothSides.add(4.0);
        badBothSides.add(-1.0);
        badBothSides.add(4.0);
        badBothSides.add(20151213.0);
        badBothSides.add(1.0);

        hasNegReports.add(new MaxHzReport(20151013.0, 3.0));
        hasNegReports.add(new MaxHzReport(20151014.0, 2.0));
        hasNegReports.add(new MaxHzReport(20151017.0, 1.0));
        badBothSidesReport.add(new MaxHzReport(20151113.0, 100));
        badBothSidesReport.add(new MaxHzReport(20151115.0, 4));


    }

    @Test
    public void instructorTestEQ() {
        assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
    }

    @Test
    public void testHasNegatives() {
        assertEquals(hasNegReports, E1.dailyMaxForMonth(hasNeg, 10));
    }

    @Test
    public void testNoCorrectMonth() {
        assertEquals(new LinkedList<MaxHzReport>(), E1.dailyMaxForMonth(hasNeg, 11));
    }

    @Test
    public void testEmpty() {
        assertEquals(new LinkedList<MaxHzReport>(), E1.dailyMaxForMonth(noData, 5));
    }

    @Test
    public void testBadMonthsOnBothSides() {
        assertEquals(badBothSidesReport, E1.dailyMaxForMonth(badBothSides, 11));
    }



  	/*
	Problem 2 Subtasks:
	1. Determine if data is for day or vibration
	2. Check if day is in correct month
	3. Get the largest vibration of that day
	4. Ignore negative vibrations
	5. Return list of the largest vibrations every day for the month
	 */

}
