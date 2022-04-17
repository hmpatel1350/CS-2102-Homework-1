package HW_3;

import java.util.LinkedList;

class Earthquake1 {
    Earthquake1(){}

    // checks whether a datum is a date
    boolean isDate(double anum) { return (int)anum > 10000000; }
    // extracts the month from an 8-digit date
    int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

    /**
     * Gets list of MaxHz of every day in a month
     * @param data List of Data
     * @param month Month 1-12 to get data for
     * @return LinkedList of MaxHzReports for the month
     *
     * Task Order:
     * 1. Create LinkedList of MaxHzReports
     * 2. Loop through the data and check if it is a date
     * 3. If it is a date in the correct month create a new HW_3.MaxHzReport with that date and add it to the LinkedList
     * 4. If it isn't a date check maxReading of most recent item in the LinkedList (or skip if there is currently
     *    no item in the LinkedList) and update the maxReading if the new data value is larger
     */
    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
        LinkedList<MaxHzReport> report = new LinkedList<>();
        int date = 0;
        for(double d: data){
            if(isDate(d)){
                date = extractMonth(d);
                if(month == date)
                    report.add(new MaxHzReport(d, Integer.MIN_VALUE));
            }else if(d >= 0 && report.size()>0 && date == month){
                report.getLast().maxReading = Double.max(report.getLast().maxReading, d);
            }
        }
        return report;
    }
}  

