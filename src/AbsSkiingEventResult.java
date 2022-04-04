import java.util.LinkedList;

/**
 * Represents any skiing event
 *
 * @author ejstump Edward Stump
 * @author hmpatel Harsh Patel
 *
 */
public class AbsSkiingEventResult implements IEvent{

    private final int position;
    private final int penalties;
    private final LinkedList<Double> laps;

    public AbsSkiingEventResult(int position, double lap1, double lap2, double lap3, double lap4, int penalties) {
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
