import java.util.GregorianCalendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherStation {
    LinkedList<TodaysWeatherReport> dailyReports;


    public double averageMonthTemp(int month, int year){
        double avg = 0, count = 0;
        for(TodaysWeatherReport twr: dailyReports){
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
        double avg = 0, count = 0;
        for(TodaysWeatherReport twr: dailyReports){
            if(twr.getDate().get(GregorianCalendar.YEAR) == year && twr.getDate().get(GregorianCalendar.MONTH) == month){
                avg +=twr.averageTemperature();
                count++;
            }
        }

        if(count!=0)
            return avg/count;
        else return Integer.MIN_VALUE;
    }

}
