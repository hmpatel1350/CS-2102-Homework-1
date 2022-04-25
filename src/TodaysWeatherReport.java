import java.util.GregorianCalendar;
import java.util.LinkedList;

public class TodaysWeatherReport {
    private GregorianCalendar date;
    private LinkedList<Double> temperature;
    private LinkedList<Double> rainfall;


    public TodaysWeatherReport(GregorianCalendar date, LinkedList<Double> temperature, LinkedList<Double> rainfall) {
        this.date = date;
        this.temperature = temperature;
        this.rainfall = rainfall;
    }

    public double averageRainfall(){
        double avg = 0, count = 0;
        for(Double d: rainfall){
            avg+=d;
            count++;
        }
        if(count!=0)
            return avg/count;
        else return 0;
    }

    public double averageTemperature(){
        double avg = 0, count = 0;
        for(Double d: temperature){
            avg+=d;
            count++;
        }
        if(count!=0)
            return avg/count;
        else return 0;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public LinkedList<Double> getTemperature() {
        return temperature;
    }

    public LinkedList<Double> getRainfall() {
        return rainfall;
    }
}
