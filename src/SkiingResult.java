import java.util.LinkedList;

public class SkiingResult implements IEvent {
    private int position;
    private int penalties;
    private LinkedList<Double> laps;

    public SkiingResult(int position, double lap1, double lap2, double lap3, double lap4, int penalties) {
        this.position = position;
        laps = new LinkedList<>();
        laps.add(lap1);
        laps.add(lap2);
        laps.add(lap3);
        laps.add(lap4);
        this.penalties = penalties;
    }

    @Override
    public double pointsEarned() {
        double sum = 0;
        for(double d: laps)
            sum+=d;
        return sum;
    }

    @Override
    public double getPenalties() {
        return 5 * penalties;
    }

    public int getPosition() {
        return position;
    }
}
