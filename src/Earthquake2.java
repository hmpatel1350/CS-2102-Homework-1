import java.util.LinkedList;

class Earthquake2 {
    Earthquake2() {
    }

    // checks whether a datum is a date
    boolean isDate(double anum) {
        return (int) anum > 10000000;
    }

    // extracts the month from an 8-digit date
    int extractMonth(double dateNum) {
        return ((int) dateNum % 10000) / 100;
    }

    /**
     * @param data  the earthquake frequency data
     * @param month the month of interest
     * @return the max readings for each day that month present in the data
     * <p>
     * Task order:
     * 1. Create LinkedList of MaxHzReports
     * 2. Loop through the data until a date is found and it is of the relevant month
     * 3. Save the date
     * 4. Continue looping through the data until another date is found, indicating the end of the data for that date,
     * while updating the current maximum date
     * 5. Add the current date and max to the saved LinkedList, and return to step 2 to continue looping through data
     * 6. Return the LinkedList of MaxHzReports
     */
    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
        LinkedList<MaxHzReport> report = new LinkedList<>();

        for (int i = 0; i < data.size(); i++) {
            //check for date of interest
            if (isDate(data.get(i)) && extractMonth(data.get(i)) == month) {
                double currDay = data.get(i);

                i++;
                double currMax = 0;

                //date of interest is found, so until another date is found all data points are of interest
                while (i < data.size() && !isDate(data.get(i))) {

                    if (data.get(i) < 500) currMax = Math.max(data.get(i), currMax);
                    i++;
                }
                report.add(new MaxHzReport(currDay, currMax));
                /*
                because this is an index based for loop, as long as the index is updated correctly this kind of
                nested loop that isn't really nested is fine
                 */

                i--;
            }
        }

        return report;
    }
}