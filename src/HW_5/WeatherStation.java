package HW_5;

import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherStation {
    LinkedList<Weather> dailyReports;

    public WeatherStation(Weather weather){
        dailyReports = new LinkedList<>();
    }


    public double averageMonthTemp(int month, int year){
        double avg = 0, count = 0;
        for(Weather twr: dailyReports){
            if(twr.getDate().get(GregorianCalendar.YEAR) == year && twr.getDate().get(GregorianCalendar.MONTH) == month){
                avg +=twr.averageRainfall();
                count++;
            }
        }

        if(count!=0)
            return avg/count;
        else return Integer.MIN_VALUE;

    }

    public double totalMonthRainfall(int month, int year){
        double count = 0;
        for(Weather twr: dailyReports){
            if(twr.getDate().get(GregorianCalendar.YEAR) == year && twr.getDate().get(GregorianCalendar.MONTH) == month){
                count +=twr.averageTemperature();
            }
        }
        return count;
    }

    public void addTodaysReport(GregorianCalendar date, LinkedList<Reading> readings){
        LinkedList<Double> rainfall = new LinkedList<>();
        LinkedList<Double> temp = new LinkedList<>();
        for(Reading r: readings){
            rainfall.add(r.getRainfall());
            rainfall.add(r.getTemperature());
        }
        TodaysWeatherReport report = new TodaysWeatherReport(date, temp, rainfall);
        dailyReports.add(report);
    }

}
