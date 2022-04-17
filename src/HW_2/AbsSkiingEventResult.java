package HW_2;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Represents any skiing event
 *
 * @author ejstump Edward Stump
 * @author hmpatel Harsh Patel
 *
 */
public class AbsSkiingEventResult implements IEvent{

    int position;
    int penalties;
    LinkedList<Double> laps;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsSkiingEventResult that = (AbsSkiingEventResult) o;
        return position == that.position && penalties == that.penalties && Objects.equals(laps, that.laps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, penalties, laps);
    }
}

